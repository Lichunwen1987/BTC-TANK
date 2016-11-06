package com.okcoin.bean;


/**
 * 返回可用btc，ltc，cny数量
 * @author 李春文
 */
public class Free{
	
	public String btc;
	public String cny;
	public String ltc;	

	public Free() {

	}	
	
	public Free(String btc, String cny, String ltc) {
		super();
		this.btc = btc;
		this.cny = cny;
		this.ltc = ltc;
	}


	public String getBtc() {
		return btc;
	}


	public void setBtc(String btc) {
		this.btc = btc;
	}


	public String getCny() {
		return cny;
	}


	public void setCny(String cny) {
		this.cny = cny;
	}


	public String getLtc() {
		return ltc;
	}


	public void setLtc(String ltc) {
		this.ltc = ltc;
	}


	@Override
	public String toString() {
		return "UserInfo [btc=" + btc + ", cny=" + cny + ", ltc=" + ltc + "]";
	}
}