package com.model;

public class Dormitory {
	private String cno;
	private String name;
	private int maxpeo;
	private int peo;
	private int bno;
	public Dormitory() {

	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public int getMaxpeo() {
		return maxpeo;
	}

	public void setMaxpeo(int maxpeo) {
		this.maxpeo = maxpeo;
	}

	public int getPeo() {
		return peo;
	}

	public void setPeo(int peo) {
		this.peo = peo;
	}



}
