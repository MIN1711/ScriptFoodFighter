package wish.dao;

import comm.dao.MyBatisDao;
import wish.vo.WishVO;

public class WishDaoImpl extends MyBatisDao implements IWishDao {
	
	private static IWishDao wDao;
	
	public WishDaoImpl() {

	}

	public static IWishDao getInstance() {
		if(wDao == null) {
			wDao = new WishDaoImpl();
		}
		return wDao;
	}
	
	@Override
	public int insertWish(WishVO wv) {
		return insert("wish.insert", wv);
	}

	@Override
	public int deleteWish(WishVO wv) {
		return delete("wish.delete", wv);
	}

	@Override
	public int checkWish(WishVO wv) {
		return selectOne("wish.check", wv);
	}

	@Override
	public int countWish(WishVO wv) {
		return selectOne("wish.count", wv);

	}
	
}
