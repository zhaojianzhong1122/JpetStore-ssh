package com.clps.dao;

import java.util.List;

import com.clps.entity.*;

public interface DaoCategory {
	public List<Product> query(Category category,PageBean pagebean); //��ѯ��Ʒ��Ŀ
	
	
	public int querycount(Category category); //��ѯ����
	
	public List<Item> queryItem(String produceID);//��ѯ��Ʒ�б�

	public long queryInventory(String itemid);//��ѯ��Ʒ���

	public Item queryItemTwo(String itemid);//��ѯ������Ʒ

	public List<Product> queryLike(String value,PageBean pagebean);//ģ����ѯ��Ʒ��Ŀ

	public Product queryproduct(String productID);//��ѯ��Ʒ��Ŀ
	
	public int querylikecount(String value); //��ѯ����
}
