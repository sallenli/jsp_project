package com.ithei.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.domain.Category;
import com.itheima.util.JdbcUtils;

public class UpdateDaoImp implements UpdateDao {

	@Override
	public void update(Category c) {
		// TODO Auto-generated method stub
		String sql="update category set cname=? where cid=?";
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		try {
			int update = queryRunner.update(sql,c.getCname(),c.getCid());
		//	JdbcUtils.disconnectDateSource();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
