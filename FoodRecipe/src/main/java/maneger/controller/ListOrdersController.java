package maneger.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maneger.service.IManegerService;
import maneger.service.ManegerServiceImpl;
import orders.vo.OrdersVO;

@WebServlet(value = "/maneger/orderslist.do")
public class ListOrdersController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IManegerService manService = ManegerServiceImpl.getInstance();
		
		List<OrdersVO> ordeList = manService.displayOrders();
		
		req.setAttribute("ordeList", ordeList);
		
		req.getRequestDispatcher("/WEB-INF/views/maneger/orderslist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
