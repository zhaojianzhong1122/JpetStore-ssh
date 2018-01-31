package com.clps.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import com.clps.dao.DaoLogin;
import com.clps.entity.Account;
import com.clps.entity.Profile;
import com.clps.entity.Signon;

public class DaoLoginImpl implements DaoLogin {
	private HibernateTemplate ht;
	private String hql;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	// 登陆验证
	public boolean userLogin(String userid, String password) {
		// TODO Auto-generated method stub
		boolean result = false;
		hql = "FROM Signon where userid = ? and password = ?";
		List list = ht.find(hql, userid, password);
		// 判断返回的list是否为空
		if (!list.isEmpty()) {
			result = true;
		}
		return result;
	}

	@Override
	public Signon querySignon(String userid) {
		// TODO Auto-generated method stub
		hql = "FRom Signon where userid = ?";
		List list = ht.find(hql, userid);
		Signon signon = (Signon) list.get(0);
		return signon;
	}

	@Override
	public Account queryAccount(String userid) {
		// TODO Auto-generated method stub
		hql = "FROM Account where userid= ? ";
		List list = ht.find(hql, userid);
		Account account = (Account) list.get(0);
		return account;
	}

	@Override
	public Profile queryProfile(String userid) {
		// TODO Auto-generated method stub
		hql = "FROM Profile where userid= ? ";
		List list = ht.find(hql, userid);
		Profile profile = (Profile) list.get(0);
		return profile;
	}

	@Override
	public void updateSignon(Signon signon) {
		// TODO Auto-generated method stub
		Session session = ht.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(signon);
		tx.commit();
		session.close();
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		Session session = ht.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(account);
		tx.commit();
		session.close();
	}

	@Override
	public void updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		Session session = ht.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(profile);
		tx.commit();
		session.close();
	}

}
