package com.clps.service;

import com.clps.entity.*;

public interface RegisterService {

	public boolean newuserid(String userid);// 注册用户时候,判断用户名是否被注册
	
	public void insertSigno(Signon signon);//注册用户，插入Signon

	public void insertProfile(Profile profile);//注册用户，插入Profile

	public void insertAccount(Account account);//注册用户，插入account


}
