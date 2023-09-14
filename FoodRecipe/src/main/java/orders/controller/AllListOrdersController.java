package orders.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import orders.service.IOrdersService;
import orders.service.OrdersServiceImpl;
import orders.vo.OrdersVO;

@WebServlet("/orders/AllList.do")
public class AllListOrdersController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IOrdersService orService = OrdersServiceImpl.getInstance();
		
		List<OrdersVO> ordersList =  orService.displayAllOrders();		
		
		req.setAttribute("orList", ordersList);
		
		req.getRequestDispatcher("/WEB-INF/views/orders/list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
