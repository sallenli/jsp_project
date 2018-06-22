package com.ithei.service;

import java.util.List;

import com.itheima.domain.Product;

public interface ProductQueryService {

	List<Product> query(int page, int pagesize);

	int[] generatePageBar(int page, int pagesize);

}
