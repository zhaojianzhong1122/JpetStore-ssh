package com.clps.entity;

import java.io.Serializable;

/**
 * 分页工具类
 * @author Administrator
 *
 */
public class PageBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// 当前页码
	private int page;
	// 每页条数
	private int limit;

	public PageBean() {
	}

	public PageBean(int page, int limit) {
		this.page = page;
		this.limit = limit;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
