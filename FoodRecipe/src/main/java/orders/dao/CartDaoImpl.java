package orders.dao;

import java.util.List;

import comm.dao.MyBatisDao;
import orders.vo.CartVO;

public class CartDaoImpl extends MyBatisDao implements ICartDao{
	
	private static ICartDao cartDao;
	
	public CartDaoImpl() {
		
	}
	
	public static ICartDao getInstance() {
		if(cartDao == null) {
			cartDao = new CartDaoImpl();
		}
		return cartDao;
	}

	@Override
	public int insertCart(CartVO cv) {
		int cnt = insert("cart.insert", cv);
		return cnt;
	}

	@Override
	public int deleteCart(CartVO cv) {
		int cnt = delete("cart.delete", cv);
		return cnt;
	}

	@Override
	public int updatecno(CartVO cv) {
		int cnt = update("cart.amount", cv);
		return cnt;
	}

	@Override
	public List<CartVO> getCart(String cusId) {
		List<CartVO> cartList = selectList("cart.getCart", cusId);
		return cartList;
	}

	@Override
	public int getNo(CartVO cv) {
		return selectOne("cart.getCartNo", cv);
	}

	
}
