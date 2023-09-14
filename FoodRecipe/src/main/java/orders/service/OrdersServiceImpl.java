package orders.service;

import java.util.List;
import java.util.Map;

import orders.dao.IOrdersDao;
import orders.dao.OrdersDaoImpl;
import orders.vo.CartVO;
import orders.vo.OrdersVO;

public class OrdersServiceImpl implements IOrdersService {

	private IOrdersDao orDao;

	private static IOrdersService orService;

	private OrdersServiceImpl() {
		orDao = OrdersDaoImpl.getInstance();
	}

	public static IOrdersService getInstance() {
		if(orService == null) {
			orService = new OrdersServiceImpl();
		}
		return orService;
	}

	@Override
	public int registOrders(OrdersVO ov) {
		int cnt = orDao.insertOrders(ov);
		return cnt;
	}

	@Override
	public int removeOrders(int oNo) {
		return orDao.deleteOrders(oNo);
	}

	@Override
	public List<OrdersVO> displayAllOrders() {
		return orDao.getAllOrders();
	}

	@Override
	public List<OrdersVO> ordersList(Map<String, Object> map) {
		List<OrdersVO> orderList = null;
		
		orderList = orDao.getOrders(map);
		
		return orderList;
	}

	@Override
	public boolean checkOrdersNum(int oNo) {
		return orDao.checkOrderNum(oNo);
	}

	@Override
	public int ordersChk(String cusId) {
		return orDao.ordersChk(cusId);
	}

	@Override
	public int getOno(String cusId) {
		return orDao.cusOno(cusId);
	}

	@Override
	public int getMoney(int oNo) {
		return orDao.getMoney(oNo);
	}

	@Override
	public int updateMoney(OrdersVO ov) {
		return orDao.updateMoney(ov);
	}

	@Override
	public List<CartVO> getCartList(int oNo) {
		return orDao.getCartList(oNo);
	}

	@Override
	public int cancelOrder(int oNo) {
		return orDao.cancelOrder(oNo);		
	}

	@Override
	public OrdersVO payOrders(int oNo) {
		return orDao.payOrders(oNo);		
	}

	@Override
	public int orderPaid(int oNo) {
		return orDao.orderPaid(oNo);		
	}
	
}
