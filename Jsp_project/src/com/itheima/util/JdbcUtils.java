package com.itheima.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	public static Connection connection = null;
	public static ComboPooledDataSource dataSource=null;
	public static DataSource getDatesource()
	{
		 dataSource = new ComboPooledDataSource();
		return dataSource;
	}
	public static Connection getConnection()
	{
		 dataSource = new ComboPooledDataSource();
		
		try {
			connection = dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public static void disconnectDateSource()
	{
		
		try {
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
