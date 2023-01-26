package ks45team02.ire.admin.dto;

public class Vat {

	private String vat_calculation_quarter;
	private String sales_buying_monthgroup;
	private int final_payment_amount;
	private int buy_total;
	private int vat_calculation;
	private int pay_vat;
	public String getVat_calculation_quarter() {
		return vat_calculation_quarter;
	}
	public void setVat_calculation_quarter(String vat_calculation_quarter) {
		this.vat_calculation_quarter = vat_calculation_quarter;
	}
	public String getSales_buying_monthgroup() {
		return sales_buying_monthgroup;
	}
	public void setSales_buying_monthgroup(String sales_buying_monthgroup) {
		this.sales_buying_monthgroup = sales_buying_monthgroup;
	}
	public int getFinal_payment_amount() {
		return final_payment_amount;
	}
	public void setFinal_payment_amount(int final_payment_amount) {
		this.final_payment_amount = final_payment_amount;
	}
	public int getBuy_total() {
		return buy_total;
	}
	public void setBuy_total(int buy_total) {
		this.buy_total = buy_total;
	}
	public int getVat_calculation() {
		return vat_calculation;
	}
	public void setVat_calculation(int vat_calculation) {
		this.vat_calculation = vat_calculation;
	}
	public int getPay_vat() {
		return pay_vat;
	}
	public void setPay_vat(int pay_vat) {
		this.pay_vat = pay_vat;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vat [vat_calculation_quarter=");
		builder.append(vat_calculation_quarter);
		builder.append(", sales_buying_monthgroup=");
		builder.append(sales_buying_monthgroup);
		builder.append(", final_payment_amount=");
		builder.append(final_payment_amount);
		builder.append(", buy_total=");
		builder.append(buy_total);
		builder.append(", vat_calculation=");
		builder.append(vat_calculation);
		builder.append(", pay_vat=");
		builder.append(pay_vat);
		builder.append("]");
		return builder.toString();
	}
	
	
}
