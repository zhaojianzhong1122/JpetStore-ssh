package com.clps.dao;

import java.util.List;

import com.clps.entity.*;

public interface DaoCategory {
	public List<Product> query(Category category,PageBean pagebean); //查询商品类目
	
	
	public int querycount(Category category); //查询总数
	
	public List<Item> queryItem(String produceID);//查询商品列表

	public long queryInventory(String itemid);//查询商品库存

	public Item queryItemTwo(String itemid);//查询具体商品

	public List<Product> queryLike(String value,PageBean pagebean);//模糊查询商品类目

	public Product queryproduct(String productID);//查询商品类目
	
	public int querylikecount(String value); //查询总数
}
