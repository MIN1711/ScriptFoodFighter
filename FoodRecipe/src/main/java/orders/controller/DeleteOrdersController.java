package orders.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.vo.CustomerVO;
import orders.service.IOrdersService;
import orders.service.OrdersServiceImpl;

@WebServlet("/orders/cancel.do")
public class DeleteOrdersController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerVO cus = (CustomerVO) req.getSession().getAttribute("loginId");
		
		String cusId = cus.getcusId();

		IOrdersService ordersService = OrdersServiceImpl.getInstance();
		
		int oNo = Integer.parseInt(req.getParameter("oNo"));
		
		int cancel = ordersService.cancelOrder(oNo);
		
		resp.getWriter().write(cancel);
		
		resp.sendRedirect(req.getContextPath() + "/customer/mybuylist.do?cusId=" + URLEncoder.encode(cusId, "UTF-8"));
	}
}
