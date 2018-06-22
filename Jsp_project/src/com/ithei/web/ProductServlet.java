package com.ithei.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithei.service.ProductQueryService;
import com.ithei.service.ProductQueryServiceImp;
import com.itheima.domain.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int page=1;
		int pagesize=4;
		String nextPage=request.getParameter("page");
		String nextPageSize=request.getParameter("pageSize");
		if(nextPage!=null&&nextPageSize!=null)
		{
			page=Integer.parseInt(nextPage);
			pagesize=Integer.parseInt(nextPageSize);
		}
		ProductQueryService ps=new ProductQueryServiceImp();
		List<Product> product = ps.query(page,pagesize);
		int [] pageBar=ps.generatePageBar(page,pagesize);
		request.setAttribute("pageBar", pageBar);
		request.setAttribute("product", product);
		request.setAttribute("page", page);
		request.setAttribute("pageSize", pagesize);
		request.getRequestDispatcher("/admin/product/list.jsp").forward(request, response);
		
	}

}
