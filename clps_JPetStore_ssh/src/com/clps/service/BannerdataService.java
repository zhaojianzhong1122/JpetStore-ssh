package com.clps.service;

import com.clps.entity.Bannerdata;
import com.clps.entity.Profile;

public interface BannerdataService {

	public Bannerdata querybanner(String favcategory); // ���ݰ��ò�ѯ��ӦͼƬ��ַ

	public Profile queryMyList(String userid);// ����id��ѯ���˰���

}
