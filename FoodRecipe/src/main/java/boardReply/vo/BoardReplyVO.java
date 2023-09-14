package boardReply.vo;

import java.util.Date;

public class BoardReplyVO {

	private int bRNo;
	private String bRCont;
	private Date bRDate;
	private String cusId;
	private int bNo;

	public BoardReplyVO() {
	}

	public BoardReplyVO(int bRNo, String bRCont, Date bRDate, String cusId, int bNo) {
		super();
		this.bRNo = bRNo;
		this.bRCont = bRCont;
		this.bRDate = bRDate;
		this.cusId = cusId;
		this.bNo = bNo;
	}

	public int getbRNo() {
		return bRNo;
	}

	public void setbRNo(int bRNo) {
		this.bRNo = bRNo;
	}

	public String getbRCont() {
		return bRCont;
	}

	public void setbRCont(String bRCont) {
		this.bRCont = bRCont;
	}

	public Date getbRDate() {
		return bRDate;
	}

	public void setbRDate(Date bRDate) {
		this.bRDate = bRDate;
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

}
