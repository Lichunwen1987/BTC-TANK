package com.okcoin.rest;

import java.io.IOException;
import java.util.List;
import java.util.Timer;

import org.apache.http.HttpException;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.okcoin.bean.OrderInfo;
import com.okcoin.bean.Ticker;
import com.okcoin.bean.TradeInfo;
import com.okcoin.bean.Trades;
import com.okcoin.bean.UserInfo;
import com.okcoin.rest.stock.IStockRestApi;
import com.okcoin.rest.stock.impl.StockRestApi;
import com.okcoin.trade.BTCTrade;

/**
 * 现货 REST API 客户端请求
 * @author zhangchi
 *
 */
/**
 * @author lichunwen-kimi
 *
 */
public class StockClient {

	/**
	 * @param args
	 * @throws HttpException
	 * @throws IOException
	 */
	/**
	 * @param args
	 * @throws HttpException
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws HttpException, IOException, InterruptedException{
		
		//交易测算最小时间粒度（ms）
		int period = 2000;
		
        Timer timer = new Timer();  
        
      //  BTCTrade btctrade = new BTCTrade();
        //cny为持仓状态,btc为持币状态。
      //  btctrade.Ini("cny",period);
     //   timer.schedule(btctrade, 0, period);  
		
	    String api_key = "ee60112b-32bc-4b3e-96fb-581272c4a11a";  //OKCoin申请的apiKey
       	String secret_key = "E686DAB1C68DEB5786572AF254EE9BA0";  //OKCoin 申请的secret_key
 	    String url_prex = "https://www.okcoin.cn";  //注意：请求URL 国际站https://www.okcoin.com ; 国内站https://www.okcoin.cn
 		final String btc = "btc_cny";	
	    /**
	     * get请求无需发送身份认证,通常用于获取行情，市场深度等公共信息
	     * 
	    */
	    IStockRestApi stockGet = new StockRestApi(url_prex);
	    

	    /**
	     * post请求需发送身份认证，获取用户个人相关信息时，需要指定api_key,与secret_key并与参数进行签名，
	     * 此处对构造方法传入api_key与secret_key,在请求用户相关方法时则无需再传入，
	     * 发送post请求之前，程序会做自动加密，生成签名。
	     * 
	    */
	    IStockRestApi stockPost = new StockRestApi(url_prex, api_key, secret_key);
	    
	   // stockGet.tickerlast(btc);
	    
	   // String tradeInfo = stockPost.trade(btc, "buy_market", "900","");

		// String str1 = stockPost.trade("btc_cny", "buy_market", "1000","");
		// System.out.println(str1);
	    /*
	     String v3=stockPost.userinfo();
	     UserInfo uinfo = JSON.parseObject(v3,UserInfo.class);
	     System.out.println(uinfo.getFunds().getFree());
	     
	     String info = JSON.parseObject(v3).get("info").toString();
	     System.out.println(info);
	     
	     String funds = JSON.parseObject(info).get("funds").toString();
	     
	     UserInfo uinfo = JSON.parseObject(JSON.parseObject(funds).get("free").toString(), UserInfo.class);
	     System.out.println(uinfo);
	  //   JSON.parse;
	    // uinfo=JSON.parseObject(v3).parseObject("free", UserInfo.class);
	    // uinfo=JSON.parseObject(v3).parseObject("free", UserInfo.class);
	     //System.out.println(uinfo.toString());
	     //System.out.println(v3);
		// String str1 = stockPost.trade(btc, "sell_market", "","0.01");
		// System.out.println(str1);
		// String order = str1.substring(12,str1.indexOf(",\""));
	//	 System.out.println(order);
		// String orderjsonstr = stockPost.order_info(btc, order);
		// System.out.println(orderjsonstr);
		 
		 //orders信息，下单有可能会拆成多单
		// String orderInfo = JSON.parseObject(orderjsonstr).get("orders").toString();
		// System.out.println(orderInfo);
		// List<OrderInfo> orders = JSON.parseArray(orderInfo, OrderInfo.class); 
		// for (int i=0;i<orders.size();i++){
		//	 System.out.println(orders.get(i));
		// }
		 /*	
		 String str2 = stockPost.trade(btc, "sell_market", "","0.01");
		 System.out.println(str2);
		 String order2 = str2.substring(12,str2.indexOf(",\""));
		 System.out.println(order2);
		 System.out.println(stockPost.order_info(btc, order2));

		 String str3 = stockPost.trade(btc, "sell_market", "","0.01");
		 System.out.println(str3);
		 String order3 = str3.substring(12,str3.indexOf(",\""));
		 System.out.println(order3);
		 System.out.println(stockPost.order_info(btc, order3));		 
		 
		 String str4 = stockPost.trade(btc, "sell_market", "","0.01");
		 System.out.println(str4);
		 String order4 = str4.substring(12,str4.indexOf(",\""));
		 System.out.println(order4);	
		 System.out.println(stockPost.order_info(btc, order4));				 
	
	    String v1=stockGet.ticker("btc_usd");
	    System.out.println(v1);
	    System.out.println(System.currentTimeMillis()/1000L);
	    String v4=stockGet.kline("btc_cny", "1min", "10", JSON.parseObject(v1).get("date").toString());	    
        //  String v4=stockGet.kline("btc_cny", "1min", "1", "1478104540000");
        System.out.println(v4);
        System.out.println(System.currentTimeMillis()/1000L);
        
	    /*	
	    //现货行情
	    
	    String v1=stockGet.ticker("btc_usd");
	    System.out.println(v1);
	    //JSONObject object = JSON.parseObject(v1);  
        //System.out.println(object.get("tricker	"));  
	    JSONObject object = JSON.parseObject(v1).getJSONObject("ticker");
        Ticker tk = JSON.toJavaObject(object, Ticker.class);
        System.out.print(tk);
       // List<Ticker> tkst = JSON.parseObject(v1, Ticker.class);	

	    

        //现货市场深度
        //stockGet.depth("btc_usd");
        String v2=stockGet.trades("btc_cny");
        
       // System.out.print(v2);
       // List<>
        /*
        List<Trades> trades = JSON.parseArray(v2, Trades.class);
        
        for(int i=0;i<trades.size();i++)   
        {  
            System.out.println(trades.get(i));  
        } 
        */ 
        		
        //现货OKCoin历史交易信息
        //String v2=stockGet.trades("btc_usd", "20");
        //System.out.println(v2);
	 
	    //现货用户信息
       //String v3=stockPost.userinfo();
       // System.out.println(v3);

	    /**	 	
	    //现货下单交易
	    String tradeResult = stockPost.trade("btc_usd", "buy", "50", "0.02");
	    System.out.println(tradeResult);
	    JSONObject tradeJSV1 = JSONObject.parseObject(tradeResult);
	    String tradeOrderV1 = tradeJSV1.getString("order_id");

	    //现货获取用户订单信息
        stockPost.order_info("btc_usd", tradeOrderV1);
		
	    //现货撤销订单
	    stockPost.cancel_order("btc_usd", tradeOrderV1);
		
	    //现货批量下单
	    stockPost.batch_trade("btc_usd", "buy", "[{price:50, amount:0.02},{price:50, amount:0.03}]");

	    //批量获取用户订单
	    stockPost.orders_info("0", "btc_usd", "125420341, 125420342");
		
	    //获取用户历史订单信息，只返回最近七天的信息
	    stockPost.order_history("btc_usd", "0", "1", "20");
		
		 */
		
		
	}
	
    /**
     * 行情
     * @param symbol btc_usd:比特币    ltc_usd :莱特币
     * @return
     * @throws IOException 
     * @throws HttpException 
    */	
	/*
	public static Ticker getTicker(String tickerJson) {
	   Ticker ticker = new Ticker();
        try
        {   //将json字符串转换为json对象
            JSONObject jsonObj = new JSONObject();
            jsonObj.par	
            // 得到指定json key对象的value对象
            JSONObject TickerObj = jsonObj.getJSONObject("Ticker");
            // 获取之对象的所有属性
            Ticker.setId(TickerObj.getInt("id"));
            Ticker.setName(TickerObj.getString("name"));
            Ticker.setAddress(TickerObj.getString("address"));
        }
        catch (JSONException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return Ticker;		
	}
	*/
}
