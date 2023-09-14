package orders.service;

import java.util.List;

import orders.dao.CartDaoImpl;
import orders.dao.ICartDao;
import orders.vo.CartVO;

public class CartServiceImpl implements ICartService {
	
	private ICartDao cartDao;
	
	private static ICartService cartService;
	
	private CartServiceImpl() {
		cartDao = CartDaoImpl.getInstance();
	}

	public static ICartService getInstance() {
		if (cartService == null) {
			cartService = new CartServiceImpl();
		}
		return cartService;
	}

	@Override
	public int registCart(CartVO cv) {
		int cnt = cartDao.insertCart(cv);
		return cnt;
	}

	@Override
	public int removeCart(CartVO cv) {
		return cartDao.deleteCart(cv);
	}

	@Override
	public int changeCart(CartVO cv) {
		return cartDao.updatecno(cv);
	}

	@Override
	public List<CartVO> listCart(String cusId) {
		return cartDao.getCart(cusId);
	}

	@Override
	public int getNo(CartVO cv) {
		return cartDao.getNo(cv);
	}
	
	
	
	
	
}
