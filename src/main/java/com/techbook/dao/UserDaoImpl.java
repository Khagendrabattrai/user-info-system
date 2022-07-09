
package com.techbook.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.xdevapi.Result;
import com.techbook.domain.User;
import com.techbook.utl.DbConnectionUtl;

public class UserDaoImpl implements UserDao {
	public static final String INSERT_SQL = "insert into user_tbl(user_name,password,mobile_no,email,dob)values(?,?,?,?,?)";
	public static final String UPDATE_SQL = "update user_tbl  set user_name=?,password=?,mobile_no=?,email,dob=? where id=?";
	public static final String DElETE_SQL = "delete from  user_tbl   where id=?";
	public static final String LIST_SQL = "select * from  user_tbl";

	@Override
	public int saveUserInfo(User user) {
		int save = 0; // yaha int ya boolean j rakhda ne hunxa
		// yaha int athava boolean j garda nne hunxa
		try (PreparedStatement ps = DbConnectionUtl.getConnection().prepareStatement(INSERT_SQL);) {
			ps.setString(1, user.getUserName());// yaha direct value didainau user ma bind garaera dinxau
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getMobileNmuber());
			ps.setString(4, user.getEmail());// hamilae mobile number bigInt rakhya xa so we use long here
			// ps.setDate(5, user.getDob());// we cant use this coz here setDate ask for sql
			// date but user.getDob
			// is utl so it has to be converted like below
			ps.setDate(5, new Date(user.getDob().getTime()));
			save = ps.executeUpdate();// ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}
		return save;

	}

	@Override
	public int updateUserInfo(User user) {
		int updated = 0; // yaha int ya boolean j rakhda ne hunxa
		// yaha int athava boolean j garda nne hunxa
		try (PreparedStatement ps = DbConnectionUtl.getConnection().prepareStatement(UPDATE_SQL);) {
			ps.setString(1, user.getUserName());// yaha direct value didainau user ma bind garaera dinxau
			ps.setString(2, user.getPassword());
			ps.setLong(3, user.getMobileNmuber());
			ps.setString(4, user.getEmail());// hamilae mobile number bigInt rakhya xa so we use long here
			// ps.setDate(5, user.getDob());// we cant use this coz here setDate ask for sql
			// date but user.getDob
			// is utl so it has to be converted like below
			ps.setDate(5, new Date(user.getDob().getTime()));
			ps.setInt(6, user.getId());
			updated = ps.executeUpdate();// ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}
		return updated;

	}

	@Override
	public int deleteUserInfo(int id) {
		int deleted = 0;
		try (PreparedStatement ps = DbConnectionUtl.getConnection().prepareStatement(DElETE_SQL);) {

			ps.setInt(1, id);
			deleted = ps.executeUpdate();// ps.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}
		return deleted;

	}

	@Override
	public List<User> getAllUserInfo() {
		List<User> userList = new ArrayList<>();

		try (PreparedStatement ps = DbConnectionUtl.getConnection().prepareStatement(LIST_SQL);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUserName(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setMobileNmuber(rs.getLong("mobile_no"));
				user.setDob(rs.getDate("dob"));
				userList.add(user);

			}
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();

		}
		return userList;

	}
}
