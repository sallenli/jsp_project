package com.ithei.service;

import java.util.List;

import com.ithei.dao.ProductQueryDao;
import com.ithei.dao.ProductQueryDaoImp;
import com.itheima.domain.Product;

public class ProductQueryServiceImp implements ProductQueryService {

	private ProductQueryDao pd=new ProductQueryDaoImp();
	@Override
	public List<Product> query(int page,int pagesize) {
		
		return pd.query((page-1)*pagesize,pagesize);
		
	}
	@Override
	public int[] generatePageBar(int page, int pagesize) {
		// TODO Auto-generated method stub
		long totalcounts=pd.totalCounts();
		int totalPages=(int)(totalcounts+pagesize-1)/pagesize;
		int beginPage;
		int endPage;
		if(totalPages<=10)
		{
			beginPage=1;
			endPage=totalPages;
		}
		else
		{
			beginPage=page-5;
			endPage=page+4;
			if(beginPage<=0)
			{
				beginPage=1;
				endPage=10;
			}
			if(endPage>=totalPages)
			{
				endPage=totalPages;
				beginPage=endPage-9;
			}
			
		}
		   int pageBar[]=new int[endPage-beginPage+1];
		   int index=0;
		   for(int i=beginPage;i<=endPage;i++)
		   {
			   pageBar[index++]=i;
			   
		   }
		   return pageBar;
	}

}
