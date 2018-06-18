package com.ithei.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ithei.service.UserAdd;
import com.ithei.service.UserAddImp;
import com.itheima.domain.User;
import com.itheima.util.JdbcUtils;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
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
		response.setContentType("text/html;charset=UTF-8");
		User user=new User();
		String sql="select * from user where userName=?";
		QueryRunner queryRunner = new QueryRunner(JdbcUtils.getDatesource());
		
		try {
			User checkUser = queryRunner.query(sql,new BeanHandler<User>(User.class), request.getParameter("userName"));
			if(checkUser!=null)
			{
				request.setAttribute("user_Name_Error", "用户名重复");
				request.getRequestDispatcher("/addUserAgain.jsp").forward(request,response);
			}
			else
			{
			BeanUtils.populate(user, request.getParameterMap());
			String [] hobby = request.getParameterValues("hobby");
			user.setHobby(stringArrytoString(hobby));
			UserAdd udd=new UserAddImp();
			String age1 = request.getParameter("age");
			int age = Integer.parseInt(age1);
			System.out.println(age);
			user.setAge(age);
			udd.testUser(user);
			request.setAttribute("regist_succeed", "注册成功");
			request.getRequestDispatcher("/login_Add.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String stringArrytoString(String [] arrays)
	{
		StringBuffer sb=new StringBuffer();
		for (String string : arrays) {
			sb.append(string);
		}
		return sb.toString();
	
	}

}
