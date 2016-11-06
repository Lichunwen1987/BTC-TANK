package com.okcoin.mybean;


/**
 * 均线取值
 * @author lichunwen-kimi
 *
 */
public class Mline {
	//MA均值值
	public double ma;
	
	//MA取值粒度
	private int mNum;
	private double[] ms;
	private double sum;
	
	//游标位置
	private int cur = 0;  
	private double first;	
	private double last;
	
	/**
	 * 
	 * @param mNum 均线数量
	 */
	public Mline(int mNum){
		this.mNum = mNum;	
		ms = new double[mNum];
	}

	/**
	 * 更新均线值
	 * @param price 当前价格
	 * @return 均线值
	 */
	public double update(double price){
		//取最早时间值
		first = ms[cur];
		last = price;
		sum = sum + last -first;
		//更新当前价格
		ms[cur]=price;
		cur = cur==mNum-1 ? 0 : ++cur;	
		ma = sum/mNum;
		return ma;
	}
	
	public double getMA(){
		return ma;
	}
}
