package recipe.vo;

public class RecipeVO {

	private int rNo;
	private String rMenu;
	private String rType;
	private double rCal;
	private String rImgS;
	private String rImgL;
	private String rDt;
	private String rM1;
	private String rMm1;
	private String rM2;
	private String rMm2;
	private String rM3;
	private String rMm3;
	private String rM4;
	private String rMm4;
	private String rM5;
	private String rMm5;
	private String rM6;
	private String rMm6;
	private String rTip;
	
	public RecipeVO() {

	}

	public RecipeVO(int rNo, String rMenu, String rType, double rCal, String rImgS, String rImgL, String rDt,
			String rM1, String rMm1, String rM2, String rMm2, String rM3, String rMm3, String rM4, String rMm4,
			String rM5, String rMm5, String rM6, String rMm6, String rTip) {
		super();
		this.rNo = rNo;
		this.rMenu = rMenu;
		this.rType = rType;
		this.rCal = rCal;
		this.rImgS = rImgS;
		this.rImgL = rImgL;
		this.rDt = rDt;
		this.rM1 = rM1;
		this.rMm1 = rMm1;
		this.rM2 = rM2;
		this.rMm2 = rMm2;
		this.rM3 = rM3;
		this.rMm3 = rMm3;
		this.rM4 = rM4;
		this.rMm4 = rMm4;
		this.rM5 = rM5;
		this.rMm5 = rMm5;
		this.rM6 = rM6;
		this.rMm6 = rMm6;
		this.rTip = rTip;
	}
	
	public RecipeVO(int rNo, String rMenu, String rType, String rImgS) {
		super();
		this.rNo = rNo;
		this.rMenu = rMenu;
		this.rType = rType;
		this.rImgS = rImgS;
	}
	
	public int getrNo() {
		return rNo;
	}
	public void setrNo(int rNo) {
		this.rNo = rNo;
	}
	public String getrMenu() {
		return rMenu;
	}
	public void setrMenu(String rMenu) {
		this.rMenu = rMenu;
	}
	public String getrType() {
		return rType;
	}
	public void setrType(String rType) {
		this.rType = rType;
	}
	public double getrCal() {
		return rCal;
	}
	public void setrCal(double rCal) {
		this.rCal = rCal;
	}
	public String getrImgS() {
		return rImgS;
	}
	public void setrImgS(String rImgS) {
		this.rImgS = rImgS;
	}
	public String getrImgL() {
		return rImgL;
	}
	public void setrImgL(String rImgL) {
		this.rImgL = rImgL;
	}
	public String getrDt() {
		return rDt;
	}
	public void setrDt(String rDt) {
		this.rDt = rDt;
	}
	public String getrM1() {
		return rM1;
	}
	public void setrM1(String rM1) {
		this.rM1 = rM1;
	}
	public String getrMm1() {
		return rMm1;
	}
	public void setrMm1(String rMm1) {
		this.rMm1 = rMm1;
	}
	public String getrM2() {
		return rM2;
	}
	public void setrM2(String rM2) {
		this.rM2 = rM2;
	}
	public String getrMm2() {
		return rMm2;
	}
	public void setrMm2(String rMm2) {
		this.rMm2 = rMm2;
	}
	public String getrM3() {
		return rM3;
	}
	public void setrM3(String rM3) {
		this.rM3 = rM3;
	}
	public String getrMm3() {
		return rMm3;
	}
	public void setrMm3(String rMm3) {
		this.rMm3 = rMm3;
	}
	public String getrM4() {
		return rM4;
	}
	public void setrM4(String rM4) {
		this.rM4 = rM4;
	}
	public String getrMm4() {
		return rMm4;
	}
	public void setrMm4(String rMm4) {
		this.rMm4 = rMm4;
	}
	public String getrM5() {
		return rM5;
	}
	public void setrM5(String rM5) {
		this.rM5 = rM5;
	}
	public String getrMm5() {
		return rMm5;
	}
	public void setrMm5(String rMm5) {
		this.rMm5 = rMm5;
	}
	public String getrM6() {
		return rM6;
	}
	public void setrM6(String rM6) {
		this.rM6 = rM6;
	}
	public String getrMm6() {
		return rMm6;
	}
	public void setrMm6(String rMm6) {
		this.rMm6 = rMm6;
	}
	public String getrTip() {
		return rTip;
	}
	public void setrTip(String rTip) {
		this.rTip = rTip;
	}
	
}
