package mypage.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import board.vo.BoardVO;
import comm.dao.MyBatisDao;
import mypage.vo.MyRecomVO;
import mypage.vo.MypageVO;
import orders.vo.OrdersVO;
import util.MyBatisUtil;
import wish.vo.WishVO;

public class MypageDaoImpl extends MyBatisDao implements IMypageDao {

	private static IMypageDao mypageDao;
	
	public MypageDaoImpl() {
		
	}
	
	public static IMypageDao getInstance() {
	if(mypageDao == null) {
		mypageDao = new MypageDaoImpl();
	}
	return mypageDao;
	}
	
	@Override
	public List<MypageVO> MyWriteList(Map<String, Object> map) {
		
		//List<MypageVO> myList = selectList("mypage.getId", map);
		return selectList("mypage.getId", map);
	}

	@Override
	public int countList(MypageVO mv) {
		return selectOne("mypage.countList", mv);
		
	}
	

	@Override
	public String selectByPw(String cusPw) {
		String pw1 = null;
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			pw1 = session.selectOne("maneger.selectByPw", cusPw);
		}catch ( Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return pw1;
	}

	@Override
	public List<OrdersVO> myOrdersList(Map<String, Object> map) {
		
		return selectList("mypage.getOrders", map);
	}

	@Override
	public int countList(OrdersVO ov) {
		return selectOne("mypage.countList2", ov);
	}

	@Override
	public int countList(WishVO wv) {
		return selectOne("mypage.countList3", wv);
	}

	@Override
	public List<WishVO> myWishList(Map<String, Object> map) {

		return selectList("mypage.getWishList", map);
	}

	@Override
	public int countList(MyRecomVO rv) {
		return selectOne("mypage.countList1", rv);
	}

	@Override
	public List<MyRecomVO> myRecomList(Map<String, Object> map) {
		return selectList("mypage.getRecomList", map);
	}
	

}
