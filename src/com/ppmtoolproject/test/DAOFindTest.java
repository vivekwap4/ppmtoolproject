package com.ppmtoolproject.test;

import com.ppmtoolproject.dao.UserDAO;
import com.ppmtoolproject.daoimpl.UserDAOImpl;
import com.ppmtoolproject.domain.User;

public class DAOFindTest {

	public static void main(String[] args) {
		UserDAO dao = new UserDAOImpl();
		User u = dao.findByEmail("adam@adam.com");
		System.out.println(u.getName());
	}

}
