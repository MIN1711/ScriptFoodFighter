package mypage.service;

import java.util.List;
import java.util.Map;

import mypage.vo.MyRecomVO;
import mypage.vo.MypageVO;
import orders.vo.OrdersVO;
import wish.vo.WishVO;

public interface IMypageService {

	public List<MypageVO> myWriteList(Map<String, Object> map);

	public int countList(MypageVO mv);
	
	public int countList(OrdersVO ov);

	public int countList(WishVO wv);
	
	public String selectByPw(String cusPw);
	
	public List<OrdersVO> myOrderList(Map<String, Object> map);
	
	public List<WishVO> myWishList(Map<String, Object> map);
	
	public int countList(MyRecomVO rv);
	
	public List<MyRecomVO> myRecomList(Map<String, Object> map);
	
}
