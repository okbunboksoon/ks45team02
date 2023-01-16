package ks45team02.ire.admin.dto;

public class GoodsBuyingPayment {
	
	private String goods_buy_payment_code;
	private String business_code;
	private String business_name;
	private int buy_total;
	private int payment;
	private int accounts_payable;
	private String payment_account_type;
	private String payment_bank;
	private String payment_account_code;
	private String goods_buy_payment_day;
	public String getGoods_buy_payment_code() {
		return goods_buy_payment_code;
	}
	public void setGoods_buy_payment_code(String goods_buy_payment_code) {
		this.goods_buy_payment_code = goods_buy_payment_code;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getBusiness_name() {
		return business_name;
	}
	public void setBusiness_name(String business_name) {
		this.business_name = business_name;
	}
	public int getBuy_total() {
		return buy_total;
	}
	public void setBuy_total(int buy_total) {
		this.buy_total = buy_total;
	}
	public int getPayment() {
		return payment;
	}
	public void setPayment(int payment) {
		this.payment = payment;
	}
	public int getAccounts_payable() {
		return accounts_payable;
	}
	public void setAccounts_payable(int accounts_payable) {
		this.accounts_payable = accounts_payable;
	}
	public String getPayment_account_type() {
		return payment_account_type;
	}
	public void setPayment_account_type(String payment_account_type) {
		this.payment_account_type = payment_account_type;
	}
	public String getPayment_bank() {
		return payment_bank;
	}
	public void setPayment_bank(String payment_bank) {
		this.payment_bank = payment_bank;
	}
	public String getPayment_account_code() {
		return payment_account_code;
	}
	public void setPayment_account_code(String payment_account_code) {
		this.payment_account_code = payment_account_code;
	}
	public String getGoods_buy_payment_day() {
		return goods_buy_payment_day;
	}
	public void setGoods_buy_payment_day(String goods_buy_payment_day) {
		this.goods_buy_payment_day = goods_buy_payment_day;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GoodsBuyingPayment [goods_buy_payment_code=");
		builder.append(goods_buy_payment_code);
		builder.append(", business_code=");
		builder.append(business_code);
		builder.append(", business_name=");
		builder.append(business_name);
		builder.append(", buy_total=");
		builder.append(buy_total);
		builder.append(", payment=");
		builder.append(payment);
		builder.append(", accounts_payable=");
		builder.append(accounts_payable);
		builder.append(", payment_account_type=");
		builder.append(payment_account_type);
		builder.append(", payment_bank=");
		builder.append(payment_bank);
		builder.append(", payment_account_code=");
		builder.append(payment_account_code);
		builder.append(", goods_buy_payment_day=");
		builder.append(goods_buy_payment_day);
		builder.append("]");
		return builder.toString();
	}
	
	

}
