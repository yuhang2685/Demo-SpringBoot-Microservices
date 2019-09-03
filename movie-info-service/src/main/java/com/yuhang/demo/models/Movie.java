package com.yuhang.demo.models;

public class Movie {

	private String mId;
	private String mname;
		
	public Movie(String mId, String mname) {
		super();
		this.mId = mId;
		this.mname = mname;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}		

	
}
