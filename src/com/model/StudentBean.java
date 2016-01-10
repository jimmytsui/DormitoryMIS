package com.model;

public class StudentBean {
	private String name;
	private String classes;
	private String sno;
	private int bno;
	private String dno;

	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}
	public StudentBean() {

	}
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasses() {
		return classes;
	}

	public void setClasses(String classes) {
		this.classes = classes;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

}
