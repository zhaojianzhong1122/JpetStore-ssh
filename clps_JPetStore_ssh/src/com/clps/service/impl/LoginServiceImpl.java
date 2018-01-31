package com.clps.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Service;

import com.clps.dao.impl.DaoCategoryImpl;
import com.clps.dao.impl.DaoLoginImpl;
import com.clps.entity.*;
import com.clps.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {
	@Resource
	private DaoLoginImpl logindao;

	public void setLogindao(DaoLoginImpl logindao) {
		this.logindao = logindao;
	}

	@Override
	public boolean userLogin(String userid, String password) {
		// TODO Auto-generated method stub
		// 返回标志，false为登陆失败
		boolean result = false;
		if (logindao.userLogin(userid, password)) {
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			Profile profile = logindao.queryProfile(userid);
			if(profile.getMylistopt() != null) {
				session.setAttribute("profile", profile);
			}
			session.setAttribute("userid", userid);
			result = true;
		}

		return result;
	}

	@Override
	public void quit() {
		// TODO Auto-generated method stub
		// 注销HttpSession
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		session.invalidate();
	}

	@Override
	public Signon querySignon(String userid) {
		// TODO Auto-generated method stub
		return logindao.querySignon(userid);
	}

	@Override
	public Account queryAccount(String userid) {
		// TODO Auto-generated method stub
		return logindao.queryAccount(userid);
	}

	@Override
	public Profile queryProfile(String userid) {
		// TODO Auto-generated method stub
		return logindao.queryProfile(userid);
	}

	@Override
	public void updateSignon(Signon signon) {
		// TODO Auto-generated method stub
		logindao.updateSignon(signon);
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
		logindao.updateAccount(account);
	}

	@Override
	public void updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		logindao.updateProfile(profile);
	}

}
