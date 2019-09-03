package com.yuhang.demo.models;

public class CatalogItem {

	private String mname;
	private String mdesc;
	private int mrating;
	
	public CatalogItem(String mname, String mdesc, int mrating) {
		super();
		this.mname = mname;
		this.mdesc = mdesc;
		this.mrating = mrating;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMdesc() {
		return mdesc;
	}
	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}
	public int getMrating() {
		return mrating;
	}
	public void setMrating(int mrating) {
		this.mrating = mrating;
	}
	
	
}
