package com.okcoin.trade;

import java.io.IOException;
import java.util.TimerTask;

import org.apache.http.HttpException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.bean.Asset;
import com.okcoin.bean.Free;
import com.okcoin.bean.OrderInfo;
import com.okcoin.bean.TradeInfo;
import com.okcoin.mybean.Box;
import com.okcoin.rest.stock.IStockRestApi;
import com.okcoin.rest.stock.impl.StockRestApi;

public class BTCTrade extends TimerTask{
	
	// TODO Auto-generated method stub
    String api_key = "ee60112b-32bc-4b3e-96fb-581272c4a11a";  //OKCoin申请的apiKey
   	String secret_key = "E686DAB1C68DEB5786572AF254EE9BA0";  //OKCoin 申请的secret_key
	String url_prex = "https://www.okcoin.cn";  //注意：请求URL 国际站https://www.okcoin.com ; 国内站https://www.okcoin.cn

    /**
     * get请求无需发送身份认证,通常用于获取行情，市场深度等公共信息
     * 
    */
    IStockRestApi stockGet = new StockRestApi(url_prex);
    
    IStockRestApi stockPost = new StockRestApi(url_prex, api_key, secret_key);
    
	private static String btc = "btc_cny";
	//攻击MA取值粒度
	private int m1;
	//操作MA取值粒度
	private int m2;
	
	private double[] m1s;
	private double[] m2s;
	
	private double sum1;
	private double sum2;
	//攻击MA均值
	private double md1;
	//操作MA均值
	private double md2;
	
	//循环控制读取均线粒度值
	private int loop1 = 0;  
	private int loop2 = 0;  
	private double last1;
	private double first1;	
	private double last2;
	private double first2;		


	//交易后信息，orderid
	private String tradeInfo;
	//cny为持仓状态,btc为持币状态
	private String state;
	//粒度时间
	private int sleeptime;
	
	//持币数量
	Free free = new Free();
	//持仓数量
	Asset ass = new Asset();
	//箱体参数
	Box box;

	/**
	 * 
	 * @param m1 攻击均线K线数
	 * @param m2 操作均线K线数
	 * @param stick 箱体K线数
	 * @param state 当前持币或持仓状态
	 * @param sleeptime 请求间隔时间
	 * @throws HttpException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public BTCTrade(int m1, int m2, int stick, String state, int sleeptime) throws HttpException, IOException, InterruptedException{
		this.m1 = m1;
		this.m2 = m2;
		this.sleeptime = sleeptime;
		m1s = new double[m1];
		m2s = new double[m2];
		//箱体参数
		Box box = new Box(stick);
		Ini();
	}
	  /**
     * 将初始均线粒值填充
	 * @throws InterruptedException 
     * 
    */		
	public void Ini() throws HttpException, IOException, InterruptedException{
				
		int i1=0; 
		for (int i2=0;i2 < m2;i2++){
			m2s[i2] = stockGet.tickerlast(btc);
			//更新箱体值
			box.update(m2s[i2]);
			sum2 += m2s[i2];
			if (i2 >= m2-m1){
				m1s[i1] = m2s[i2];
				sum1 += m1s[i1];
				++i1;
			}

			Thread.sleep(sleeptime);
		}
		//TODO：此处填充的值没有按时间粒度来
		md1 = sum1/m1;
		md2 = sum2/m2;
		
		//获取用户持仓信息
		RefreshUserInfo();

	}
	
	@Override
	public void run() {

		try {
			//执行ma算法
			ma();
						
		} catch (HttpException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
  
    /**
     * MA交叉
     * 
    */	
	private void ma() throws HttpException, IOException{

		last1 = stockGet.tickerlast(btc);
		last2 = last1;
		
		//取最价格
		first1 = m1s[loop1];
		first2 = m2s[loop2];
		
		//加最新价格，减最早价格
		sum1 = sum1 + last1 -first1; 
		sum2 = sum2 + last2 -first2; 
		
		//更新最早价格
		m1s[loop1] = last1;
		m2s[loop2] = last2;
		
		loop1 = loop1==m1-1 ? 0 : ++loop1;
		loop2 = loop2==m2-1 ? 0 : ++loop2;
		
		md1 = sum1/m1;
		md2 = sum2/m2;
		PrintMAInfo();		
		//当前状态为持币，上交叉，买入
		if (md1 > md2 & state.equals("cny")){
	
			//市价买入
			tradeInfo = stockPost.trade(btc, "buy_market", free.getCny(),"");
			//反馈成交信息
			PTradeInfo(tradeInfo);
			//重新获取用户信息
			RefreshUserInfo();
			//更新为持币
			state = "btc";
		//当前状态为持仓，下交叉，卖出
		}else if(md1 < md2 & state.equals("btc")){
	
			//市价卖出
			tradeInfo = stockPost.trade(btc, "sell_market", "",free.getBtc());
			//反馈成交信息
			PTradeInfo(tradeInfo);
			//重新获取用户信息
			RefreshUserInfo();
			//更新为持仓
			state = "cny";
		}
		
				
	}

	private void PrintMAInfo() {
		// TODO Auto-generated method stub
		//System.out.print(Double.toString(m1s[loop1])+", ");
		//System.out.print(Double.toString(m2s[loop2])+", ");		
		System.out.print("MA1="+Double.toString(md1)+", ");
		System.out.print("MA2="+Double.toString(md2)+", ");	
		if(state.equals("btc")){
			System.out.println("BTC-持币状态");
		}else{
			System.out.println("持仓状态");
		}
	}
	private void RefreshUserInfo()  throws HttpException, IOException{
		 //嵌套json就是不断的getJSONObject
		 JSONObject info = JSON.parseObject(stockPost.userinfo()).getJSONObject("info");	     
		 JSONObject funds = info.getJSONObject("funds");    
	     free = JSON.parseObject(funds.getJSONObject("free").toString(), Free.class);
	     ass = JSON.parseObject(funds.getJSONObject("asset").toString(), Asset.class);
	   	 System.out.println(free);
	   	 System.out.println(ass);	
	}		
	private void PTradeInfo(String tradeInfo) throws HttpException, IOException {

		TradeInfo trade = JSON.parseObject(tradeInfo,TradeInfo.class);
		String orderjsonstr = null;

		orderjsonstr = stockPost.order_info(btc, trade.getOrder_id());

		OrderInfo orders = JSON.parseObject(orderjsonstr, OrderInfo.class);
		try {
			for (int i=0;i<orders.getOrders().size();i++){
				System.out.println(orders.getOrders().get(i));
			}
		} catch (NullPointerException e) {
			System.out.println(orderjsonstr);	
		}
	}


}	



	