package orders.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orders.service.IOrdersService;
import orders.service.OrdersServiceImpl;

@WebServlet("/maneger/cancel.do")
public class CancelOrdersController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IOrdersService ordersService = OrdersServiceImpl.getInstance();
		
		int oNo = Integer.parseInt(req.getParameter("oNo"));
		
		int cancel = ordersService.cancelOrder(oNo);
		
		resp.getWriter().write(cancel);
		
		resp.sendRedirect(req.getContextPath() + "/maneger/orderslist.do");
	}
}
