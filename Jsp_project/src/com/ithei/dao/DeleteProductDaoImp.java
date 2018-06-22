package com.ithei.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.util.JdbcUtils;

public class DeleteProductDaoImp implements DeleteProductDao {

	@Override
	public void deleProduct(String deleteId) {
		// TODO Auto-generated method stub
		String sql="delete from product where pid=?";
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		try {
			queryRunner.update(sql, deleteId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
