package com.clps.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.clps.dao.DaoBannerdata;
import com.clps.entity.Bannerdata;
import com.clps.entity.Profile;

public class DaoBannerdataImpl implements DaoBannerdata {
	private HibernateTemplate ht;
	private String hql;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public Bannerdata querybanner(String favcategory) {
		// TODO Auto-generated method stub
		hql = "FROM Bannerdata where favcategory=?";
		List list = ht.find(hql, favcategory);
		Bannerdata bannerdata = (Bannerdata) list.get(0);
		return bannerdata;
	}

	@Override
	public Profile queryMyList(String userid) {
		// TODO Auto-generated method stub
		hql = "from Profile where userid = ? ";
		List list = ht.find(hql, userid);
		Profile profile = (Profile) list.get(0);
		return profile;
	}

}
