package customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.service.CustomerServiceImpl;
import customer.service.ICustomerService;
import customer.vo.CustomerVO;



@WebServlet("/customer/detail.do")
public class DetailMemberController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String cusId = req.getParameter("cusId");
		
		ICustomerService cusService = CustomerServiceImpl.getInstance();
				
		CustomerVO cv = cusService.getCustomer(cusId);
		
		req.setAttribute("cv", cv);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(
									"/WEB-INF/views/customer/detail.jsp");
		dispatcher.forward(req,resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
