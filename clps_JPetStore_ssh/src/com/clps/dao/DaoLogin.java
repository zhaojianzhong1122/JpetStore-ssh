package com.clps.dao;

import com.clps.entity.*;

public interface DaoLogin {

	public boolean userLogin(String userid, String password); // ��½��֤,����½�ɹ�ʱ����true

	public Signon querySignon(String userid);// ��ѯ��¼��Ϣ

	public Account queryAccount(String userid);// ��ѯ�˻���Ϣ

	public Profile queryProfile(String userid);// ��ѯ˽����Ϣ

	public void updateSignon(Signon signon);// ���µ�¼��Ϣ

	public void updateAccount(Account account);// �����˻���Ϣ

	public void updateProfile(Profile profile);// ����˽����Ϣ

}
