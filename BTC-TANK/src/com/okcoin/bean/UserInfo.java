package com.okcoin.bean;

/**
 * 获取用户信息,btc,ltc,现金持仓
 * @author 李春文
 *
 */
public class UserInfo {

	public String result;
	public Funds funds = new Funds();

	public UserInfo() {

	}
	
	public UserInfo(String result, Funds funds) {
		super();
		this.result = result;
		this.funds = funds;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Funds getFunds() {
		return funds;
	}
	public void setFunds(Funds funds) {
		this.funds = funds;
	}

}




