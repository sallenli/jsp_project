package com.ithei.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.domain.Category;
import com.itheima.util.JdbcUtils;

public class CategoryDeleteDaoImp implements CategoryDeleteDao {
	QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
	@Override
	public void delete(Category c) {
		// TODO Auto-generated method stub
		
		String sql="delete  from category where cid=?";
		try {
			int update = queryRunner.update(sql,c.getCid());
		//	JdbcUtils.disconnectDateSource();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void releaseShip(Category c) {
		// TODO Auto-generated method stub
		String sql="update product set cid=null where cid=?";
		try {
			queryRunner.update(sql,c.getCid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
