package wish.vo;

public class WishVO {

	private int rNo;
	private String cNo;
	private String cusId;
	private String rMenu;

	public WishVO() {
	}

	public WishVO(int rNo, String cNo, String cusId, String rMenu) {
		super();
		this.rNo = rNo;
		this.cNo = cNo;
		this.cusId = cusId;
		this.rMenu = rMenu;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getCusId() {
		return cusId;
	}

	public void setCusId(String cusId) {
		this.cusId = cusId;
	}

	public String getrMenu() {
		return rMenu;
	}

	public void setrMenu(String rMenu) {
		this.rMenu = rMenu;
	}

}
