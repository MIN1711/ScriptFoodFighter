package mypage.vo;

public class MypageVO {

	
	private String cusId;
	private int bNo;
	private String bTitle;
	private String bCon;
	private String bDate;
	private String ctgNo;
	
	public MypageVO() {
	}

	
	public MypageVO(String cusId, int bNo, String bTitle, String bCon, String bDate, String ctgNo) {
		super();
		this.cusId = cusId;
		this.bNo = bNo;
		this.bTitle = bTitle;
		this.bCon = bCon;
		this.bDate = bDate;
		this.ctgNo = ctgNo;
		
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

	public String getCtgNo() {
		return ctgNo;
	}

	public void setCtgNo(String ctgNo) {
		this.ctgNo = ctgNo;
	}



	@Override
	public String toString() {
		return "MypageVO [cusId=" + cusId + ", bNo=" + bNo + ", bTitle=" + bTitle + ", bCon=" + bCon + ", bDate="
				+ bDate + ", ctgNo=" + ctgNo + "]";
	}
	
}
