package com.okcoin.bean;

/**
 * 返回可用btc，ltc，cny数量
 * @author 李春文
 */
public class Asset {
	
	public String net;
	public String total;

	public Asset() {

	}
	
	
	public Asset(String net, String total) {
		super();
		this.net = net;
		this.total = total;
	}
	
	public String getNet() {
		return net;
	}
	public void setNet(String net) {
		this.net = net;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}


	@Override
	public String toString() {
		return "Asset [net=" + net + ", total=" + total + "]";
	}
	
	

}
