package com.ppmtoolproject.serviceimpl;

import java.util.List;

import com.ppmtoolproject.dao.UserDAO;
import com.ppmtoolproject.daoimpl.UserDAOImpl;
import com.ppmtoolproject.domain.User;
import com.ppmtoolproject.exception.PasswordUnmatchException;
import com.ppmtoolproject.service.UserService;

public class UserServiceImpl extends UserDAOImpl implements UserService{

	UserDAO userDao = null;
	
	public UserServiceImpl(){
		this.userDao = new UserDAOImpl();
	}
	
	@Override
	public void createUser(User user) {
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return userDao.findByEmail(email);
	}

	@Override
	public List<User> getAllUsers() { 
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean validatePassword(String originalPassword, String confirmPassword) {
		if(originalPassword.equals(confirmPassword)) return true;
		else return false;
	}
	
	@Override
	public boolean checkEmail(String email) {
		
		User searchForUser = new User();
		searchForUser = userDao.findByEmail(email);

		System.out.println("The user email is in checkEmail and the value is "+email);
		

		if(searchForUser != null) {
			System.out.println("Inside the if of checkEmail ");
			 return true;
		}
		return false;
	}
	
	public boolean authenticate(String email, String password){
		User loggingInUser = userDao.findByEmail(email);
		System.out.println("Logging in user is " +loggingInUser.getEmail());
		System.out.println("Logging in user's password is " +loggingInUser.getPassword());
//		if(loggingInUser == null) {
//			System.out.println("can't find user");
//			return false;
//		}else 
		if(loggingInUser == null) return false;
		
		if(loggingInUser.getPassword().equals(password)){
			return true;
		}
		return false;
	}
}
