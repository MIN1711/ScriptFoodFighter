package wish.service;

import java.util.List;

import wish.dao.IWishDao;
import wish.dao.WishDaoImpl;
import wish.vo.WishVO;

public class WishServiceImpl implements IWishService {
	
	private IWishDao wDao;
	
	private static IWishService wService;
	
	public WishServiceImpl() {
		wDao = WishDaoImpl.getInstance();
	}

	public static IWishService getInstance() {
		if(wService == null) {
			wService = new WishServiceImpl();
		}
		return wService;
	}
	
	@Override
	public int insertWish(WishVO wv) {
		return wDao.insertWish(wv);
	}

	@Override
	public int deleteWish(WishVO wv) {
		return wDao.deleteWish(wv);
	}

	@Override
	public int checkWish(WishVO wv) {
		return wDao.checkWish(wv);
	}

	@Override
	public int countWish(WishVO wv) {
		return wDao.countWish(wv);

	}
	
}
