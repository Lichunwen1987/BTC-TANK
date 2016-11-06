package com.okcoin.bean;

public class Funds{
	public Free free = new Free();	

	public Funds() {

	}
	
	public Funds(Free free) {
		super();
		this.free = free;
	}
	public Free getFree() {
		return free;
	}
	public void setFree(Free free) {
		this.free = free;
	}	
}