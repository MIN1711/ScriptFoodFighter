package maneger.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.service.CustomerServiceImpl;
import customer.service.ICustomerService;
import customer.vo.CustomerVO;
import maneger.service.IManegerService;
import maneger.service.ManegerServiceImpl;

@WebServlet(value = "/maneger/customerlist.do")
public class ListCustController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IManegerService manService = ManegerServiceImpl.getInstance();
		
		List<CustomerVO> custList = manService.displayCustomer();
		
		req.setAttribute("custList", custList);
		
		req.getRequestDispatcher("/WEB-INF/views/maneger/customerlist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
