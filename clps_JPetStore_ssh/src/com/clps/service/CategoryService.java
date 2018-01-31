package com.clps.service;

import java.util.List;

import com.clps.dao.DaoCategory;
import com.clps.entity.*;

public interface CategoryService {

	public PageUtil<Product> query(Category category, PageBean pagebean);//��ҳ��ѯ��Ʒ��Ŀ
	
	public int querycount(Category category); //��ѯ����
	
	public List<Item> queryItem(String produceID);//����ID��ѯ������Ʒ

	public long queryInventory(String itemid);//��ѯ��Ʒ���

	public Item queryItemTwo(String itemid);//��ѯ��Ʒ������Ϣ

	public PageUtil<Product> queryLike(String value, PageBean pagebean);//ģ��������ҳ��ѯ

	public Product queryproduct(String productID);//��ѯ��Ʒ��Ŀ

}
