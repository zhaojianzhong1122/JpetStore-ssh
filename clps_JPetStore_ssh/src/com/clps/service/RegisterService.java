package com.clps.service;

import com.clps.entity.*;

public interface RegisterService {

	public boolean newuserid(String userid);// ע���û�ʱ��,�ж��û����Ƿ�ע��
	
	public void insertSigno(Signon signon);//ע���û�������Signon

	public void insertProfile(Profile profile);//ע���û�������Profile

	public void insertAccount(Account account);//ע���û�������account


}
