package com.ppmtoolproject.service;

import java.util.List;

import com.ppmtoolproject.domain.User;
import com.ppmtoolproject.exception.PasswordUnmatchException;
import com.ppmtoolproject.exception.UserNotFoundException;

public interface UserService {
	void createUser(User user);

	void updateUser(User project);

	void removeUser(String email);

	User getUser(String email);

	List<User> getAllUsers();
	
	boolean validatePassword(String originalPassword, String confirmPassword);

	User login(String email, String password);
}
