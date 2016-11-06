package com.okcoin.bean;

/**
 * 获取OKCoin最近600交易信息
 * @author 李春文
 *
 */
public class Trades {
	/**
	date:交易时间
	date_ms:交易时间(ms)
	price: 交易价格
	amount: 交易数量
	tid: 交易生成ID
	type: buy/sell
	 */
	public String date;
	public String date_ms;
	public String price;
	public String amount;
	public String tid;
	public String type;	
	
	public Trades(){
		
	}
			
	public Trades(String date, String date_ms, String price, String amount, String tid, String type) {
		super();
		this.date = date;
		this.date_ms = date_ms;
		this.price = price;
		this.amount = amount;
		this.tid = tid;
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate_ms() {
		return date_ms;
	}
	public void setDate_ms(String date_ms) {
		this.date_ms = date_ms;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getTid() {
		return tid;
	}
	public void setTid(String tid) {
		this.tid = tid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Trades [date=" + date + ", date_ms=" + date_ms + ", price=" + price + ", amount=" + amount + ", tid="
				+ tid + ", type=" + type + "]";
	}

}
