package com.ithei.service;

import com.ithei.dao.DeleteProductDao;
import com.ithei.dao.DeleteProductDaoImp;

public class DeleteProductServiceImp implements DeleteProductService {
	private DeleteProductDao dd=new DeleteProductDaoImp();
	@Override
	public void delete(String deleteId) {
		// TODO Auto-generated method stub
		dd.deleProduct(deleteId);
	}

}
