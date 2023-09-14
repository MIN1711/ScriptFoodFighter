package mypage.dao;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;
import mypage.vo.MyRecomVO;
import mypage.vo.MypageVO;
import orders.vo.OrdersVO;
import wish.vo.WishVO;

public interface IMypageDao {
	
	//내가쓴글 조회
	public List<MypageVO> MyWriteList(Map<String, Object> map);
	// 페이지 
	public int countList(MypageVO mv);
	
	public int countList(OrdersVO ov);
	
	public int countList(WishVO wv);
	
	//회원정보 수정/탈퇴 비밀번호 확인
	public String selectByPw(String cusPw);
	
	public List<OrdersVO> myOrdersList(Map<String, Object> map);
	
	public List<WishVO> myWishList(Map<String, Object> map);
	
	public int countList(MyRecomVO rv);
	
	public List<MyRecomVO> myRecomList(Map<String, Object> map);
	
}
