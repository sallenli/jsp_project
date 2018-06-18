package com.ithei.service;

import com.itheima.domain.User;

public interface LoginService {

	public abstract User judge(String username,String password);
}
