package com.clps.service.impl;

import com.clps.dao.impl.DaoRegisterImpl;
import com.clps.entity.Account;
import com.clps.entity.Profile;
import com.clps.entity.Signon;
import com.clps.service.RegisterService;

public class RegisterServiceImpl implements RegisterService {
	private DaoRegisterImpl registerdao;
	
	public void setRegisterdao(DaoRegisterImpl registerdao) {
		this.registerdao = registerdao;
	}

	@Override
	public void insertSigno(Signon signon) {
		// TODO Auto-generated method stub
		registerdao.insertSigno(signon);
	}

	@Override
	public void insertProfile(Profile profile) {
		// TODO Auto-generated method stub
		registerdao.insertProfile(profile);
	}

	@Override
	public void insertAccount(Account account) {
		// TODO Auto-generated method stub
		registerdao.insertAccount(account);
	}

	@Override
	public boolean newuserid(String userid) {
		// TODO Auto-generated method stub
		return registerdao.newuserid(userid);
	}


	
}
