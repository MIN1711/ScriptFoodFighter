package orders.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

@WebServlet("/orders/cart.do")
public class ListCartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		CustomerVO cus = (CustomerVO) req.getSession().getAttribute("loginId");

		String cusId = cus.getcusId();

		OrdersVO ov = new OrdersVO();

		CartVO cv = new CartVO();

		MilkitVO mv = new MilkitVO();

		RecipeVO rv = new RecipeVO();

		IOrdersService ordersService = OrdersServiceImpl.getInstance();

		ICartService cartService = CartServiceImpl.getInstance();

		IMiltkitService milkitService = MilkitServiceImpl.getInstance();

		IRecipeService recipeService = RecipeServiceImpl.getInstance();

		// 결제 N인 가장 높은 cusId의 주문번호
		int ordersNum = ordersService.getOno(cusId);

		List<CartVO> cartList = ordersService.getCartList(ordersNum);

		for (CartVO cVo : cartList) {
			String rMenu = recipeService.getRMenu(cVo.getrNo());
			cVo.setrMenu(rMenu);
		}

		for (CartVO cVo : cartList) {
			int mPrice = milkitService.getMPrice(cVo.getrNo());
			cVo.setmPrice(mPrice);
		}

		req.setAttribute("cList", cartList);

		req.getRequestDispatcher("/WEB-INF/views/orders/cart.jsp").forward(req, resp);
	}

}
