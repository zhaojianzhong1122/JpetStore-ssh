package com.clps.action;

import com.clps.entity.*;
import com.clps.service.impl.RegisterServiceImpl;

public class RegisterAction {
	private RegisterServiceImpl registerService;
	private Signon signon;
	private Account account;
	private Profile profile;
	private String userid;
	private String result;

	public void setRegisterService(RegisterServiceImpl registerService) {
		this.registerService = registerService;
	}

	/**
	 * 注册
	 * 
	 * @return
	 */
	public String insert() {

		if (profile.getBanneropt() == null) {

			profile.setBanneropt((Integer) 0);
		}
		if (profile.getMylistopt() == null) {
			profile.setMylistopt((Integer) 0);
		}
		profile.setUserid(signon.getUserid());
		account.setUserid(signon.getUserid());
		registerService.insertAccount(account);
		registerService.insertProfile(profile);
		registerService.insertSigno(signon);

		return "success";

	}

	/**
	 * 用于判断注册时候是否用户名重复-ajax
	 * 
	 * @return
	 */
	public String newuserid() {
		result = "false";
		if (userid != null && !userid.equals("null") && userid != "") {
			if (registerService.newuserid(userid)) {
				result="true";
			}
		}
		return "success";
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}
