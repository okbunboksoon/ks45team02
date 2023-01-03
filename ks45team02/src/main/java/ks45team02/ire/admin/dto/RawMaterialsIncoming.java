package ks45team02.ire.admin.dto;

public class RawMaterialsIncoming {

	private String rawMaterialsCode;
	private String donationCode;
	private int rawMaterialsIncomingAmount;
	private String rawMaterialsIncomingDate;
	private String rawMaterialsStatus;
	private float carbonDioxideEmissionLevel;
	private String rawMaterialsDaygroup;
	private int donationPointSave;
	private String donationPointGroup;
	
	private Donation donation;

	public String getRawMaterialsCode() {
		return rawMaterialsCode;
	}

	public void setRawMaterialsCode(String rawMaterialsCode) {
		this.rawMaterialsCode = rawMaterialsCode;
	}

	public String getDonationCode() {
		return donationCode;
	}

	public void setDonationCode(String donationCode) {
		this.donationCode = donationCode;
	}

	public int getRawMaterialsIncomingAmount() {
		return rawMaterialsIncomingAmount;
	}

	public void setRawMaterialsIncomingAmount(int rawMaterialsIncomingAmount) {
		this.rawMaterialsIncomingAmount = rawMaterialsIncomingAmount;
	}

	public String getRawMaterialsIncomingDate() {
		return rawMaterialsIncomingDate;
	}

	public void setRawMaterialsIncomingDate(String rawMaterialsIncomingDate) {
		this.rawMaterialsIncomingDate = rawMaterialsIncomingDate;
	}

	public String getRawMaterialsStatus() {
		return rawMaterialsStatus;
	}

	public void setRawMaterialsStatus(String rawMaterialsStatus) {
		this.rawMaterialsStatus = rawMaterialsStatus;
	}

	public float getCarbonDioxideEmissionLevel() {
		return carbonDioxideEmissionLevel;
	}

	public void setCarbonDioxideEmissionLevel(float carbonDioxideEmissionLevel) {
		this.carbonDioxideEmissionLevel = carbonDioxideEmissionLevel;
	}

	public String getRawMaterialsDaygroup() {
		return rawMaterialsDaygroup;
	}

	public void setRawMaterialsDaygroup(String rawMaterialsDaygroup) {
		this.rawMaterialsDaygroup = rawMaterialsDaygroup;
	}

	public int getDonationPointSave() {
		return donationPointSave;
	}

	public void setDonationPointSave(int donationPointSave) {
		this.donationPointSave = donationPointSave;
	}

	public String getDonationPointGroup() {
		return donationPointGroup;
	}

	public void setDonationPointGroup(String donationPointGroup) {
		this.donationPointGroup = donationPointGroup;
	}

	public Donation getDonation() {
		return donation;
	}

	public void setDonation(Donation donation) {
		this.donation = donation;
	}

	@Override
	public String toString() {
		return "RawMaterialsIncoming [rawMaterialsCode=" + rawMaterialsCode + ", donationCode=" + donationCode
				+ ", rawMaterialsIncomingAmount=" + rawMaterialsIncomingAmount + ", rawMaterialsIncomingDate="
				+ rawMaterialsIncomingDate + ", rawMaterialsStatus=" + rawMaterialsStatus
				+ ", carbonDioxideEmissionLevel=" + carbonDioxideEmissionLevel + ", rawMaterialsDaygroup="
				+ rawMaterialsDaygroup + ", donationPointSave=" + donationPointSave + ", donationPointGroup="
				+ donationPointGroup + ", donation=" + donation + "]";
	}




	
	
}
