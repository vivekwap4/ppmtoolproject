package com.ppmtoolproject.Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ppmtoolproject.domain.User;
import com.ppmtoolproject.service.UserService;
import com.ppmtoolproject.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class UserLoginController
 */
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet {
	
	UserService service = null;
	private static final long serialVersionUID = 1L;
     
    public UserLoginController() {
        this.service = new UserServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			if(service.authenticate(request.getParameter("email"), request.getParameter("password"))){
				System.out.println("Inside the try block of doPost" + request.getParameter("email") + " " + request.getParameter("password"));
				User loggedInUser = new User();
				loggedInUser = service.getUser(request.getParameter("email"));
				System.out.println("The email of logged in user is : "+service.getUser(request.getParameter("email")));
				boolean create = true;
				HttpSession session = request.getSession(create);
				session.setAttribute("userEmail", loggedInUser.getEmail());
				session.setAttribute("userName", loggedInUser.getName());
				response.sendRedirect("dashboard.jsp?type=" + session.getAttribute("userEmail")+"+"+ session.getAttribute("userName"));
			}
			else{
				response.sendRedirect("login.jsp?msg=Please check username/password");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
