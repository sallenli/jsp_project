package com.ithei.service;

import java.util.List;

import com.ithei.dao.ProductQueryDao;
import com.ithei.dao.ProductQueryDaoImp;
import com.itheima.domain.Product;

public class ProductQueryServiceImp implements ProductQueryService {

	private ProductQueryDao pd=new ProductQueryDaoImp();
	@Override
	public List<Product> query() {
		// TODO Auto-generated method stub
		return pd.query();
		
	}

}
