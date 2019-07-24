package com.ppmtoolproject.dao;

import java.util.List;

import com.ppmtoolproject.domain.User;

public interface UserDAO {
	public void save(User user);
	public void update(User user);
	public void delete(Long id);
	public void delete(User user);
	public User findByEmail(String email);
	public List<User> findAll();
}
