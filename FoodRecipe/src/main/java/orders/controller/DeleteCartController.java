package orders.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.vo.CustomerVO;
import milkit.service.IMiltkitService;
import milkit.service.MilkitServiceImpl;
import orders.service.CartServiceImpl;
import orders.service.ICartService;
import orders.service.IOrdersService;
import orders.service.OrdersServiceImpl;
import orders.vo.CartVO;
import orders.vo.OrdersVO;

@WebServlet("/orders/dropcart.do")
public class DeleteCartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CustomerVO cus = (CustomerVO) req.getSession().getAttribute("loginId");

		String cusId = cus.getcusId();

		ICartService cartService = CartServiceImpl.getInstance();
		IOrdersService ordersService = OrdersServiceImpl.getInstance();
		IMiltkitService milkitService = MilkitServiceImpl.getInstance();
		
		CartVO cv = new CartVO();
		OrdersVO ov = new OrdersVO();
		
		// 주문번호
		int oNo = ordersService.getOno(cusId);
		// 레시피번호
		int rNo = Integer.parseInt(req.getParameter("rNo"));
		// cartVO에 값 입력
		cv.setoNo(oNo);
		cv.setrNo(rNo);
		
		// 삭제한 밀키트 가격 -
		int bp = cartService.getNo(cv);
		int price = milkitService.getMPrice(rNo);
		bp = bp * price;
		int orderssum = ordersService.getMoney(oNo);
		orderssum -= bp; // 총 금액에서 이전 주문량만큼의 가격 -
		ov.setoNo(oNo);
		ov.setoMoney(orderssum);
		ordersService.updateMoney(ov);

		int del = cartService.removeCart(cv); // 장바구니에서 밀키트 제거
		
		resp.getWriter().write(del);

		resp.sendRedirect(req.getContextPath() + "/orders/cart.do");

	}

}
