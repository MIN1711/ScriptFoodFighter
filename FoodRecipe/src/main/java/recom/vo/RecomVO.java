package recom.vo;

public class RecomVO {

	private String cusId;
	private int bNo;
	private String cNo;

	public RecomVO() {
	}

	public RecomVO(String cusId, int bNo, String cNo) {
		super();
		this.cusId = cusId;
		this.bNo = bNo;
		this.cNo = cNo;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

}
