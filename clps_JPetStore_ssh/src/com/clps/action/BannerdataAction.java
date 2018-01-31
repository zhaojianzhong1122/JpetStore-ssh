package com.clps.action;

import com.clps.entity.*;
import com.clps.service.impl.BannerdataServiceImpl;

public class BannerdataAction {
	private Bannerdata bannerdata;
	private Profile profile;
	private BannerdataServiceImpl bannerdataService;
	private String userid;
	private String result;

	/**
	 * 下部广告
	 * @return
	 */
	public String queryBannerdata() {
		result = "false";
		if (userid != null && userid !="null" &&!userid.equals("null")) {
			profile = bannerdataService.queryMyList(userid);
			if(profile.getBanneropt() !=null ) {
				bannerdata = bannerdataService.querybanner(profile.getFavcategory());
				result = bannerdata.getBannername();
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

	public Bannerdata getBannerdata() {
		return bannerdata;
	}

	public void setBannerdata(Bannerdata bannerdata) {
		this.bannerdata = bannerdata;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public void setBannerdataService(BannerdataServiceImpl bannerdataService) {
		this.bannerdataService = bannerdataService;
	}

}
