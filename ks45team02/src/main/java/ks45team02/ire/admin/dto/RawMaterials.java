package ks45team02.ire.admin.dto;

public class RawMaterials {

	private String user_id;
	private int raw_materials_incoming_date;
	private int raw_materials_outcoming_date;
	private int raw_materials_num;
	private String goods_co2_code;
	private int raw_materials_amount;
	@Override
	public String toString() {
		return "RawMaterials [user_id=" + user_id + ", raw_materials_incoming_date=" + raw_materials_incoming_date
				+ ", raw_materials_outcoming_date=" + raw_materials_outcoming_date + ", raw_materials_num="
				+ raw_materials_num + ", goods_co2_code=" + goods_co2_code + ", raw_materials_amount="
				+ raw_materials_amount + "]";
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getRaw_materials_incoming_date() {
		return raw_materials_incoming_date;
	}
	public void setRaw_materials_incoming_date(int raw_materials_incoming_date) {
		this.raw_materials_incoming_date = raw_materials_incoming_date;
	}
	public int getRaw_materials_outcoming_date() {
		return raw_materials_outcoming_date;
	}
	public void setRaw_materials_outcoming_date(int raw_materials_outcoming_date) {
		this.raw_materials_outcoming_date = raw_materials_outcoming_date;
	}
	public int getRaw_materials_num() {
		return raw_materials_num;
	}
	public void setRaw_materials_num(int raw_materials_num) {
		this.raw_materials_num = raw_materials_num;
	}
	public String getGoods_co2_code() {
		return goods_co2_code;
	}
	public void setGoods_co2_code(String goods_co2_code) {
		this.goods_co2_code = goods_co2_code;
	}
	public int getRaw_materials_amount() {
		return raw_materials_amount;
	}
	public void setRaw_materials_amount(int raw_materials_amount) {
		this.raw_materials_amount = raw_materials_amount;
	}
}
