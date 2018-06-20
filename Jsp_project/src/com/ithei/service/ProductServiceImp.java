package com.ithei.service;

import com.ithei.dao.ProductDao;
import com.ithei.dao.ProductDaoImp;
import com.itheima.domain.Product;

public class ProductServiceImp implements ProductService {

	private ProductDao pd=new ProductDaoImp();
	@Override
	public void add(Product p) {
		// TODO Auto-generated method stub
		pd.add(p);
	}

}
