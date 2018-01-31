package com.clps.service.impl;

import java.util.Map;

import com.clps.dao.impl.DaoCategoryImpl;
import com.clps.entity.Cart;
import com.clps.entity.Item;
import com.clps.service.ShoppingService;

public class ShoppingServiceImpl implements ShoppingService {
	private DaoCategoryImpl catedao;

	public void setCatedao(DaoCategoryImpl catedao) {
		this.catedao = catedao;
	}

	@Override
	public Cart addItem(Cart cart, Item item) {
		// TODO Auto-generated method stub
		String itemid = item.getItemid();
		Long qty = item.getQty();
		Item newItem = catedao.queryItemTwo(itemid);
		newItem.setQty(qty);
		if (cart == null) {
			cart = new Cart();
		}
		cart.addItem(newItem);
		return cart;
	}

	@Override
	public Cart delItem(Cart cart, Item item) {
		// TODO Auto-generated method stub
		Item newItem = catedao.queryItemTwo(item.getItemid());
		cart.delItem(newItem);
		return cart;
	}

	@Override
	public Cart changeCount(Cart cart, Item item, Integer count) {
		// TODO Auto-generated method stub
		Long qty = item.getQty();
		Item newItem = catedao.queryItemTwo(item.getItemid());
		newItem.setQty(qty);
		cart.changeCount(newItem, count);
		return cart;
	}

	@Override
	public void clearCart(Cart cart) {
		// TODO Auto-generated method stub
		cart.clearCart();
	}

	@Override
	public Integer queryqty(Item item) {
		// TODO Auto-generated method stub
		Integer qty = (int) catedao.queryInventory(item.getItemid());
		return qty;
	}

	@Override
	public Cart flushqty(Cart cart) {
		// TODO Auto-generated method stub
		Map<String, Item> map = cart.getCartmap();
		for (Map.Entry<String, Item> entry : map.entrySet()) {
			entry.getValue().setQty(catedao.queryInventory(entry.getValue().getItemid()));
			map.put(entry.getKey(), entry.getValue());
		}
		cart.setCartmap(map);
		return cart;
	}

}
