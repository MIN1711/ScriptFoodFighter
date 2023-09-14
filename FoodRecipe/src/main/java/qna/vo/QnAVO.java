package qna.vo;

import java.util.Date;

public class QnAVO {

	private int qNo;
	private String qTitle;
	private String qCon;
	private String qDate;
	private String cusId;
	
	private int qRNo; // 댓글 번호 추가

	public QnAVO() {
	}
	
	public QnAVO(int qNo, String qTitle, String qCon, String qDate, String cusId, int qRNo) {
		super();
		this.qNo = qNo;
		this.qTitle = qTitle;
		this.qCon = qCon;
		this.qDate = qDate;
		this.cusId = cusId;
		this.qRNo = qRNo;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getqCon() {
		return qCon;
	}

	public void setqCon(String qCon) {
		this.qCon = qCon;
	}

	public String getqDate() {
		return qDate;
	}

	public void setqDate(String qDate) {
		this.qDate = qDate;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public int getqRNo() {
		return qRNo;
	}

	public void setqRNo(int qRNo) {
		this.qRNo = qRNo;
	}
	
}
