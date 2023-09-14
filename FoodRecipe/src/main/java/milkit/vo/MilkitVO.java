package milkit.vo;

public class MilkitVO {

	private int rNo;
	private int mStor;
	private int mPrice;
	
	public MilkitVO() {
		
	}
	
	public MilkitVO(int rNo, int mStor, int mPrice) {
		super();
		this.rNo = rNo;
		this.mStor = mStor;
		this.mPrice = mPrice;
	}

	public int getrNo() {
		return rNo;
	}

	public void setrNo(int rNo) {
		this.rNo = rNo;
	}

	public int getmStor() {
		return mStor;
	}

	public void setmStor(int mStor) {
		this.mStor = mStor;
	}

	public int getmPrice() {
		return mPrice;
	}

	public void setmPrice(int mPrice) {
		this.mPrice = mPrice;
	}

	@Override
	public String toString() {
		return "MilkitVO [rNo=" + rNo + ", mStor=" + mStor + ", mPrice=" + mPrice + "]";
	}
	
}
