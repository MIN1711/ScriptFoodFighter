package board.vo;

public class BoardVO {

	private int bNo;
	private String bTitle;
	private String bCon;
	private String bDate;
	private String cusId;
	private String ctgNo;
	
	private String bRno; // 댓글 번호 추가
	
	public BoardVO() {
		
	}

	public BoardVO(int bNo, String bTitle, String bCon, String bDate, String cusId, String ctgNo, String bRno) {
		super();
		this.bNo = bNo;
		this.bTitle = bTitle;
		this.bCon = bCon;
		this.bDate = bDate;
		this.cusId = cusId;
		this.ctgNo = ctgNo;
		this.bRno = bRno;
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

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getCtgNo() {
		return ctgNo;
	}

	public void setCtgNo(String ctgNo) {
		this.ctgNo = ctgNo;
	}

	public String getbRno() {
		return bRno;
	}

	public void setbRno(String bRno) {
		this.bRno = bRno;
	}

	

}
