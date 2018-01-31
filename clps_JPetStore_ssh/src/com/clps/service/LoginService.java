package com.clps.service;

import com.clps.entity.*;

public interface LoginService {

	public boolean userLogin(String userid, String password); // ��¼��֤,����¼�ɹ�ʱ����true��֮Ϊfalse

	public void quit(); //�˳���¼��ע��session

	public Signon querySignon(String userid); //��ѯ��¼��Ϣ

	public Account queryAccount(String userid);//��ѯ�˻���Ϣ

	public Profile queryProfile(String userid);//��ѯ˽����Ϣ

	public void updateSignon(Signon signon);//���µ�¼��Ϣ
	
	public void updateAccount(Account account);//�����˻���Ϣ

	public void updateProfile(Profile profile);//����˽����Ϣ
	
	
}
