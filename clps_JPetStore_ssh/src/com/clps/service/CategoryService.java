package com.clps.service;

import java.util.List;

import com.clps.dao.DaoCategory;
import com.clps.entity.*;

public interface CategoryService {

	public PageUtil<Product> query(Category category, PageBean pagebean);//分页查询商品类目
	
	public int querycount(Category category); //查询总数
	
	public List<Item> queryItem(String produceID);//根据ID查询具体商品

	public long queryInventory(String itemid);//查询商品库存

	public Item queryItemTwo(String itemid);//查询商品具体信息

	public PageUtil<Product> queryLike(String value, PageBean pagebean);//模糊搜索分页查询

	public Product queryproduct(String productID);//查询商品类目

}
