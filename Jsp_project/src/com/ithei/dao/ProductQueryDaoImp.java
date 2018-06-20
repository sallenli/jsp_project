package com.ithei.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.itheima.domain.Product;
import com.itheima.util.JdbcUtils;

public class ProductQueryDaoImp implements ProductQueryDao {

	@Override
	public List<Product> query() {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		String sql="select * from product";
		try {
			List<Product> query = queryRunner.query(sql,new BeanListHandler<Product>(Product.class));
		//	JdbcUtils.disconnectDateSource();
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
