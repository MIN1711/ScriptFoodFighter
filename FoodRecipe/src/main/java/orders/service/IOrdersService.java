package orders.service;

import java.util.List;
import java.util.Map;

import orders.vo.CartVO;
import orders.vo.OrdersVO;

public interface IOrdersService {
	
	public int registOrders(OrdersVO ov);
	
	public int removeOrders(int oNo);
	
	public List<OrdersVO> displayAllOrders();
	
	public List<OrdersVO> ordersList(Map<String, Object> map);
	
	public boolean checkOrdersNum(int oNo);
	
	public int ordersChk(String cusId);
	
	public int getOno(String cusId);
	
	public int getMoney(int oNo);
	
	public int updateMoney(OrdersVO ov);

	// ID, 결제여부로 장바구니 리스트
	public List<CartVO> getCartList(int ordersNum);

	public int cancelOrder(int oNo);

	public OrdersVO payOrders(int oNo);

	public int orderPaid(int oNo);

}
