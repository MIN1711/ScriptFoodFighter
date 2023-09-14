package mypage.service;

import java.util.List;
import java.util.Map;

import board.vo.BoardVO;

import mypage.dao.IMypageDao;
import mypage.dao.MypageDaoImpl;
import mypage.vo.MyRecomVO;
import mypage.vo.MypageVO;
import orders.vo.OrdersVO;
import wish.vo.WishVO;

public class MypageServiceImpl implements IMypageService {

	
	private IMypageDao mypageDao;
	
	private static IMypageService mypageService;
	
	private MypageServiceImpl() {
		mypageDao = MypageDaoImpl.getInstance();
	}
	public static IMypageService getInstance() {
		
		if(mypageService == null) {
			mypageService = new MypageServiceImpl();
		}
		return mypageService;
	}
	
	@Override
	public List<MypageVO> myWriteList(Map<String, Object> map) {
		
		List<MypageVO> mywriteList = null;
		
		mywriteList = mypageDao.MyWriteList(map);
		return mywriteList;
	}
	
	@Override
	public int countList(MypageVO mv) {
		int countList = 0;
		countList = mypageDao.countList(mv);
		return countList;
	}
	
	@Override
	public String selectByPw(String cusPw) {
		
		return mypageDao.selectByPw(cusPw);
	}
	@Override
	public List<OrdersVO> myOrderList(Map<String, Object> map) {
		
		List<OrdersVO> myOrderList = null;
		myOrderList = mypageDao.myOrdersList(map);
		return myOrderList;
	}
	@Override
	public int countList(OrdersVO ov) {
		int countList = 0;
		countList = mypageDao.countList(ov);
		return countList;
	}
	@Override
	public int countList(WishVO wv) {
		int countList = 0;
		countList = mypageDao.countList(wv);
		return countList;
	}
	@Override
	public List<WishVO> myWishList(Map<String, Object> map) {
		List<WishVO> myWishList = null;
		myWishList = mypageDao.myWishList(map);
		return myWishList;
	}
	@Override
	public int countList(MyRecomVO rv) {
		int countList = 0;
		countList = mypageDao.countList(rv);
		return countList;
	}
	@Override
	public List<MyRecomVO> myRecomList(Map<String, Object> map) {
		List<MyRecomVO> myRecomList = null;
		myRecomList = mypageDao.myRecomList(map);
		return myRecomList;
	}
	
	

}
