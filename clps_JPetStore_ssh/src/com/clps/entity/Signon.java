package com.clps.entity;
// Generated 2018-1-12 12:52:51 by Hibernate Tools 5.2.6.Final

/**
 * Signon generated by hbm2java
 */
public class Signon implements java.io.Serializable {

	private String userid;
	private String password;

	public Signon() {
	}

	public Signon(String userid, String password) {
		this.userid = userid;
		this.password = password;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
