package com.ithei.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Category;
import com.itheima.util.JdbcUtils;

public class CategoryDaoImp implements CategoryDao {

	@Override
	public List<Category> query() {
		// TODO Auto-generated method stub
		String sql="select * from category ";
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		try {
			List<Category> query = queryRunner.query(sql,new BeanListHandler<Category>(Category.class));
		//	JdbcUtils.disconnectDateSource();
			return query;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
