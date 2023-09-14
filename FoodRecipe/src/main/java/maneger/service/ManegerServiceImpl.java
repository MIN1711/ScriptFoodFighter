package maneger.service;

import java.util.List;

import customer.vo.CustomerVO;
import maneger.dao.IManegerDao;
import maneger.dao.ManegerImpl;
import orders.vo.OrdersVO;

public class ManegerServiceImpl implements IManegerService{
	
	private IManegerDao manDao;
	
	private static IManegerService manService;
	
	private ManegerServiceImpl() {
		manDao = ManegerImpl.getInstance();
	}
	
	public static IManegerService getInstance() {
		if(manService == null) {
			manService = new ManegerServiceImpl();
		}
		return manService;
	}
	

	@Override
	public List<CustomerVO> displayCustomer() {
		return manDao.AllCustomer();
	}

	@Override
	public List<OrdersVO> displayOrders() {
		return manDao.AllOrders();
	}

	@Override
	public List<OrdersVO> searchMoney(OrdersVO ov) {
		return manDao.searchMoney(ov);
	}
	
	

}
