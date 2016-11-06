package com.okcoin.mybean;

/**
 * 箱体理论-箱体
 * @author lichunwen-kimi
 *
 */

public class Box {
	public double high;
	public double low;
	private int sticknum;
	//游标位置
	private int cur=0;
	private double[] sticks;

	/**
	 * 
	 * @param sticknum 箱体中K线数量
	 */
	public Box(int sticknum) {
		super();
		this.high = Double.MIN_VALUE;
		this.low = Double.MAX_VALUE;
		this.sticknum = sticknum;
		sticks = new double[sticknum];
	}
	
	public Box(double high, double low, int sticknum) {
		super();
		this.high = high;
		this.low = low;
		this.sticknum = sticknum;
		sticks = new double[sticknum];
	}
	public double getUp() {
		return high;
	}
	public void setUp(double high) {
		this.high = high;
	}
	public double getDown() {
		return low;
	}
	public void setDown(double low) {
		this.low = low;
	}

	@Override
	public String toString() {
		return "Box [high=" + high + ", low=" + low + "]";
	}
	/**
	 * 更新箱体范围与高低点
	 * @param value 最新成交价格
	 */
	public void update(double value){

		cur = cur==sticknum-1 ? 0 : ++cur;
		sticks[cur] = value;

		if (value > high){
			high = value;
		}else if (value < low){
			low = value;
		}
	}
	
}
