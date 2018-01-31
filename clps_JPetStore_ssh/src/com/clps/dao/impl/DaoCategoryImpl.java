package com.clps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.clps.dao.DaoCategory;
import com.clps.entity.Category;
import com.clps.entity.Inventory;
import com.clps.entity.Item;
import com.clps.entity.PageBean;
import com.clps.entity.Product;

public class DaoCategoryImpl implements DaoCategory {
	private HibernateTemplate ht;
	private String hql;

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	@Override
	public List<Product> query(Category category, PageBean pagebean) {
		// TODO Auto-generated method stub
		hql = "FROM Product where category = ?";
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, category.getCatid());
		query.setFirstResult(pagebean.getPage());
		query.setMaxResults(pagebean.getLimit());
		List<Product> productlist = query.list();
		session.close();
		return productlist;
	}

	@Override
	public List<Item> queryItem(String produceID) {
		// TODO Auto-generated method stub
		hql = "FROM Item where productid = ?";
		List<Item> itemlist = (List<Item>) ht.find(hql, produceID);
		return itemlist;
	}

	@Override
	public long queryInventory(String itemid) {
		// TODO Auto-generated method stub
		hql = "From Inventory where itemid = ? ";
		List<?> list = ht.find(hql, itemid);
		Inventory inventory = (Inventory) list.get(0);
		long qty = inventory.getQty();
		return qty;
	}

	@Override
	public Item queryItemTwo(String itemid) {
		// TODO Auto-generated method stub
		hql = "from Item where itemid = ?";
		List<?> list = ht.find(hql, itemid);
		Item item = (Item) list.get(0);
		return item;
	}

	@Override
	public List<Product> queryLike(String value, PageBean pagebean) {
		// TODO Auto-generated method stub
		hql = "FROM Product where name LIKE ?  or descn LIKE ?";
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + value + "%");
		query.setString(1, "%" + value + "%");
		query.setFirstResult(pagebean.getPage());
		query.setMaxResults(pagebean.getLimit());
		List<Product> productlist = query.list();
		session.close();
		return productlist;
	}

	public Product queryproduct(String productID) {
		hql = "FROM Product where productid = ?";
		Product product;
		List<Product> list = (List<Product>) ht.find(hql, productID);
		product = (Product) list.get(0);
		return product;

	}

	@Override
	public int querycount(Category category) {
		// TODO Auto-generated method stub
		hql = "SELECT COUNT(*) FROM Product AS p WHERE  p.category = '" + category.getCatid() + "'";
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		Long count = (Long) query.uniqueResult();
		Integer sum = count.intValue();
		session.close();
		return sum;
	}

	@Override
	public int querylikecount(String value) {
		// TODO Auto-generated method stub
		hql = "SELECT COUNT(*) FROM Product where name LIKE ?  or descn LIKE ?";
		Session session = ht.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, "%" + value + "%");
		query.setString(1, "%" + value + "%");
		Long count = (Long) query.uniqueResult();
		Integer sum = count.intValue();
		session.close();
		return sum;
	}
}
