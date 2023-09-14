package orders.service;

import java.util.List;

import orders.vo.CartVO;

public interface ICartService {

	public int registCart(CartVO cv);
	
	public int removeCart(CartVO cv);
	
	public int changeCart(CartVO cv);
	
	public List<CartVO> listCart(String cusId);

	public int getNo(CartVO cv);
	
	
	
	
}
