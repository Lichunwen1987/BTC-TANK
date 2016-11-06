package com.okcoin.bean;

/**
 * 实时行情数据
 * @author 李春文
 *
 */
public class Ticker {
	public String date;
	public TickerBean ticker;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public TickerBean getTicker() {
		return ticker;
	}
	public void setTicker(TickerBean ticker) {
		this.ticker = ticker;
	}

	
}

