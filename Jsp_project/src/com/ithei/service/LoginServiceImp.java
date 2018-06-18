package com.ithei.service;

import com.ithei.dao.*;
import com.itheima.domain.User;
//登陆service层
public class LoginServiceImp implements LoginService {

	public User judge(String username,String password)
	{
		LoginDao ld=new LoginDaoImp();
		return  ld.checkLogin(username, password);
		
	}
}
