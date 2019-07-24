package com.ppmtoolproject.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ppmtoolproject.dao.UserDAO;
import com.ppmtoolproject.daoimpl.UserDAOImpl;
import com.ppmtoolproject.domain.User;

/**
 * Servlet implementation class UserRegistrationController
 */
@WebServlet("/UserRegistrationController")
public class UserRegistrationController extends HttpServlet {
	UserDAO userDao = new UserDAOImpl();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		User user = new User();
		
		user.setName(request.getParameter("user_name"));
		user.setEmail(request.getParameter("user_email"));
		user.setPassword(request.getParameter("user_password"));
		user.setUserType(request.getParameter("user_type"));

		
		userDao.save(user);
//		doGet(request, response);
		
		//Now use the request.getParameter() method to get the form parameters from the request. This method is invoked after user
		// clicks submit on the registration form
		
		
		
	}

}
