package com.clps.service;

import com.clps.entity.*;

public interface LoginService {

	public boolean userLogin(String userid, String password); // 登录验证,当登录成功时返回true反之为false

	public void quit(); //退出登录，注销session

	public Signon querySignon(String userid); //查询登录信息

	public Account queryAccount(String userid);//查询账户信息

	public Profile queryProfile(String userid);//查询私人信息

	public void updateSignon(Signon signon);//更新登录信息
	
	public void updateAccount(Account account);//更新账户信息

	public void updateProfile(Profile profile);//更新私人信息
	
	
}
