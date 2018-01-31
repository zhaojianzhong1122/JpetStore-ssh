package com.clps.service;

import java.util.Map;

import com.clps.entity.*;

public interface OrderService {

	public Account queryAccount(String userid); // ����id��ѯ�˻���Ϣ

	public boolean saveOrder(Cart cart,Account account,Map<String,String> map); // ���涩����Ϣ

	public PageUtil<Orders> queryOrder(String userid, PageBean pagebean);//��ҳ��ѯ���ж���
	
	public Orders queryOrdersOne(int orderid); //���ݶ����Ų�ѯ����
	
	public Cart queryOrdersItem(Orders orders); // ���ݶ�����ѯ��������Ʒ
}
