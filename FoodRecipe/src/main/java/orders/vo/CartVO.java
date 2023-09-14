package orders.vo;

public class CartVO {

	public int oNo;
	public int rNo;
	public int cartNo;
	public String rMenu;
	public int mPrice;

	public CartVO() {
	}

	public CartVO(int oNo, int rNo, int cartNo) {
		super();
		this.oNo = oNo;
		this.rNo = rNo;
		this.cartNo = cartNo;
	}
	
	public CartVO(int oNo, int rNo) {
		super();
		this.oNo = oNo;
		this.rNo = rNo;
	}

	public CartVO(int oNo) {
		super();
		this.oNo = oNo;
	}

	public CartVO(int oNo, int rNo, int cartNo, String rMenu, int mPrice) {
		super();
		this.oNo = oNo;
		this.rNo = rNo;
		this.cartNo = cartNo;
		this.rMenu = rMenu;
		this.mPrice = mPrice;
	}

	public int getoNo() {
		return oNo;
	}

	public void setoNo(int oNo) {
		this.oNo = oNo;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getCartNo() {
		return cartNo;
	}

	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}

	public String getrMenu() {
		return rMenu;
	}

	public void setrMenu(String rMenu) {
		this.rMenu = rMenu;
	}

	public int getmPrice() {
		return mPrice;
	}

	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}

	@Override
	public String toString() {
		return "CartVO [oNo=" + oNo + ", rNo=" + rNo + ", cartNo=" + cartNo + "]";
	}

}
