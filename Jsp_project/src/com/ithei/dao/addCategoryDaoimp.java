package com.ithei.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.domain.Category;
import com.itheima.util.JdbcUtils;

public class addCategoryDaoimp implements addCategoryDao {

	@Override
	public void add(Category c) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		String sql="insert into category values(?,?)";
		
		
		try {
			queryRunner.update(sql,c.getCid(),c.getCname());
			//JdbcUtils.disconnectDateSource();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
