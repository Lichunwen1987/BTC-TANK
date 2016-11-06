package com.okcoin.bean;

import java.util.List;

/**
 * 用户的订单信息
 * @author 李春文
 *
 */
public class OrderInfo {
	public String result;
	public List<OrderInfoBean> orders;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public List<OrderInfoBean> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderInfoBean> orders) {
		this.orders = orders;
	}
	
	
}

