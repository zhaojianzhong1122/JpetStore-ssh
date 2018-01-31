package com.clps.action;

import java.util.List;

import com.clps.entity.Category;
import com.clps.entity.Item;
import com.clps.entity.PageBean;
import com.clps.entity.PageUtil;
import com.clps.entity.Product;
import com.clps.service.impl.CategoryServiceImpl;

/**
 * @author Administrator
 *
 */
public class CategoryAction {
	private CategoryServiceImpl CategoryService;
	private Category category;
	private List<Product> productlist;
	private List<Item> itemlist;
	private Product product;
	private String value; // ģ����ѯ�ؼ���
	private Item item;
	private Long qty; // ���
	private PageBean pageBean = new PageBean(1, 2);
	private PageUtil<Product> pageUtil;

	/**
	 * ��ҳ��ѯ��Ŀ
	 * 
	 * @return
	 */
	public String queryproduct() {

		pageUtil = CategoryService.query(category, pageBean);
		return "success";
	}

	/**
	 * ��ѯ��Ʒ������Ϣ
	 * 
	 * @return
	 */
	public String queryItem() {

		itemlist = (List<Item>) CategoryService.queryItem(product.getProductid());
		product = CategoryService.queryproduct(product.getProductid());
		return "success";
	}

	/**
	 * ģ����ѯ
	 * 
	 * @return
	 */
	public String queryLike() {
		pageUtil = CategoryService.queryLike(value, pageBean);
		return "success";
	}

	/**
	 * ��ѯ��Ʒ������Ϣ
	 * 
	 * @return
	 */
	public String queryQty() {
		qty = CategoryService.queryInventory(item.getItemid());
		Item newitem = CategoryService.queryItemTwo(item.getItemid());
		product = CategoryService.queryproduct(newitem.getProductid());
		item = CategoryService.queryItemTwo(item.getItemid());
		return "success";

	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public PageUtil<Product> getPageUtil() {
		return pageUtil;
	}

	public void setPageUtil(PageUtil<Product> pageUtil) {
		this.pageUtil = pageUtil;
	}

	public Long getQty() {
		return qty;
	}

	public void setQty(Long qty) {
		this.qty = qty;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}

	public List<Product> getProductlist() {
		return productlist;
	}

	public void setProductlist(List<Product> productlist) {
		this.productlist = productlist;
	}


	public void setCategoryService(CategoryServiceImpl categoryService) {
		CategoryService = categoryService;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
