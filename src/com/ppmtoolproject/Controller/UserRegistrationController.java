package com.ppmtoolproject.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ppmtoolproject.domain.User;
import com.ppmtoolproject.exception.PasswordUnmatchException;
import com.ppmtoolproject.service.UserService;
import com.ppmtoolproject.serviceimpl.UserServiceImpl;

/**
 * Servlet implementation class UserRegistrationController
 */
@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {

	UserService service = null;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationController() {
        this.service = new UserServiceImpl();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = new User();
		
			if(service.validatePassword(request.getParameter("user_password"), request.getParameter("user_password2"))
					&& !service.checkEmail(request.getParameter("user_email"))){
				user.setName(request.getParameter("user_name"));
				user.setEmail(request.getParameter("user_email"));
				user.setPassword(request.getParameter("user_password"));
				user.setUserType(request.getParameter("user_type"));	
				service.createUser(user);
				
				
			}else {
				
				
				response.sendRedirect("./register.jsp?msg=Passwords do not match");
				
				
			}
		
	}

}
