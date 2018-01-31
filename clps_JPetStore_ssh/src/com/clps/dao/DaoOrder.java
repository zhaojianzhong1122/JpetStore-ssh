package com.clps.dao;

import java.util.List;

import org.hibernate.Session;

import com.clps.entity.*;

public interface DaoOrder {
	public Account queryAccount(String userid); // ����id��ѯ�˻���Ϣ

	public void saveOrder(Session session, Orders orders); // ���涩����Ϣ

	public void saveLineitem(Session session, Lineitem lineitem); // ������Ʒ��Ϣ

	public void saveOrderstatus(Session session, Orderstatus orderstatus); // ���涩��

	public List<Orders> queryOrder(String userid, PageBean pageBean); // ��ҳ��ѯ���ж���

	public List<Lineitem> queryLineitem(int ordersid);// ��ѯLineitem

	public Orders queryOrdersOne(int orderid); // ���ݶ����Ų�ѯ����

	public int queryqty(Session session, String itemid);// ��ѯ���

	public void updateInventory(Session session, Inventory inventory); // ���¿��

	public int countOrders(String userid); // ����userid��ѯ�û���������

}
