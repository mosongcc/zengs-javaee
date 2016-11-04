package org.wjlmgqs.dao.imp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.wjlmgqs.dao.UserDao;
import org.wjlmgqs.entity.User;
import org.wjlmgqs.util.DBUtil;
import org.wjlmgqs.util.QueryBuilder;

public class UserDaoImp implements UserDao{

	@Override
	public List<String> listUserName() {
		return DBUtil.query(new QueryBuilder<List<String>>("Select UserName from ZDUser"){
			@Override
			public List<String> execute(ResultSet rs) throws SQLException {
				List<String> names = new ArrayList<String>();
				while(rs.next()){
					names.add(rs.getString("UserName"));
				}
				return names;
			}
		});
	}

	@Override
	public List<User> findUser(String email) {
		return DBUtil.query(new QueryBuilder<List<User>>("Select * from ZDUser where email like ? ","%"+email+"%"){
			@Override
			public void setParams(PreparedStatement ps, Object... params) throws SQLException{
				ps.setString(1, params[0].toString());
			}
			@Override
			public List<User> execute(ResultSet rs) throws SQLException {
				List<User> users = new ArrayList<User>();
				User user = null;
				while(rs.next()){
					user = new User();
					user.setEmail(rs.getString("Email"));
					user.setLastLoginTime(rs.getDate("LastLoginTime"));
					user.setName(rs.getString("UserName"));
					user.setStatus(rs.getString("Status"));
					users.add(user);
				}
				return users;
			}
		});
	}

	
	public static void main(String[] args) {
		List<User> findUser = new UserDaoImp().findUser("wang");
		for(User user : findUser){
			System.out.println(user);
		}
	}

}
