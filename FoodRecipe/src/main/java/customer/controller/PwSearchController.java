package customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.service.CustomerServiceImpl;
import customer.service.ICustomerService;
import customer.vo.CustomerVO;

@WebServlet("/customer/pwSearch.do")
public class PwSearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/customer/pwSearch.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cusId = req.getParameter("cusId");
		String cusName = req.getParameter("cusName");
		String cusTel = req.getParameter("cusTel");
		String cusAddr = req.getParameter("cusAddr");
		String cusPw = req.getParameter("cusPw");
		String cusImg = req.getParameter("cusImg");
		String cusAct = req.getParameter("cusAct");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cusId", cusId);
		map.put("cusTel", cusTel);
		
		ICustomerService cusServ = CustomerServiceImpl.getInstance();
		
		CustomerVO cv = new CustomerVO(cusId, cusName, cusTel, cusAddr, cusPw, cusImg, cusAct);
			
		String pwSearch = cusServ.findPw(map);
			
			PrintWriter out = resp.getWriter();
			if(pwSearch != null) {
				System.out.println("해당 회원 존재");
				out.println("{\"code\": \"OK\", \"data\": \"" + pwSearch + "\"}");
				MessageTemplate mt = new MessageTemplate();
				mt.setPhoneNumber(cusTel);
				mt.sendOne(pwSearch);
			} else {
				System.out.println("해당 회원은 존재하지 않습니다.");
				out.println("{\"code\": \"FAIL\"}");
			}
		
		
		
	}
	
}
