package com.ithei.service;

import org.apache.commons.dbutils.QueryRunner;

import com.ithei.dao.CategoryDeleteDao;
import com.ithei.dao.CategoryDeleteDaoImp;
import com.itheima.domain.Category;
import com.itheima.util.JdbcUtils;

public class CategoryDeleteImp implements CategoryDelete {
private CategoryDeleteDao cd=new CategoryDeleteDaoImp();
	@Override
	public void delete(Category c) {
		// TODO Auto-generated method stub
		cd.releaseShip(c);
		cd.delete(c);
		
	}

}
