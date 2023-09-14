package orders.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.vo.CustomerVO;
import milkit.service.IMiltkitService;
import milkit.service.MilkitServiceImpl;
import milkit.vo.MilkitVO;
import orders.service.CartServiceImpl;
import orders.service.ICartService;
import orders.service.IOrdersService;
import orders.service.OrdersServiceImpl;
import orders.vo.CartVO;
import orders.vo.OrdersVO;
import recipe.service.IRecipeService;
import recipe.service.RecipeServiceImpl;
import recipe.vo.RecipeVO;

@WebServlet("/orders/update.do")
public class UpdateCartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 장바구니를 연 고객
		CustomerVO cus = (CustomerVO) req.getSession().getAttribute("loginId");
		String cusId = cus.getcusId();
		
		int cartNo = Integer.parseInt(req.getParameter("cNo"));
		int rNo = Integer.parseInt(req.getParameter("rNo"));

		IOrdersService ordersService = OrdersServiceImpl.getInstance();
		ICartService cartService = CartServiceImpl.getInstance();
		IMiltkitService milkitService = MilkitServiceImpl.getInstance();

		// 결제 N인 가장 높은 cusId의 주문번호
		int oNo = ordersService.getOno(cusId);
		
		CartVO cv = new CartVO();
		OrdersVO ov = new OrdersVO();
		
		cv.setoNo(oNo);
		cv.setrNo(rNo);
		
		
		int bp = cartService.getNo(cv);
		int price = milkitService.getMPrice(rNo);
		bp = bp * price;
		
		int orderssum = ordersService.getMoney(oNo);
		
		orderssum -= bp; // 총 금액에서 이전 주문량만큼의 가격 -
		
		cv.setCartNo(cartNo);
		cartService.changeCart(cv);
		
		int ap = cartNo * price;
		
		orderssum += ap; // 총 금액에 주문량만큼의 가격 +
		ov.setoNo(oNo);
		ov.setoMoney(orderssum);
		
		ordersService.updateMoney(ov);
		int cno = cartService.changeCart(cv);	
		
		resp.getWriter().write(cno);

		resp.sendRedirect(req.getContextPath() + "/orders/cart.do");
	}

}
