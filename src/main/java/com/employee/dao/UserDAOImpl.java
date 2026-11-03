
package com.employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.employee.model.User;
import com.employee.util.DBConnection;
import com.employee.util.PasswordUtil;

public class UserDAOImpl implements UserDAO {

	@Override
	public User login(String username, String password) {

		User user = null;

		String sql = "SELECT * FROM users WHERE username = ?";

		try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

			ps.setString(1, username);

			try (ResultSet rs = ps.executeQuery()) {

				if (rs.next()) {

					String hashedPassword = rs.getString("password");

					if (PasswordUtil.checkPassword(password, hashedPassword)) {

						user = new User();

						user.setUserId(rs.getInt("user_id"));
						user.setUsername(rs.getString("username"));
						user.setPassword(hashedPassword);
						user.setRole(rs.getString("role"));
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}

}
