package com.clps.dao;

import com.clps.entity.*;

public interface DaoRegister {
	
	public boolean newuserid(String userid);// ע���û�ʱ��,�ж��û����Ƿ�ע��

	public void insertSigno(Signon signon); // ע���û�������Signon

	public void insertProfile(Profile profile);// ע���û�������Profile

	public void insertAccount(Account account);// ע���û�������account

}
