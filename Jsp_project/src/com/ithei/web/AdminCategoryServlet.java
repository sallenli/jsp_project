package com.ithei.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.ithei.service.AdminCategoryService;
import com.ithei.service.AdminCategoryServiceImp;
import com.itheima.domain.Category;

/**
 * Servlet implementation class AdminCategoryServlet
 */
@WebServlet("/adminCategoryServlet")
public class AdminCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Category c=new Category();
		try {
			BeanUtils.populate(c, request.getParameterMap());
			c.setCid(UUID.randomUUID().toString().replace("-", ""));
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdminCategoryService as=new AdminCategoryServiceImp();
		as.addCategory(c);
		
		
	}

}
