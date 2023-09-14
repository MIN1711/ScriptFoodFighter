package mypage.vo;

public class MyRecomVO {
	private String cusId;
	private  int ctgNo;
	private int bNo;
	private String bTitle;
	private String bCon;
	private String bDate;
	
	public MyRecomVO() {
		
	}
	
	public MyRecomVO(String cusId, int ctgNo, int bNo, String bTitle, String bCon, String bDate) {
		super();
		this.cusId = cusId;
		this.ctgNo = ctgNo;
		this.bNo = bNo;
		this.bTitle = bTitle;
		this.bCon = bCon;
		this.bDate = bDate;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public int getCtgNo() {
		return ctgNo;
	}

	public void setCtgNo(int ctgNo) {
		this.ctgNo = ctgNo;
	}

	public int getbNo() {
		return bNo;
	}

	public void setbNo(int bNo) {
		this.bNo = bNo;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbCon() {
		return bCon;
	}

	public void setbCon(String bCon) {
		this.bCon = bCon;
	}

	public String getbDate() {
		return bDate;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	@Override
	public String toString() {
		return "MyRecomVO [cusId=" + cusId + ", ctgNo=" + ctgNo + ",  bNo=" + bNo + ", bTitle="
				+ bTitle + ", bCon=" + bCon + ", bDate=" + bDate + "]";
	}
}
