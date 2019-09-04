package com.yuhang.demo.models;

public class Rating {

	private String mId;
	private int mrating;
	
	// We need an empty constructor for restTemplate to put info into it to construct an object from String. 
	public Rating() {}
	
	public Rating(String mId, int mrating) {
		this.mId = mId;
		this.mrating = mrating;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public int getMrating() {
		return mrating;
	}
	public void setMrating(int mrating) {
		this.mrating = mrating;
	}
	
	
}
