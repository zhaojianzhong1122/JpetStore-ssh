package com.clps.service;

import com.clps.entity.Cart;
import com.clps.entity.Item;

public interface ShoppingService {
	public Cart addItem(Cart cart, Item item); // ���ﳵ�������Ʒ

	public Cart delItem(Cart cart, Item item); // ɾ�����ﳵ�е���Ʒ

	public Cart changeCount(Cart cart, Item item, Integer count);// �ı乺�ﳵ����Ʒ������

	public void clearCart(Cart cart);// ��չ��ﳵ

	public Integer queryqty(Item item); //��ѯ���
	
	public Cart flushqty(Cart cart);//ˢ�¿��
}
