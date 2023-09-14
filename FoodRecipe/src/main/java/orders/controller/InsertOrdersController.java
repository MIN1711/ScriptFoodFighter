package orders.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import milkit.service.IMiltkitService;
import milkit.service.MilkitServiceImpl;
import milkit.vo.MilkitVO;
import orders.service.CartServiceImpl;
import orders.service.ICartService;
import orders.service.IOrdersService;
import orders.service.OrdersServiceImpl;
import orders.vo.CartVO;
import orders.vo.OrdersVO;
import recipe.service.RecipeServiceImpl;

@WebServlet("/orders/orders.do")
public class InsertOrdersController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/orders/insert.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ICartService cartService = CartServiceImpl.getInstance();

		IOrdersService ordersService = OrdersServiceImpl.getInstance();
		
		IMiltkitService milkitsService = MilkitServiceImpl.getInstance();

		CartVO cv = new CartVO();

		OrdersVO ov = new OrdersVO();
		
		MilkitVO mv = new MilkitVO();

		int rNo = Integer.parseInt(req.getParameter("rNo"));
		String cusId = req.getParameter("cusId");
		
		int cartNo = 1;
		String oCode = req.getParameter("oCode");
		
		int mPrice = Integer.parseInt(req.getParameter("mPrice"));
		
		ov.setCusId(cusId);
		ov.setoCode("N");
		ov.setoMoney(mPrice);
		
		cv.setrNo(rNo);
		cv.setCartNo(cartNo);
		System.out.println(cusId);
		
		int ordersNum = ordersService.getOno(cusId);
		
		int chkorders = ordersService.ordersChk(cusId);
		
		if (chkorders == 0) { // 활성화된 주문이 없는 상태
			// 주문번호 및 주문 생성 후 카트 생성
			int cnt = ordersService.registOrders(ov);
			ordersNum = ordersService.getOno(cusId);
			cv.setoNo(ordersNum);
			int cartcnt = cartService.registCart(cv);
			resp.getWriter().write(cartcnt);
		} else { // 활성화된 주문번호가 있음
			cv.setoNo(ordersNum);
			int cartcnt = cartService.registCart(cv);
			mPrice += ordersService.getMoney(ordersNum);
			ov.setoNo(ordersNum);
			ov.setoMoney(mPrice);
			int cnt = ordersService.updateMoney(ov);
			resp.getWriter().write(cartcnt);
			
		}
		
		//req.getRequestDispatcher("/WEB-INF/views/orders/cart.jsp").forward(req, resp);
	}
}