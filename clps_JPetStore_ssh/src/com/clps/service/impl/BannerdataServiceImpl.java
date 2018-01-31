package com.clps.service.impl;

import com.clps.dao.impl.DaoBannerdataImpl;
import com.clps.entity.Bannerdata;
import com.clps.entity.Profile;
import com.clps.service.BannerdataService;

public class BannerdataServiceImpl implements BannerdataService {
	private DaoBannerdataImpl bannerdatadao;

	public void setBannerdatadao(DaoBannerdataImpl bannerdatadao) {
		this.bannerdatadao = bannerdatadao;
	}

	@Override
	public Bannerdata querybanner(String favcategory) {
		// TODO Auto-generated method stub
		return bannerdatadao.querybanner(favcategory);
	}

	@Override
	public Profile queryMyList(String userid) {
		// TODO Auto-generated method stub
		return bannerdatadao.queryMyList(userid);
	}

}
