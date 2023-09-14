package orders.dao;

import java.util.List;

import orders.vo.CartVO;

public interface ICartDao {

	public int insertCart(CartVO cv);
	
	public int deleteCart(CartVO cv);
	
	public int updatecno(CartVO cv);
	
	public List<CartVO> getCart(String cusId);

	public int getNo(CartVO cv);
	
	
	
}
