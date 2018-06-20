package com.ithei.service;

import java.sql.SQLException;

import javax.xml.ws.Response;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ithei.dao.addCategoryDao;
import com.ithei.dao.addCategoryDaoimp;
import com.itheima.domain.Category;
import com.itheima.util.JdbcUtils;

public class AdminCategoryServiceImp implements AdminCategoryService{
private addCategoryDao ad=new addCategoryDaoimp();
	@Override
	public void addCategory(Category c) {
		// TODO Auto-generated method stub
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		String sql="select * from category where cname=?";
		
		try {
			Category query = queryRunner.query(sql, new BeanHandler<Category>(Category.class),c.getCname());
			if(query==null)
			{
			ad.add(c);
			}
			else
			{
			
				return;
			};
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}

}
