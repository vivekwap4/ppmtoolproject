package com.ppmtoolproject.Controller;

import java.io.IOException;

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
		// TODO Auto-generated method stub
		User user = new User();
		
		try {
			if(service.validatePassword(request.getParameter("user_password"), request.getParameter("user_password2"))){
				user.setName(request.getParameter("user_name"));
				user.setEmail(request.getParameter("user_email"));
				user.setPassword(request.getParameter("user_password"));
				user.setUserType(request.getParameter("user_type"));	
			}else {
				
			}
		} catch (PasswordUnmatchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//Now use the request.getParameter() method to get the form parameters from the request. This method is invoked after user
		// clicks submit on the registration form
		
		
		
	}

}
