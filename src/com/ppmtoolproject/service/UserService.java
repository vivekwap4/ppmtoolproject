package com.ppmtoolproject.service;

import java.util.List;

import com.ppmtoolproject.domain.User;

public interface UserService {
	void createUser(User user);

	void updateUser(User project);

	void removeUser(String email);

	User getUser(String email);

	List<User> getAllUsers();
}
