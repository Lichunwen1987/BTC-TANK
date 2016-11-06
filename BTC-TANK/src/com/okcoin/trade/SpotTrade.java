package com.okcoin.trade;

import java.io.IOException;
import java.util.Timer;

import org.apache.http.HttpException;


/**
 * 现货交易
 * @author lichunwen-kimi
 *
 */
public class SpotTrade {

	public static void main(String[] args) throws HttpException, IOException, InterruptedException {
		// TODO Auto-generated method stub

		//交易测算最小时间粒度（ms）
		int period = 2000;
		
        Timer timer = new Timer();  
        
        BTCTrade btctrade = new BTCTrade(7,30,60,"btc",2000);
        
        timer.schedule(btctrade, 0, period);  
        
	}

}
