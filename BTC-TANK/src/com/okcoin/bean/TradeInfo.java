package com.okcoin.bean;

/**
 * 下单返回数据
 * @author 李春文
 *
 */
public class TradeInfo {
	public String result;
	public String order_id;
	public TradeInfo() {

	}	
	public TradeInfo(String result, String order_id) {
		super();
		this.result = result;
		this.order_id = order_id;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	@Override
	public String toString() {
		return "TradeInfo [result=" + result + ", order_id=" + order_id + "]";
	}


	
}
