package com.okcoin.bean;

/**
 * 实时行情数据
 * @author 李春文
 *
 */
public class TickerBean {
	//返回数据时服务器时间
	public String date; 
	//买一价	
	public String buy; 
	//最高价
	public String high; 
	//最新成交价
	public String last;
	//最低价
	public String low; 
	//卖一价
	public String sell;
	//成交量(最近的24小时)
	public String vol; 
	
	public TickerBean() {

	}
	
	public TickerBean(String date, String buy, String high, String last, String low, String sell, String vol) {
		super();
		this.date = date;
		this.buy = buy;
		this.high = high;
		this.last = last;
		this.low = low;
		this.sell = sell;
		this.vol = vol;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getBuy() {
		return buy;
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	public String getHigh() {
		return high;
	}
	public void setHigh(String high) {
		this.high = high;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getLow() {
		return low;
	}
	public void setLow(String low) {
		this.low = low;
	}
	public String getSell() {
		return sell;
	}
	public void setSell(String sell) {
		this.sell = sell;
	}
	public String getVol() {
		return vol;
	}
	public void setVol(String vol) {
		this.vol = vol;
	}

	@Override
	public String toString() {
		return "Ticker [date=" + date + ", buy=" + buy + ", high=" + high + ", last=" + last + ", low=" + low
				+ ", sell=" + sell + ", vol=" + vol + "]";
	}


}