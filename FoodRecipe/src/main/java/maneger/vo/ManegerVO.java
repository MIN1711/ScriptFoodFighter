package maneger.vo;

public class ManegerVO {
	private String menCod;
	private String menPw;
	
	public ManegerVO() {
	}
	
	public ManegerVO(String menCod, String menPw) {
		super();
		this.menCod = menCod;
		this.menPw = menPw;
	}

	public String getmenCod() {
		return menCod;
	}

	public void setmenCod(String menCod) {
		this.menCod = menCod;
	}

	public String getmenPw() {
		return menPw;
	}

	public void setmenPw(String menPw) {
		this.menPw = menPw;
	}

	@Override
	public String toString() {
		return "ManegerVO [menCod=" + menCod + ", menPw=" + menPw + "]";
	}
	
	
	
}
