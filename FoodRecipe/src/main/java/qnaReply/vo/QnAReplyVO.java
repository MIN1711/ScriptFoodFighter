package qnaReply.vo;

import java.util.Date;

public class QnAReplyVO {

	private int qRNo;
	private String qRCon;
	private Date qRDate;
	private String manCod;
	private int qNo;

	public QnAReplyVO() {
	}

	public QnAReplyVO(int qRNo, String qRCon, Date qRDate, String manCod, int qNo) {
		super();
		this.qRNo = qRNo;
		this.qRCon = qRCon;
		this.qRDate = qRDate;
		this.manCod = manCod;
		this.qNo = qNo;
	}

	public int getqRNo() {
		return qRNo;
	}

	public void setqRNo(int qRNo) {
		this.qRNo = qRNo;
	}

	public String getqRCon() {
		return qRCon;
	}

	public void setqRCon(String qRCon) {
		this.qRCon = qRCon;
	}

	public Date getqRDate() {
		return qRDate;
	}

	public void setqRDate(Date qRDate) {
		this.qRDate = qRDate;
	}

	public String getManCod() {
		return manCod;
	}

	public void setManCod(String manCod) {
		this.manCod = manCod;
	}

	public int getqNo() {
		return qNo;
	}

	public void setqNo(int qNo) {
		this.qNo = qNo;
	}

}
