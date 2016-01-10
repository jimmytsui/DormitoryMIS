package com.model;

public class ManagementBean {
	private String sno;
	private String num;
	private String date;
	private String error;
	public ManagementBean(){
		
	}
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
