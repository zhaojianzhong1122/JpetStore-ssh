package com.clps.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.clps.entity.*;
import com.clps.service.impl.CategoryServiceImpl;
import com.clps.service.impl.ShoppingServiceImpl;

public class ShoppingAction {
	private ShoppingServiceImpl shoppingService;
	private CategoryServiceImpl categoryService;
	private Item item;
	private String itemid;
	private String userid;
	private Cart cart;
	private int qty;
	private int count;
	private String result;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();

	/**
	 * 添加商品
	 * 
	 * @return
	 */
	public String saveCart() {
		Item item = new Item();
		item.setItemid(itemid);
		item.setQty(categoryService.queryInventory(itemid));
		cart = (Cart) session.getAttribute("Cart");
		cart = shoppingService.addItem(cart, item);
		session.setAttribute("Cart", cart);
		result = "true";
		return "success";

	}

	/**
	 * 删除商品
	 * 
	 * @return
	 */
	public String delCart() {
		Item item = new Item();
		item.setItemid(itemid);
		cart = (Cart) session.getAttribute("Cart");
		cart = shoppingService.delItem(cart, item);
		session.setAttribute("Cart", cart);
		return "success";
	}

	/**
	 * 更改数量
	 * 
	 * @return
	 */
	public String saveCount() {
		result = "false";
		item.setQty(categoryService.queryInventory(item.getItemid()));
		cart = (Cart) session.getAttribute("Cart");
		if (shoppingService.queryqty(item) >= count) {
			cart = shoppingService.changeCount(cart, item, count);
			session.setAttribute("Cart", cart);
			result = "true";
		}

		return "success";
	}

	/**
	 * 刷新购物车中的库存
	 * 
	 * @return
	 */
	public String flushqty() {
		result = "false";
		cart = (Cart) session.getAttribute("Cart");
		if (cart == null || cart.getCartmap() == null) {
			return "success";
		} else {
			cart = shoppingService.flushqty(cart);
			session.setAttribute("Cart", cart);
			result="true";
		}

		return "success";
	}

	public String checkout() {

		return "success";
	}

	public void setCategoryService(CategoryServiceImpl categoryService) {
		this.categoryService = categoryService;
	}

	public String getItemid() {
		return itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public int getQty() {
		return qty;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setShoppingService(ShoppingServiceImpl shoppingService) {
		this.shoppingService = shoppingService;
	}
}
