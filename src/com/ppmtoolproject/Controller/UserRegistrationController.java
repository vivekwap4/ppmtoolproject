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
		
			if(service.validatePassword(request.getParameter("user_password"), request.getParameter("user_password2"))){
				user.setName(request.getParameter("user_name"));
				user.setEmail(request.getParameter("user_email"));
				user.setPassword(request.getParameter("user_password"));
				user.setUserType(request.getParameter("user_type"));	
				
				System.out.println("The user email is in doPost and the value is "+user.getEmail());
				
				if(!service.checkEmail(request.getParameter("user_email"))) {
					System.out.println("Inside the second if of doPost "+service.checkEmail(request.getParameter("user_email")));
					service.createUser(user);
					response.sendRedirect("./login.jsp?msg=User created successfully");
				}
				else {
					response.sendRedirect("./register.jsp?msg= Email already exists");
				}
			
			}else {
				response.sendRedirect("./register.jsp?msg=Passwords do not match");
			}
		
	}

}
