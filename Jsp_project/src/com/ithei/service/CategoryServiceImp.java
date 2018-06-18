package com.ithei.service;

import java.util.List;

import com.ithei.dao.CategoryDao;
import com.ithei.dao.CategoryDaoImp;
import com.itheima.domain.Category;

public class CategoryServiceImp implements CategoryService {

	private CategoryDao cd=new CategoryDaoImp();
	@Override
	public List<Category> query() {
		// TODO Auto-generated method stub
		
		return cd.query();
	}

}
