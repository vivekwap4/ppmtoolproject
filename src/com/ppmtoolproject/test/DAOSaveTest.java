package com.ppmtoolproject.test;

import com.ppmtoolproject.daoimpl.UserDAOImpl;
import com.ppmtoolproject.domain.User;

public class DAOSaveTest {

	public static void main(String[] args) {
		UserDAOImpl dao = new UserDAOImpl();
		User u = new User();
		u.setName("Adam");
		u.setPassword("Adam");
		u.setEmail("adam@adam.com");
		u.setUserType(3);
		
		dao.save(u);
	}

}
