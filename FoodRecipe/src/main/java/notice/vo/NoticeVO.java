package notice.vo;

public class NoticeVO {

	private String nNo;
	private String nCon;
	private String nDate;
	private String manCod;

	public NoticeVO() {
	}

	public NoticeVO(String nNo, String nCon, String nDate, String manCod) {
		super();
		this.nNo = nNo;
		this.nCon = nCon;
		this.nDate = nDate;
		this.manCod = manCod;
	}

	public String getnNo() {
		return nNo;
	}

	public void setnNo(String nNo) {
		this.nNo = nNo;
	}

	public String getnCon() {
		return nCon;
	}

	public void setnCon(String nCon) {
		this.nCon = nCon;
	}

	public String getnDate() {
		return nDate;
	}

	public void setnDate(String nDate) {
		this.nDate = nDate;
	}

	public String getManCod() {
		return manCod;
	}

	public void setManCod(String manCod) {
		this.manCod = manCod;
	}

}
