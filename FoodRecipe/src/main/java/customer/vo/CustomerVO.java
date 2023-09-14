package customer.vo;

public class CustomerVO {
	
	private String cusId;
	private String cusName;
	private String cusTel;
	private String cusAddr;
	private String cusPw;
	private String cusImg;
	private String cusAct;
	
	public CustomerVO() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerVO(String cusId, String cusName, String cusTel, String cusAddr, String cusPw, String cusImg,
			String cusAct) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusTel = cusTel;
		this.cusAddr = cusAddr;
		this.cusPw = cusPw;
		this.cusImg = cusImg;
		this.cusAct = cusAct;
	}
	
	public CustomerVO(String cusId, String cusName, String cusTel, String cusAddr, String cusPw, String cusImg) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusTel = cusTel;
		this.cusAddr = cusAddr;
		this.cusPw = cusPw;
		this.cusImg = cusImg;
	}
	
	public CustomerVO(String cusId, String cusName, String cusTel, String cusAddr, String cusPw) {
		super();
		this.cusId = cusId;
		this.cusName = cusName;
		this.cusTel = cusTel;
		this.cusAddr = cusAddr;
		this.cusPw = cusPw;	
	}
	
	public String getcusId() {
		return cusId;
	}
	public void setcusId(String cusId) {
		this.cusId = cusId;
	}
	public String getcusName() {
		return cusName;
	}
	public void setcusName(String cusName) {
		this.cusName = cusName;
	}
	public String getcusTel() {
		return cusTel;
	}
	public void setcusTel(String cusTel) {
		this.cusTel = cusTel;
	}
	public String getcusAddr() {
		return cusAddr;
	}
	public void setcusAddr(String cusAddr) {
		this.cusAddr = cusAddr;
	}
	public String getcusPw() {
		return cusPw;
	}
	public void setcusPw(String cusPw) {
		this.cusPw = cusPw;
	}
	public String getcusImg() {
		return cusImg;
	}
	public void setcusImg(String cusImg) {
		this.cusImg = cusImg;
	}
	public String getcusAct() {
		return cusAct;
	}
	public void setcusAct(String cusAct) {
		this.cusAct = cusAct;
	}
	@Override
	public String toString() {
		return "CustomerVO [cusId=" + cusId + ", cusName=" + cusName + ", cusTel=" + cusTel + ", cusAddr=" + cusAddr
				+ ", cusPw=" + cusPw + ", cusImg=" + cusImg + ", cusAct=" + cusAct + "]";
	}
	
	
		
	
}
