package customer.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import customer.dao.CustomerDaoImpl;
import customer.dao.ICustomerDao;
import customer.vo.CustomerVO;

public class CustomerServiceImpl implements ICustomerService {

private ICustomerDao cusDao;
	
	private static ICustomerService cusService;
	
	private CustomerServiceImpl() {
		cusDao = CustomerDaoImpl.getInstance();
	}
	public static ICustomerService getInstance() {
		
		if(cusService == null) {
			cusService = new CustomerServiceImpl();
		}
		return cusService;
	}

	@Override
	public int registCustomer(CustomerVO cv) {
		int cnt =cusDao.insertCustomer(cv);
		return cnt;
	}

	@Override
	public int modifyCustomer(CustomerVO cv) {
		return cusDao.updateCustomer(cv);
	}

	@Override
	public boolean checkCustomer(String cusId) {
		return cusDao.checkCustomer(cusId);
	}

	@Override
	public int removeCustomer(String cusId) {
		return cusDao.deleteCustomer(cusId);
	}

	@Override
	public CustomerVO getCustomer(String cusId) {
		return cusDao.getCustomer(cusId);
	}

	@Override
	public List<CustomerVO> displayAllCustomer() {
		return cusDao.getAllCustomer();
	}

	@Override
	public List<CustomerVO> searchCustomer(CustomerVO cv) {
		return cusDao.searchCustomer(cv);
	}
	
	@Override
	public CustomerVO loginChk(CustomerVO cv) {
		
		return cusDao.loginChk(cv);
		
	}
//		//dao에게 함수를 호출하여 결과를 요청
//		int loginChk;
//		try {
//			loginChk = cusDao.loginChk(cv);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return loginChk;
//	}
	@Override
	public String selectById(String cusId) {
		
		return cusDao.selectById(cusId);
	}
	/*
	 * @Override public String findid(String cusId) { return cusDao.findid(cusId); }
	 */
	
	@Override
	public String findId(Map<String, Object> map) {
		String findId="";
		try {
			findId=cusDao.findId(map);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return findId;
	}
	@Override
	public String findPw(Map<String, Object> map){
		String findPw="";
		try {
			findPw=cusDao.findPw(map);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return findPw;
	}

}
