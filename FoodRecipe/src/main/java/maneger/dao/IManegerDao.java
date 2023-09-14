package maneger.dao;

import java.util.List;

import customer.vo.CustomerVO;
import orders.vo.OrdersVO;

public interface IManegerDao {

	
	/**
	 * 고객 전체 조회
	 * @return
	 */
	public List<CustomerVO> AllCustomer();
	
	/**
	 * 주문 내역 전체 조회
	 * @return
	 */
	public List<OrdersVO> AllOrders();
	
	/**
	 * 매출금액 조회
	 * @param ov
	 * @return
	 */
	public List<OrdersVO> searchMoney(OrdersVO ov);
	
}
