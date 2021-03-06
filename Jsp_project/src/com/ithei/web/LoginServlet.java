package com.ithei.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ithei.service.LoginService;
import com.ithei.service.LoginServiceImp;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(name = "LoginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username =  request.getParameter("username");
		String password = request.getParameter("password");
		String code = (String) request.getSession().getAttribute("code");
		String checkcode = (String) request.getParameter("checkcode");
		/*LoginService ls=new LoginServiceImp();
		ls.judge(username, password);
		request.getRequestDispatcher("/admin/home.jsp").forward(request, response);*/
		if (checkcode.endsWith(code)) {
			
			LoginService ls = new LoginServiceImp();
			ls.judge(username, password);
			request.getRequestDispatcher("/admin/home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("code_Error", "验证码错误");
		request.getRequestDispatcher("/loginError.jsp").forward(request, response);
		}
		

	}

}
