package com.clps.service.impl;

import java.util.List;

import com.clps.dao.impl.DaoCategoryImpl;
import com.clps.entity.Category;
import com.clps.entity.Item;
import com.clps.entity.PageBean;
import com.clps.entity.PageUtil;
import com.clps.entity.Product;
import com.clps.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	private DaoCategoryImpl catedao;
	PageUtil<?> pagetutil;

	public void setCatedao(DaoCategoryImpl catedao) {
		this.catedao = catedao;
	}

	@Override
	public PageUtil<Product> query(Category category, PageBean pagebean) {
		// TODO Auto-generated method stub
		List<Product> list = catedao.query(category, pagebean);
		int totalCount = catedao.querycount(category);
		int pageSize = pagebean.getLimit();
		int currPage = pagebean.getPage();
		PageUtil<Product> pageutil = new PageUtil<Product>(list, totalCount, pageSize, currPage);
		return pageutil;
	}

	@Override
	public List<Item> queryItem(String produceID) {
		// TODO Auto-generated method stub
		return catedao.queryItem(produceID);
	}

	@Override
	public long queryInventory(String itemid) {
		// TODO Auto-generated method stub
		return catedao.queryInventory(itemid);
	}

	@Override
	public Item queryItemTwo(String itemid) {
		// TODO Auto-generated method stub
		return catedao.queryItemTwo(itemid);
	}

	@Override
	public PageUtil<Product> queryLike(String value, PageBean pagebean) {
		// TODO Auto-generated method stub
		List<Product> list = catedao.queryLike(value, pagebean);
		int totalCount = catedao.querylikecount(value);
		int pageSize = pagebean.getLimit();
		int currPage = pagebean.getPage();
		PageUtil<Product> pageutil = new PageUtil<Product>(list, totalCount, pageSize, currPage);
		return pageutil;
	}

	@Override
	public Product queryproduct(String productID) {
		// TODO Auto-generated method stub
		return catedao.queryproduct(productID);
	}

	@Override
	public int querycount(Category category) {
		// TODO Auto-generated method stub
		return catedao.querycount(category);
	}

}
