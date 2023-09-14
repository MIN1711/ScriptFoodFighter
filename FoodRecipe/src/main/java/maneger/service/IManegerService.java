package maneger.service;

import java.util.List;

import customer.vo.CustomerVO;
import orders.vo.OrdersVO;

public interface IManegerService {

	/**
	 * 고객 전체 조회하기 위한 메서드
	 * @return
	 */
	public List<CustomerVO> displayCustomer();
	
	/**
	 * 구매 내역 전체조회하기 위한 메서드
	 * @return
	 */
	public List<OrdersVO> displayOrders();
	
	/**
	 * 매출금액 조회하기 위한 메서드
	 * @param ov
	 * @return
	 */
	public List<OrdersVO> searchMoney(OrdersVO ov);
}
