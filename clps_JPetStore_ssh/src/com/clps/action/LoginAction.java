package com.clps.action;

import com.clps.entity.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import com.clps.service.impl.CategoryServiceImpl;
import com.clps.service.impl.LoginServiceImpl;

/**
 * @author Administrator
 *
 */

public class LoginAction {
	private static Logger logger = Logger.getLogger(LoginAction.class);
	private LoginServiceImpl loginService;
	private CategoryServiceImpl CategoryService;
	private Signon signon;
	private String result;
	private Profile profile;
	private Account account;
	private String userid;
	private PageBean pagebeanMylist= new PageBean(1,3);
	private PageUtil<Product> pageUtilMylist;
	HttpServletRequest request = ServletActionContext.getRequest();

	/**
	 * 登陆验证
	 * 
	 * @return
	 */
	public String login() {
		// 返回前台ajax验证标志
		result = "false";
		logger.info("用户登陆，ajax验证，用户名："+signon.getUserid());
		if (loginService.userLogin(signon.getUserid(), signon.getPassword())) {
			HttpSession session=request.getSession();
			Profile profile=(Profile) session.getAttribute("profile");
			Category category=new Category();
			category.setCatid(profile.getFavcategory());
			pageUtilMylist=CategoryService.query(category, pagebeanMylist);
			session.setAttribute("pageUtilMylist", pageUtilMylist);
			result = "true";
			logger.info("用户登陆成功，用户名："+signon.getUserid());
		}else {
			logger.info("用户登陆失败，用户名："+signon.getUserid());
		}
		return "success";
	}

	/**
	 * 退出登陆，注销session
	 * 
	 * @return
	 */
	public String dropUser() {
		loginService.quit();
		return "success";
	}

	/**
	 * 查询个人信息
	 * 
	 * @return
	 */
	public String queryInfoByUser() {

		if (userid == null || userid == "") {
			HttpSession session = request.getSession();
			userid = (String) session.getAttribute("userid");

			signon = loginService.querySignon(userid);
			profile = loginService.queryProfile(userid);
			account = loginService.queryAccount(userid);

		} else {

			signon = loginService.querySignon(userid);
			profile = loginService.queryProfile(userid);
			account = loginService.queryAccount(userid);

		}
		return "success";

	}

	/**
	 * 保存个人信息
	 * 
	 * @return
	 */
	public String saveProfile() {
		HttpSession session = request.getSession();
		userid = (String) session.getAttribute("userid");
		profile.setUserid(userid);
		loginService.updateSignon(signon);
		account.setUserid(userid);
		loginService.updateAccount(account);
		profile.setUserid(userid);
		loginService.updateProfile(profile);
		return "success";
	}


	public PageBean getPagebeanMylist() {
		return pagebeanMylist;
	}

	public void setPagebeanMylist(PageBean pagebeanMylist) {
		this.pagebeanMylist = pagebeanMylist;
	}

	public PageUtil<Product> getPageUtilMylist() {
		return pageUtilMylist;
	}

	public void setPageUtilMylist(PageUtil<Product> pageUtilMylist) {
		this.pageUtilMylist = pageUtilMylist;
	}

	public void setCategoryService(CategoryServiceImpl categoryService) {
		CategoryService = categoryService;
	}

	public void setLoginService(LoginServiceImpl loginService) {
		this.loginService = loginService;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Signon getSignon() {
		return signon;
	}

	public void setSignon(Signon signon) {
		this.signon = signon;
	}

}
