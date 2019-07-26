package com.ppmtoolproject.daoimpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ppmtoolproject.DB.DatabaseConnection;
import com.ppmtoolproject.dao.UserDAO;
import com.ppmtoolproject.domain.User;

public class UserDAOImpl extends DatabaseConnection implements UserDAO {

	@Override
	public void save(User user) {
		String sql = "INSERT INTO user(user_name, user_email, user_password, user_type) values (?,?,?,?)";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try{
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setInt(4, 1);
			pstmt.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(User user) {
		String sql = "UPDATE user WHERE user_email ='"+user.getEmail() + "'";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Long id) {
		String sql = "DELETE * FROM user WHERE user_id="+id;
		PreparedStatement pstmt = createPreparedStatement(sql);
		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String email) {
		String sql = "DELETE * FROM user WHERE user_email= '" + email + "'";
		PreparedStatement pstmt = createPreparedStatement(sql);
		try {
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User findByEmail(String email) {
		User sqlUser = new User();
		String sql = "SELECT * FROM user WHERE user_email ='"+email+"'";
		try {
			PreparedStatement pstmt = createPreparedStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				sqlUser.setName(rs.getString("user_name"));
				sqlUser.setEmail(rs.getString("user_email"));
				sqlUser.setPassword(rs.getString("user_password"));
				sqlUser.setUserType(rs.getString("user_type"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sqlUser;
	}

	List<User> aUser = new ArrayList();

	@Override
	public List<User> findAll() {
		User newUser = new User();
		String sql = "Select * FROM user";
		try {
			PreparedStatement pstmt = createPreparedStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				
				newUser.setName(rs.getString("user_name"));
				newUser.setEmail(rs.getString("user_email"));
				newUser.setPassword(rs.getString("user_password"));
				newUser.setUserType(rs.getString("user_type"));
				aUser.add(newUser);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return aUser;
	}

}
