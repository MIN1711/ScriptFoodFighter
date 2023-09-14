package customer.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import customer.vo.CustomerVO;

public interface ICustomerDao {

	
	
	public int insertCustomer(CustomerVO cv);
	
	public int updateCustomer(CustomerVO cv);
	
	public int deleteCustomer(String cusId);
	
	public boolean checkCustomer(String cusId);
	
	public CustomerVO getCustomer(String cusId);
	
	public List<CustomerVO> getAllCustomer();
	

	public List<CustomerVO> searchCustomer(CustomerVO cv);

	//로그인(id검증) 메소드
	public CustomerVO loginChk(CustomerVO cv); 
	
	public String selectById(String cusId);
	
	//아이디 찾기
	public String findId(Map<String, Object>map) throws SQLException;
	
	//비밀번호 찾기
	public String findPw(Map<String, Object>map) throws SQLException;

	//public CustomerVO findPw(String cusId, String cusTel);
	
	
	
}
