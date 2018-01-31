package com.clps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.clps.dao.impl.DaoCategoryImpl;
import com.clps.dao.impl.DaoOrderImpl;
import com.clps.entity.*;
import com.clps.service.OrderService;
import com.clps.util.Util;

public class OrderServiceImpl implements OrderService {
	private DaoOrderImpl orderdao;
	private DaoCategoryImpl catedao;
	SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void setCatedao(DaoCategoryImpl catedao) {
		this.catedao = catedao;
	}

	public void setOrderdao(DaoOrderImpl orderdao) {
		this.orderdao = orderdao;
	}

	@Override
	public Account queryAccount(String userid) {
		// TODO Auto-generated method stub
		return orderdao.queryAccount(userid);
	}

	@Override
	public boolean saveOrder(Cart cart, Account account, Map<String, String> map) {
		// TODO Auto-generated method stub
		boolean flag = false;
		Session sessionhb = sessionFactory.openSession();
		Transaction tx = sessionhb.beginTransaction();
		try {
			Orders orders = new Orders();
			String userid = cart.getUserid();
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpSession session = request.getSession();
			String creditcard = map.get("creditcard");
			String exprdate = map.get("exprdate");
			String cardtype = map.get("cardtype");

			// 获得订单号随机数
			int ordersid = Util.getRollnumber();
			session.setAttribute("queryOrdersid", ordersid);
			int linitemid = 1;
			/*java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());*/
	/*		System.out.println(currentDate);*/
			orders.setOrderid(ordersid);
			orders.setUserid(userid);
		/*	orders.setOrderdate(currentDate);*/
			orders.setShipaddr1(account.getAddr1());
			orders.setShipcity(account.getCity());
			orders.setShipstate(account.getState());
			orders.setShipzip(account.getZip());
			orders.setShipcountry(account.getCountry());
			orders.setBilladdr1(account.getAddr1());
			orders.setBillcity(account.getCity());
			orders.setBillstate(account.getState());
			orders.setBillzip(account.getZip());
			orders.setBillcountry(account.getCountry());
			orders.setCourier("顺丰速运");
			for (Map.Entry<String, Item> entry : cart.getCartmap().entrySet()) {
				Lineitem lineitem = new Lineitem();
				LineitemId lineitemid = new LineitemId();
				Orderstatus orderstatus = new Orderstatus();
				OrderstatusId orderstatusid = new OrderstatusId();
				Inventory inventory = new Inventory();
				// 向数据库添加订单商品
				lineitemid.setOrderid(ordersid);
				lineitemid.setLinenum(linitemid++);
				lineitem.setId(lineitemid);
				lineitem.setItemid(entry.getValue().getItemid());
				lineitem.setQuantity(entry.getValue().getCount());
				lineitem.setUnitprice(entry.getValue().getListprice());
				orderdao.saveLineitem(sessionhb, lineitem);
				// 更改数据库中的库存
				int qty = orderdao.queryqty(sessionhb, entry.getValue().getItemid());
				int newqty = qty - entry.getValue().getCount();
				int count = entry.getValue().getCount();
				inventory.setItemid(entry.getValue().getItemid());
				inventory.setQty(newqty);
				orderdao.updateInventory(sessionhb, inventory);
				if (count > qty) {
					throw new Exception();
				}
				orderstatusid.setOrderid(ordersid);
				orderstatusid.setLinenum(linitemid);
				orderstatus.setId(orderstatusid);
				orderstatus.setStatus("已付款");
				/*orderstatus.setTimestamp(currentDate);*/
				orderdao.saveOrderstatus(sessionhb, orderstatus);
			}
			orders.setTotalprice(cart.getTotalPrice());
			orders.setBilltofirstname(account.getFirstname());
			orders.setShiptofirstname(account.getFirstname());
			orders.setCreditcard(creditcard);
			orders.setCardtype(cardtype);
			orders.setExprdate(exprdate);
			orderdao.saveOrder(sessionhb, orders);
			tx.commit();
			sessionhb.close();
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			tx.rollback();
		}
		return flag;
	}

	@Override
	public Orders queryOrdersOne(int orderid) {
		// TODO Auto-generated method stub
		return orderdao.queryOrdersOne(orderid);
	}

	@Override
	public PageUtil<Orders> queryOrder(String userid, PageBean pagebean) {
		// TODO Auto-generated method stub
		List<Orders> list = orderdao.queryOrder(userid, pagebean);
		int totalCount = orderdao.countOrders(userid);
		int pageSize = pagebean.getLimit();
		int currPage = pagebean.getPage();
		PageUtil<Orders> pageutil = new PageUtil<Orders>(list, totalCount, pageSize, currPage);
		return pageutil;
	}

	@Override
	public Cart queryOrdersItem(Orders orders) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		Map<String, Item> map = new HashMap<String, Item>();
		List<Lineitem> list = orderdao.queryLineitem(orders.getOrderid());
		for (Lineitem entry : list) {
			Item item = catedao.queryItemTwo(entry.getItemid());
			item.setCount(entry.getQuantity());
			map.put(entry.getItemid(), item);
		}
		cart.setCartmap(map);
		return cart;
	}

}
