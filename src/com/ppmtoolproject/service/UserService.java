package com.ppmtoolproject.service;

import java.util.List;

import com.ppmtoolproject.domain.User;
import com.ppmtoolproject.exception.PasswordMismatchException;

public interface UserService {
	void createUser(User user);

	void updateUser(User user);

	void removeUser(String email);

	User getUser(String email);

	List<User> getAllUsers();
	
	boolean validatePassword(String originalPassword, String confirmPassword) throws PasswordMismatchException;
	
	boolean authenticate(String email, String password);
	
	boolean checkEmail(String email);
}
