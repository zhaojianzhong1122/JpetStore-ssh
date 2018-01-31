package com.clps.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.clps.dao.DaoRegister;
import com.clps.entity.Account;
import com.clps.entity.Item;
import com.clps.entity.Profile;
import com.clps.entity.Signon;
@Transactional(readOnly = false)
public class DaoRegisterImpl extends HibernateTemplate implements DaoRegister {
	private HibernateTemplate ht;
	private String hql;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public void insertSigno(Signon signon) {
		Session session = ht.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(signon);
		tx.commit();
		session.close();
	}

	@Override
	public void insertProfile(Profile profile) {
		// TODO Auto-generated method stub
		Session session = ht.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(profile);
		tx.commit();
		session.close();
	}

	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub
		Session session = ht.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(account);
		tx.commit();
		session.close();
	}

	@Override
	public boolean newuserid(String userid) {
		// TODO Auto-generated method stub
		hql = "FROM Signon WHERE userid = ?";
		List list =ht.find(hql, userid);
		if(list.isEmpty()) {
			return true;
		}
		return false;
	}

}
