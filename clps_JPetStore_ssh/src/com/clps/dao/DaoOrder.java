package com.clps.dao;

import java.util.List;

import org.hibernate.Session;

import com.clps.entity.*;

public interface DaoOrder {
	public Account queryAccount(String userid); // 根据id查询账户信息

	public void saveOrder(Session session, Orders orders); // 保存订单信息

	public void saveLineitem(Session session, Lineitem lineitem); // 保存商品信息

	public void saveOrderstatus(Session session, Orderstatus orderstatus); // 保存订单

	public List<Orders> queryOrder(String userid, PageBean pageBean); // 分页查询所有订单

	public List<Lineitem> queryLineitem(int ordersid);// 查询Lineitem

	public Orders queryOrdersOne(int orderid); // 根据订单号查询订单

	public int queryqty(Session session, String itemid);// 查询库存

	public void updateInventory(Session session, Inventory inventory); // 更新库存

	public int countOrders(String userid); // 根据userid查询用户订单总数

}
