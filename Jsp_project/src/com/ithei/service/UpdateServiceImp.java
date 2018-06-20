package com.ithei.service;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ithei.dao.UpdateDao;
import com.ithei.dao.UpdateDaoImp;
import com.itheima.domain.Category;
import com.itheima.util.JdbcUtils;

public class UpdateServiceImp implements UpdateService {
		private UpdateDao ud=new UpdateDaoImp();
	@Override
	public void update(Category c) {
		// TODO Auto-generated method stub
		String name=c.getCname();
		String sql="select * from category where cname=?";
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		try {
			Category category =(Category) queryRunner.query(sql, new BeanHandler<Category>(Category.class),name);
			if(category==null)
			{
				ud.update(c);
			}
			else
			{
				return;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


}
