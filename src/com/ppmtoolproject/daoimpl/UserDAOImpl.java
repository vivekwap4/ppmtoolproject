package com.ppmtoolproject.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.ppmtoolproject.DB.DatabaseConnection;
import com.ppmtoolproject.dao.UserDAO;
import com.ppmtoolproject.domain.User;

public class UserDAOImpl extends DatabaseConnection implements UserDAO {

	@Override
	public void save(User user) {
		String sql = "INSERT INTO user(user_name, user_email, user_password, user_type) values (?,?,?,?)";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try {
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, 1);
			pstmt.execute();
		} catch (Exception e) {
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
		User user = null;
		String sql = "select * from user where user_email ='" + email + "'";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try {
			ResultSet rs = pstmt.executeQuery(sql);
			if (rs.next()) {
				user = new User();
				user.setName(rs.getString("user_name"));
				user.setEmail(rs.getString("user_email"));
				user.setPassword(rs.getString("user_password"));
				user.setUserType(rs.getInt("user_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
