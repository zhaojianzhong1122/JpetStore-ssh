package com.clps.entity;
// Generated 2018-1-12 12:52:51 by Hibernate Tools 5.2.6.Final

/**
 * Sequence generated by hbm2java
 */
public class Sequence implements java.io.Serializable {

	private String name;
	private int nextid;

	public Sequence() {
	}

	public Sequence(String name, int nextid) {
		this.name = name;
		this.nextid = nextid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNextid() {
		return this.nextid;
	}

	public void setNextid(int nextid) {
		this.nextid = nextid;
	}

}