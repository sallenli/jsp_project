package com.ithei.dao;

import com.itheima.domain.User;

  public interface LoginDao {
public abstract User checkLogin(String username,String passeword);
}
