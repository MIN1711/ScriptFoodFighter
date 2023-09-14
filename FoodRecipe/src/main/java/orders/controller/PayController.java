package orders.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.vo.CustomerVO;
import orders.service.IOrdersService;
import orders.service.OrdersServiceImpl;
import orders.vo.OrdersVO;

@WebServlet("/orders/pay.do")
public class PayController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CustomerVO cus = (CustomerVO) req.getSession().getAttribute("loginId");
		String cusId = cus.getcusId();
		
		IOrdersService ordersService = OrdersServiceImpl.getInstance();
		int oNo = ordersService.getOno(cusId);
		
		OrdersVO ov = ordersService.payOrders(oNo);
		
		req.setAttribute("ov", ov);
		req.setAttribute("cus", cus);
		
		req.getRequestDispatcher("/WEB-INF/views/orders/payment.jsp").forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
