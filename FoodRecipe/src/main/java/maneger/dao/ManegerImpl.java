package maneger.dao;

import java.util.List;

import comm.dao.MyBatisDao;
import customer.vo.CustomerVO;
import orders.vo.OrdersVO;

public class ManegerImpl extends MyBatisDao implements IManegerDao {
	
	private static IManegerDao manDao;
	
	public ManegerImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static IManegerDao getInstance() {
		if(manDao == null) {
			manDao = new ManegerImpl();
		}
		return manDao;
	}

	@Override
	public List<CustomerVO> AllCustomer() {
		List<CustomerVO> custList = selectList("maneger.customerAll");
		return custList;
	}

	@Override
	public List<OrdersVO> AllOrders() {
		List<OrdersVO> ordeList = selectList("maneger.ordersAll");
		return ordeList;
	}

	@Override
	public List<OrdersVO> searchMoney(OrdersVO ov) {
		List<OrdersVO> ordeList = selectList("maneger.moneyAll", ov);
		return ordeList;
	}

}
