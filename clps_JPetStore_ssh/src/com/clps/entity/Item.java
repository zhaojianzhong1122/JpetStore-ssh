package com.clps.entity;
// Generated 2018-1-12 12:52:51 by Hibernate Tools 5.2.6.Final

import java.math.BigDecimal;

/**
 * Item generated by hbm2java
 */
public class Item implements java.io.Serializable {

	private String itemid;
	private String productid;
	private BigDecimal listprice;
	private BigDecimal unitcost;
	private Integer supplier;
	private String status;
	private String attr1;
	private String attr2;
	private String attr3;
	private String attr4;
	private String attr5;
	private Integer count;
	private Long qty;
	
	
	public Item(String itemid, String productid, BigDecimal listprice, BigDecimal unitcost, Integer supplier,
			String status, String attr1, String attr2, String attr3, String attr4, String attr5, Integer count,
			Long qty) {
		super();
		this.itemid = itemid;
		this.productid = productid;
		this.listprice = listprice;
		this.unitcost = unitcost;
		this.supplier = supplier;
		this.status = status;
		this.attr1 = attr1;
		this.attr2 = attr2;
		this.attr3 = attr3;
		this.attr4 = attr4;
		this.attr5 = attr5;
		this.count = count;
		this.qty = qty;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Item() {
	}

	public Item(String itemid, String productid) {
		this.itemid = itemid;
		this.productid = productid;
	}

	public Item(String itemid, String productid, BigDecimal listprice, BigDecimal unitcost, Integer supplier,
			String status, String attr1, String attr2, String attr3, String attr4, String attr5) {
		this.itemid = itemid;
		this.productid = productid;
		this.listprice = listprice;
		this.unitcost = unitcost;
		this.supplier = supplier;
		this.status = status;
		this.attr1 = attr1;
		this.attr2 = attr2;
		this.attr3 = attr3;
		this.attr4 = attr4;
		this.attr5 = attr5;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public BigDecimal getListprice() {
		return this.listprice;
	}

	public void setListprice(BigDecimal listprice) {
		this.listprice = listprice;
	}

	public BigDecimal getUnitcost() {
		return this.unitcost;
	}

	public void setUnitcost(BigDecimal unitcost) {
		this.unitcost = unitcost;
	}

	public Integer getSupplier() {
		return this.supplier;
	}

	public void setSupplier(Integer supplier) {
		this.supplier = supplier;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttr1() {
		return this.attr1;
	}

	public void setAttr1(String attr1) {
		this.attr1 = attr1;
	}

	public String getAttr2() {
		return this.attr2;
	}

	public void setAttr2(String attr2) {
		this.attr2 = attr2;
	}

	public String getAttr3() {
		return this.attr3;
	}

	public void setAttr3(String attr3) {
		this.attr3 = attr3;
	}

	public String getAttr4() {
		return this.attr4;
	}

	public void setAttr4(String attr4) {
		this.attr4 = attr4;
	}

	public String getAttr5() {
		return this.attr5;
	}

	public void setAttr5(String attr5) {
		this.attr5 = attr5;
	}

}