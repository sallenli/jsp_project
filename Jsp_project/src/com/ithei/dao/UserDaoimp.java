package com.ithei.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.User;
import com.itheima.util.JdbcUtils;

public class UserDaoimp implements UserDao{

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		
		
		
		String sql="insert into user  values (null,?,?,?,?)";
		
		//String [] params={user.getUserName(),user.getUserPassword(),Integer.toString(user.getAge()),user.getHobby()};
		try {
		
				int i = queryRunner.update(sql,user.getUserName(),user.getUserPassword(),user.getAge(),user.getHobby());
			//	JdbcUtils.disconnectDateSource();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
