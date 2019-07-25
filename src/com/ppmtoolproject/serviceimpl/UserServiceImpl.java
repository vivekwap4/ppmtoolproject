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
	public void updateUser(User project) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUser(String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		return null;
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
	
	public User login(String email, String password){
		User loggingInUser = getUser(email);
		if(loggingInUser == null) {
			System.out.println("can't find user");
			return null;
		}
		if(!validatePassword(loggingInUser.getPassword(), password)) {
			System.out.println("wrong password");
			return null;
		}
		return loggingInUser;
	}

}
