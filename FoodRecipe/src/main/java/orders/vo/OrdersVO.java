package orders.vo;

import java.util.Date;

public class OrdersVO {

	public int oNo;
	public String cusId;
	public String oCode;
	public Date oDate;
	public int oMoney;

	public OrdersVO() {
	}

	public OrdersVO(int oNo, String cusId, String oCode, Date oDate, int oMoney) {
		super();
		this.oNo = oNo;
		this.cusId = cusId;
		this.oCode = oCode;
		this.oDate = oDate;
		this.oMoney = oMoney;
	}
	
	public OrdersVO(String cusId, String oCode, int oMoney) {
		super();
		this.cusId = cusId;
		this.oCode = oCode;
		this.oMoney = oMoney;
	}
	
	public OrdersVO(int oNo, String cusId, String oCode, int oMoney) {
		super();
		this.oNo = oNo;
		this.cusId = cusId;
		this.oCode = oCode;
		this.oMoney = oMoney;
	}
	
	public OrdersVO(int oNo, int oMoney) {
		super();
		this.oNo = oNo;
		this.oMoney = oMoney;
	}
	
	public OrdersVO(int oNo) {
		super();
		this.oNo = oNo;
	}


	public int getoNo() {
		return oNo;
	}

	public void setoNo(int oNo) {
		this.oNo = oNo;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getoCode() {
		return oCode;
	}

	public void setoCode(String oCode) {
		this.oCode = oCode;
	}

	public Date getoDate() {
		return oDate;
	}

	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}

	public int getoMoney() {
		return oMoney;
	}

	public void setoMoney(int oMoney) {
		this.oMoney = oMoney;
	}

	@Override
	public String toString() {
		return "OrdersVO [oNo=" + oNo + ", cusId=" + cusId + ", oCode=" + oCode + ", oDate=" + oDate + ", oMoney="
				+ oMoney + "]";
	}

}
