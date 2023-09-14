package orders.vo;

import java.util.Date;

public class PaymentVO {

	public int oNo;
	public Date payDate;
	public int payMoney;
	public int mPayCode;
	
	public PaymentVO() {
		
	}
	
	public PaymentVO(int oNo, Date payDate, int payMoney, int mPayCode) {
		super();
		this.oNo = oNo;
		this.payDate = payDate;
		this.payMoney = payMoney;
		this.mPayCode = mPayCode;
	}
	
	public PaymentVO(int oNo, int payMoney, int mPayCode) {
		super();
		this.oNo = oNo;
		this.payMoney = payMoney;
		this.mPayCode = mPayCode;
	}

	public int getoNo() {
		return oNo;
	}

	public void setoNo(int oNo) {
		this.oNo = oNo;
	}

	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	public int getPayMoney() {
		return payMoney;
	}

	public void setPayMoney(int payMoney) {
		this.payMoney = payMoney;
	}

	public int getmPayCode() {
		return mPayCode;
	}

	public void setmPayCode(int mPayCode) {
		this.mPayCode = mPayCode;
	}

	@Override
	public String toString() {
		return "PaymentVO [oNo=" + oNo + ", payDate=" + payDate + ", payMoney=" + payMoney + ", mPayCode=" + mPayCode
				+ "]";
	}

}
