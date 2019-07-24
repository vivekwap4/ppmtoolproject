package com.ppmtoolproject.serviceimpl;

import java.util.List;

import com.ppmtoolproject.dao.UserDAO;
import com.ppmtoolproject.daoimpl.UserDAOImpl;
import com.ppmtoolproject.domain.User;
import com.ppmtoolproject.exception.PasswordUnmatchException;
import com.ppmtoolproject.exception.UserNotFoundException;
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
		return userDao.findByEmail(email);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	@Override
	public boolean validatePassword(String originalPassword, String confirmPassword) throws PasswordUnmatchException {
		if(originalPassword.equals(confirmPassword)) return true;
		else throw new PasswordUnmatchException("Passwords do not match. Please recheck.");
	}
	
	
	@Override
	public User login(String email, String password) throws PasswordUnmatchException, UserNotFoundException{
		User user = getUser(email);
		if(user == null) {
			throw new UserNotFoundException("Email was not found");
		}
		if(!validatePassword(user.getPassword(), password)) return null;
		return user;
	}
}
