package orders.dao;

import java.util.List;
import java.util.Map;

import comm.dao.MyBatisDao;
import orders.vo.CartVO;
import orders.vo.OrdersVO;

public class OrdersDaoImpl extends MyBatisDao implements IOrdersDao {

	private static IOrdersDao orDao;

	public OrdersDaoImpl() {

	}

	public static IOrdersDao getInstance() {
		if (orDao == null) {
			orDao = new OrdersDaoImpl();
		}
		return orDao;
	}

	@Override
	public int insertOrders(OrdersVO ov) {
		int cnt = insert("orders.insertOrder", ov);
		return cnt;
	}

	@Override
	public int deleteOrders(int oNo) {
		int cnt = delete("orders.deleteOrders", oNo);
		return cnt;
	}

	@Override
	public List<OrdersVO> getAllOrders() {
		List<OrdersVO> orList = selectList("orders.AllOrders");
		return orList;
	}

	@Override
	public List<OrdersVO> getOrders(Map<String, Object> map) {
		List<OrdersVO> orderList = null;
		orderList = orDao.getOrders(map);
		return orderList;
	}

	@Override
	public boolean checkOrderNum(int oNo) {
		int cnt = selectOne("orders.check", oNo);

		boolean isExist = false;

		if (cnt > 0) {
			isExist = true;
		}
		return isExist;
	}

	public int ordersChk(String cusId) {
		int cnt = 0;
		try {
			cnt = selectOne("orders.ordersChk", cusId);
		} catch (Exception e) {
			System.out.println("에러");
		}
		return cnt;
	}

	@Override
	public int cusOno(String cusId) {
		int cnt = 0;
		try {
			cnt = selectOne("orders.ordersNo", cusId);
		} catch (Exception e) {
			System.out.println("에러");
		}
		return cnt;
	}

	@Override
	public int getMoney(int oNo) {
		int cnt = selectOne("orders.getmoney", oNo);
		return cnt;
	}

	@Override
	public int updateMoney(OrdersVO ov) {
		int cnt = update("orders.updatemoney", ov);
		return cnt;
	}

	@Override
	public List<CartVO> getCartList(int oNo) {
		List<CartVO> cartList = selectList("orders.getcartlist", oNo);
		return cartList;
	}

	@Override
	public int cancelOrder(int oNo) {
		return update("orders.cancel", oNo);
	}

	@Override
	public OrdersVO payOrders(int oNo) {
		return selectOne("orders.payorders", oNo);
	}

	@Override
	public int orderPaid(int oNo) {
		return update("orders.orderpaid", oNo);
	}

}
