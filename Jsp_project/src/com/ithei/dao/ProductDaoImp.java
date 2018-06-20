package com.ithei.dao;

import java.sql.Date;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.domain.Product;
import com.itheima.util.JdbcUtils;

public class ProductDaoImp implements ProductDao {
	
	public void add(Product p) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		String sql = "insert into product values(?,?,?,?,?,null,?,?,null,?);";
		try {
			queryRunner.update(sql, p.getPid(), p.getPname(), p.getMarket_price(), p.getShop_price(), p.getPimage(),
					p.getIs_hot(), p.getPdesc(), p.getCid());
		//	JdbcUtils.disconnectDateSource();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
