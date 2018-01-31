package com.clps.service;

import com.clps.entity.Cart;
import com.clps.entity.Item;

public interface ShoppingService {
	public Cart addItem(Cart cart, Item item); // 向购物车中添加商品

	public Cart delItem(Cart cart, Item item); // 删除购物车中的商品

	public Cart changeCount(Cart cart, Item item, Integer count);// 改变购物车中商品的数量

	public void clearCart(Cart cart);// 清空购物车

	public Integer queryqty(Item item); //查询库存
	
	public Cart flushqty(Cart cart);//刷新库存
}
