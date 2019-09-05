package com.yuhang.demo.models;

public class Movie {

	private String mId;
	private String mname;
	private String description;
	
	// We need an empty constructor for restTemplate to put info into it to construct an object from String. 
	public Movie() {}
	
	public Movie(String mId, String mname, String description) {
		super();
		this.mId = mId;
		this.mname = mname;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}		


	
}
