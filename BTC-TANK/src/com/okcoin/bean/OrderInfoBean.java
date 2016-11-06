package com.okcoin.bean;


public class OrderInfoBean {
/**返回值说明
amount:委托数量
create_date: 委托时间
avg_price:平均成交价
deal_amount:成交数量
order_id:订单ID
orders_id:订单ID(不建议使用)
price:委托价格
status:-1:已撤销  0:未成交  1:部分成交  2:完全成交 4:撤单处理中
type:buy_market:市价买入 / sell_market:市价卖出
*/
	public String amount;
	public String create_date;
	public String avg_price;
	public String deal_amount;
	public String order_id;
	public String orders_id;
	public String price;
	public String status;
	public String type;
	
	public OrderInfoBean() {

	}
	
	public OrderInfoBean(String amount, String create_date, String avg_price, String deal_amount, String order_id,
			String orders_id, String price, String status, String type) {
		super();
		this.amount = amount;
		this.create_date = create_date;
		this.avg_price = avg_price;
		this.deal_amount = deal_amount;
		this.order_id = order_id;
		this.orders_id = orders_id;
		this.price = price;
		this.status = status;
		this.type = type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getAvg_price() {
		return avg_price;
	}

	public void setAvg_price(String avg_price) {
		this.avg_price = avg_price;
	}

	public String getDeal_amount() {
		return deal_amount;
	}

	public void setDeal_amount(String deal_amount) {
		this.deal_amount = deal_amount;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getOrders_id() {
		return orders_id;
	}

	public void setOrders_id(String orders_id) {
		this.orders_id = orders_id;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {

		//buy_market, 价格:4000, 数量:0.01, 订单号:
		return type + ", 价格:" + avg_price + ", 数量:" + deal_amount + ", 订单号:" + order_id;
	}
	
	
	
	
}