package orders.dao;

import java.util.List;
import java.util.Map;

import orders.vo.CartVO;
import orders.vo.OrdersVO;

public interface IOrdersDao {

	public int insertOrders(OrdersVO ov);
	
	public int deleteOrders(int oNo);
	
	public List<OrdersVO> getAllOrders();
	
	public List<OrdersVO> getOrders(Map<String, Object> map);
	
	public boolean checkOrderNum(int oNo);
	
	public int ordersChk(String cusId);
	
	public int cusOno(String cusId);
	
	public int getMoney(int oNo);
	
	public int updateMoney(OrdersVO ov);

	public List<CartVO> getCartList(int oNo);

	public int cancelOrder(int oNo);

	public OrdersVO payOrders(int oNo);

	public int orderPaid(int oNo);
}
