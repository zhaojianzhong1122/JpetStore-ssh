package com.clps.service;

import com.clps.entity.Bannerdata;
import com.clps.entity.Profile;

public interface BannerdataService {

	public Bannerdata querybanner(String favcategory); // 根据爱好查询对应图片地址

	public Profile queryMyList(String userid);// 根据id查询个人爱好

}
