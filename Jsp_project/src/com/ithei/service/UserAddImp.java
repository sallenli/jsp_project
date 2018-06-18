package com.ithei.service;

import com.ithei.dao.UserDao;
import com.ithei.dao.UserDaoimp;
import com.itheima.domain.User;

public class UserAddImp implements UserAdd{
	private UserDao udd=new UserDaoimp();
	@Override
	public void testUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("service层获取的年龄值:"+user);
		udd.addUser(user);
		
	}

}
