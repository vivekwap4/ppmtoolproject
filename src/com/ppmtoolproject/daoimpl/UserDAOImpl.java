package com.ppmtoolproject.daoimpl;

import java.sql.PreparedStatement;
import java.util.List;

import com.ppmtoolproject.DB.DatabaseConnection;
import com.ppmtoolproject.dao.UserDAO;
import com.ppmtoolproject.domain.User;

public class UserDAOImpl extends DatabaseConnection implements UserDAO {

	@Override
	public void save(User user) {
		String sql = "INSERT INTO users (name, email, password, userType) values (?,?,?, ?)";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try{
			pstmt.setString(1,  user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getUserType());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
