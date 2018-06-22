package com.ithei.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Product;
import com.itheima.util.JdbcUtils;

public class ProductQueryDaoImp implements ProductQueryDao {
private	QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());

	@Override
	public List<Product> query(int page, int pagesize) {
		// TODO Auto-generated method stub
		String sql="select * from product limit ?,?";
		try {
			List<Product> query = queryRunner.query(sql,new BeanListHandler<Product>(Product.class),page,pagesize);
		//	JdbcUtils.disconnectDateSource();
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
			
		}
	
	}

	@Override
	//获取总的商品数
	public long totalCounts() {
		// TODO Auto-generated method stub
		//QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		String sql="select count(*) from product";
		Object list;
		try {
			list = queryRunner.query(sql, new ScalarHandler(1));
			return (Long)list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	
	}

}
