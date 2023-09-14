package recipeReply.vo;

import java.util.Date;

public class RecipeReplyVO {

	private int rRNo;
	private String rRCon;
	private Date rRDate;
	private String cusId;
	private int rNo;
	
	public RecipeReplyVO() {

	}

	public RecipeReplyVO(int rRNo, String rRCon, Date rRDate, String cusId, int rNo) {
		super();
		this.rRNo = rRNo;
		this.rRCon = rRCon;
		this.rRDate = rRDate;
		this.cusId = cusId;
		this.rNo = rNo;
	}

	public int getrRNo() {
		return rRNo;
	}

	public void setrRNo(int rRNo) {
		this.rRNo = rRNo;
	}

	public String getrRCon() {
		return rRCon;
	}

	public void setrRCon(String rRCon) {
		this.rRCon = rRCon;
	}

	public Date getrRDate() {
		return rRDate;
	}

	public void setrRDate(Date rRDate) {
		this.rRDate = rRDate;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	
}
