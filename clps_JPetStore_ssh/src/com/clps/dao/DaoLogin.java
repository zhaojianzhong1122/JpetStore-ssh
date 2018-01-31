package com.clps.dao;

import com.clps.entity.*;

public interface DaoLogin {

	public boolean userLogin(String userid, String password); // 登陆验证,当登陆成功时返回true

	public Signon querySignon(String userid);// 查询登录信息

	public Account queryAccount(String userid);// 查询账户信息

	public Profile queryProfile(String userid);// 查询私人信息

	public void updateSignon(Signon signon);// 更新登录信息

	public void updateAccount(Account account);// 更新账户信息

	public void updateProfile(Profile profile);// 更新私人信息

}
