package com.clps.action;

import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.clps.entity.*;
import com.clps.service.impl.OrderServiceImpl;

public class OrderAction {
	private OrderServiceImpl orderService;
	private Orders orders;
	private Signon signon;
	private String userid;
	private Account account;
	private Lineitem lineitem;
	private LineitemId lineitemid;
	private Long qty;
	HttpServletRequest request = ServletActionContext.getRequest();
	private Date ordertime;
	private String cardtype;
	private String creditcard;
	private String exprdate;
	private List<Orders> orderslist;
	private int orderid;
	private Cart cart;
	private PageBean pageBean = new PageBean(1, 5);
	private PageUtil<Orders> pageUtil;

	/**
	 * 历史订单
	 * @return
	 */
	public String historyOrders() {
		pageUtil = orderService.queryOrder(signon.getUserid(), pageBean);
		return "success";
	}

	/**
	 * 查询订单
	 * @return
	 */
	public String queryOrders() {
		HttpSession session = request.getSession();
		account = orderService.queryAccount(userid);
		orders = orderService.queryOrdersOne(orderid);
		Cart newcart = orderService.queryOrdersItem(orders);
		session.setAttribute("ordercart", newcart);
		return "success";
	}

	/**
	 * 查询账户
	 * @return
	 */
	public String queryAccount() {
		account = orderService.queryAccount(userid);
		return "success";
	}

	/**
	 * 查询账户信息
	 * @return
	 * @throws ParseException
	 */
	public String queryAccounttwo() throws ParseException {
		HttpSession session = request.getSession();
		java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());
		session.setAttribute("account", account);
		session.setAttribute("ordertime", currentDate);
		session.setAttribute("cardtype", cardtype);
		session.setAttribute("exprdate", exprdate);
		session.setAttribute("creditcard", creditcard);
		account = (Account) session.getAttribute("account");
		ordertime = (Date) session.getAttribute("ordertime");
		return "success";

	}

	/**
	 * 确认付款，最后一步，保存订单
	 * 
	 * @return
	 */
	public String saveOrders() {
		HttpSession session = request.getSession();
		cart = (Cart) session.getAttribute("Cart");
		cart.setUserid((String) session.getAttribute("userid"));
		account = (Account) session.getAttribute("account");
		Map<String, String> map = new HashMap<String, String>();
		map.put("creditcard", (String) session.getAttribute("creditcard"));
		map.put("exprdate", (String) session.getAttribute("exprdate"));
		map.put("cardtype", (String) session.getAttribute("cardtype"));
		if (orderService.saveOrder(cart, account, map)) {
			session.removeAttribute("Cart");
			userid=(String) session.getAttribute("userid");
			orderid=(int) session.getAttribute("queryOrdersid");
			return "success";
		} else {

			return "error";
		}

	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public PageUtil<Orders> getPageUtil() {
		return pageUtil;
	}

	public void setPageUtil(PageUtil<Orders> pageUtil) {
		this.pageUtil = pageUtil;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}

	public String getExprdate() {
		return exprdate;
	}

	public void setExprdate(String exprdate) {
		this.exprdate = exprdate;
	}

	public String getCardtype() {
		return cardtype;
	}

	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}

	public List<Orders> getOrderslist() {
		return orderslist;
	}

	public void setOrderslist(List<Orders> orderslist) {
		this.orderslist = orderslist;
	}

	public String QueryOrders() {

		return "success";
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public LineitemId getLineitemid() {
		return lineitemid;
	}

	public void setLineitemid(LineitemId lineitemid) {
		this.lineitemid = lineitemid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Lineitem getLineitem() {
		return lineitem;
	}

	public void setLineitem(Lineitem lineitem) {
		this.lineitem = lineitem;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

	public OrderServiceImpl getOrderService() {
		return orderService;
	}

	public void setOrderService(OrderServiceImpl orderService) {
		this.orderService = orderService;
	}

}
