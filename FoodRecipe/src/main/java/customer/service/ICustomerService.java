package customer.service;

import java.util.List;
import java.util.Map;

import customer.vo.CustomerVO;

public interface ICustomerService {

	//로그인(id검증) 메소드
		//접근제한자 반환타입 메소드명(인자)
	public  CustomerVO loginChk(CustomerVO cv);
	
	public int registCustomer(CustomerVO cv);
	
	public int modifyCustomer(CustomerVO cv);
	
	public boolean checkCustomer(String cusId);
	
	public int removeCustomer(String cusId);
	
	
	/**
	 * 주어진 회원정보가 존재하는지 확인하기 위한 메서드
	 * @param memId 회원정보 존재여부 확인하기 위한 회원ID 
	 * @return 해당 회원정보를 담은 VO객체.  
	 */
	
	public CustomerVO getCustomer(String cusId);
	
	
	/**
	 * DB에 존재하는 모든 회원정보를 조회하기 위한 메서드
	 * @return 모든 회원정보를 담고 있는 리스트 객체 
	 */
	public List<CustomerVO> displayAllCustomer();
	
	/**
	 * 검색정보를 이용하여 회원정보를검색하기 위한 메서드 
	 * @param mv 검색하고자 하는 회원정보를 담은 VO객체 
	 * @return 검색된 회언정보를 담은 리스트 객체 
	 */
	public List<CustomerVO> searchCustomer(CustomerVO cv);
	
	public String selectById(String cusId);

	//public CustomerVO findId(String cusTel);

	public String findPw(Map<String, Object> map);

	public String findId(Map<String, Object> map);

}

