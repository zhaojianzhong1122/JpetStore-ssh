package com.clps.service;

import java.util.Map;

import com.clps.entity.*;

public interface OrderService {

	public Account queryAccount(String userid); // 根据id查询账户信息

	public boolean saveOrder(Cart cart,Account account,Map<String,String> map); // 保存订单信息

	public PageUtil<Orders> queryOrder(String userid, PageBean pagebean);//分页查询所有订单
	
	public Orders queryOrdersOne(int orderid); //根据订单号查询订单
	
	public Cart queryOrdersItem(Orders orders); // 根据订单查询订单下商品
}
