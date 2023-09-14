package customer.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.SqlSession;

import comm.dao.MyBatisDao;
import customer.vo.CustomerVO;
import util.MyBatisUtil;

public class CustomerDaoImpl extends MyBatisDao implements ICustomerDao{

	private static ICustomerDao cusDao;
	
	private CustomerDaoImpl() {
		
	}
	public static ICustomerDao getInstance() {
		if(cusDao == null) {
			cusDao = new CustomerDaoImpl();
		}
		return cusDao;
		
	}

	@Override
	public int insertCustomer(CustomerVO cv) {
		int cnt = insert("customer.insert", cv);
		return cnt;
	}

	@Override
	public int updateCustomer(CustomerVO cv) {
		int cnt = update("customer.update", cv);
		return cnt;
	}

	@Override
	public int deleteCustomer(String cusId) {
		int cnt = delete("customer.delete", cusId);
		return cnt;
	}

	@Override
	public boolean checkCustomer (String cusId) {
		
		int cnt = selectOne("customer.check", cusId);
		
		boolean isExist = false;
		
		if(cnt>0) {
			isExist = true;
		}
		return isExist;
	}

	@Override
	public CustomerVO getCustomer(String cusId) {
		CustomerVO cv = selectOne("customer.get", cusId);
		return cv;
	}

	@Override
	public List<CustomerVO> getAllCustomer() {
		List<CustomerVO> cusList = selectList("customer.getAll");
		
		return cusList;
	}

	@Override
	public List<CustomerVO> searchCustomer(CustomerVO cv) {
		List<CustomerVO> cusList = selectList("customer.search", cv);
		return cusList;
	}
	
	@Override
	public CustomerVO loginChk(CustomerVO cv) {
		// sql문에 접근하는 코드 작성
		
		CustomerVO cv2 = selectOne("customer.loginchk", cv);
		return cv2;
	}
	@Override
	public String selectById(String cusId) {
		String id1 = null;
		SqlSession session = MyBatisUtil.getInstance(true);
		
		try {
			id1= session.selectOne("customer.selectById", cusId);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.commit();
			session.close();
		}
		return id1;
	}
	
	@Override
	public String findId(Map<String, Object> map) throws SQLException {
		
		return selectOne("customer.findId", map);
	  }
	@Override
	public String findPw(Map<String, Object> map) throws SQLException {
		
		return selectOne("customer.findPw", map);
	}
	
	

}
