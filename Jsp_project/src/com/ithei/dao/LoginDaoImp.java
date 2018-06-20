package com.ithei.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.itheima.domain.*;
import com.itheima.util.JdbcUtils;

public class LoginDaoImp implements LoginDao{

	@Override
	public User checkLogin(String username,String password) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		
		String sql ="select * from user where userName= ? and userPassword = ?";
		String[] params={username,password};
		try {
			User user = queryRunner.query(sql, new BeanHandler<User>(User.class), params);
		//	JdbcUtils.disconnectDateSource();
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
