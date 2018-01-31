package com.clps.entity;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * ���ﳵ�࣬�����������ﳵ���/ɾ��/�����ܼ�/�޸�����
 * 
 * @author Administrator
 *
 */
public class Cart {
	//������⹺�ﳵ�Ƿ�Ϊ��
	static int isflag=0;
	private String userid;
	private Map<String, Item> cartmap=new HashMap<String,Item>();
	private BigDecimal totalPrice=new BigDecimal(0);

	
	
	public Cart() {
		super();
	}

	public Cart(String userid, Map<String, Item> cartmap, BigDecimal totalPrice) {
		super();
		this.userid = userid;
		this.cartmap = cartmap;
		this.totalPrice = totalPrice;
	}

	public Map<String, Item> getCartmap() {
		return cartmap;
	}

	public void setCartmap(Map<String, Item> cartmap) {
		this.cartmap = cartmap;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public static int getIsflag() {
		return isflag;
	}

	public static void setIsflag(int isflag) {
		Cart.isflag = isflag;
	}

	/**
	 * ���ﳵ�������Ʒ
	 * 
	 * @param session_userid
	 * @param item
	 */
	public void addItem(Item item) {
		if(cartmap==null) {
			cartmap=new HashMap<String,Item>();
		}
		if (cartmap.containsKey(item.getItemid())) {
			item.setCount(cartmap.get(item.getItemid()).getCount() + 1);
		} else {
			item.setCount(1);
			isflag++;
		}
		cartmap.put(item.getItemid(), item);
		price();
	}

	/**
	 * �ӹ��ﳵ��ɾ����Ʒ
	 * 
	 * @param item
	 */
	public void delItem(Item item) {
		cartmap.remove(item.getItemid());
		price();
		isflag--;
	}

	/**
	 * ���㹺�ﳵ����Ʒ�ܺ�
	 */
	public void price() {
		BigDecimal sum = new BigDecimal(0);
		if (cartmap != null) {
			for (Map.Entry<String, Item> entry : cartmap.entrySet()) {
				BigDecimal bcount = new BigDecimal(entry.getValue().getCount());
				BigDecimal temp = bcount.multiply(entry.getValue().getListprice());
				sum = sum.add(temp);
			}
		}

		totalPrice = sum;
	}

	/**
	 * �ı乺�ﳵ����Ʒ������
	 * 
	 * @param item
	 * @param count
	 */
	public void changeCount(Item item, Integer count) {
		item.setCount(count);
		cartmap.put(item.getItemid(), item);
		price();
	}

	/**
	 * ��չ��ﳵ
	 */
	public void clearCart() {
		cartmap.clear();
		price();
		isflag=0;
	}
}
