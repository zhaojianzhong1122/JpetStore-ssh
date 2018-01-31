package com.clps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.clps.dao.DaoOrder;
import com.clps.entity.*;

public class DaoOrderImpl implements DaoOrder {
	private HibernateTemplate ht;
	private String hql;
	
	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public Account queryAccount(String userid) {
		// TODO Auto-generated method stub
		hql = "FROM Account where userid= ? ";
		List list = ht.find(hql, userid);
		Account account = (Account) list.get(0);
		return account;
	}

	@Override
	public void saveOrder(Session session,Orders orders) {
		// TODO Auto-generated method stub
		session.save(orders);
	}

	@Override
	public void saveLineitem(Session session,Lineitem lineitem) {
		// TODO Auto-generated method stub
		session.save(lineitem);
	}

	@Override
	public void saveOrderstatus(Session session,Orderstatus orderstatus) {
		// TODO Auto-generated method stub
		session.save(orderstatus);
	}

	@Override
	public List<Orders> queryOrder(String userid, PageBean pageBean) {
		// TODO Auto-generated method stub
		hql = "FROM Orders where userid= ?";
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, userid);
		query.setFirstResult(pageBean.getPage());
		query.setMaxResults(pageBean.getLimit());
		List<Orders> list = query.list();
		session.close();
		return list;
	}

	@Override
	public Orders queryOrdersOne(int orderid) {
		// TODO Auto-generated method stub
		hql = "FROM Orders where orderid= ? ";
		List list = ht.find(hql, orderid);
		Orders orders = (Orders) list.get(0);
		return orders;
	}

	@Override
	public void updateInventory(Session session,Inventory inventory) {
		// TODO Auto-generated method stub
		String hql="update Inventory i SET i.qty = ? WHERE i.itemid = ?";
		Query query = session.createQuery(hql);
		query.setInteger(0, inventory.getQty());
		query.setString(1, inventory.getItemid());
		query.executeUpdate();
	}

	@Override
	public int countOrders(String userid) {
		// TODO Auto-generated method stub
		hql = "SELECT COUNT(*) FROM Orders AS o WHERE  o.userid = '" + userid + "'";
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		Long count = (Long) query.uniqueResult();
		Integer sum = count.intValue();
		session.close();
		return sum;
	}

	@Override
	public int queryqty(Session session,String itemid) {
		// TODO Auto-generated method stub
		hql = "From Inventory  where itemid = '" + itemid + "' ";
		Query query = session.createQuery(hql);
		List list = query.list();
		Inventory inventory = (Inventory) list.get(0);
		long qty = inventory.getQty();
		int number = (int) qty;
		return number;
	}

	@Override
	public List<Lineitem> queryLineitem(int i) {
		// TODO Auto-generated method stub
		hql = "FROM Lineitem where orderid= ?";
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, i);
		List<Lineitem> list = query.list();
		session.close();
		return list;
	}

	

}
