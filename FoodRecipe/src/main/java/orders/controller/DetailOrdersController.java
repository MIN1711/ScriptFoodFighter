package orders.controller;

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

@WebServlet("/orders/detail.do")
public class DetailOrdersController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int oNo = Integer.parseInt(req.getParameter("oNo"));

		OrdersVO ov = new OrdersVO();

		CartVO cv = new CartVO();

		MilkitVO mv = new MilkitVO();

		RecipeVO rv = new RecipeVO();

		IOrdersService ordersService = OrdersServiceImpl.getInstance();
		ICartService cartService = CartServiceImpl.getInstance();
		IMiltkitService milkitService = MilkitServiceImpl.getInstance();
		IRecipeService recipeService = RecipeServiceImpl.getInstance();
		ICustomerService cusService = CustomerServiceImpl.getInstance();
		
		ov = ordersService.payOrders(oNo);
		
		CustomerVO cus = new CustomerVO();
		
		cus = cusService.getCustomer(ov.getCusId());
		
		List<CartVO> cartList = ordersService.getCartList(oNo);

		for (CartVO cVo : cartList) {
			String rMenu = recipeService.getRMenu(cVo.getrNo());
			cVo.setrMenu(rMenu);
		}

		for (CartVO cVo : cartList) {
			int mPrice = milkitService.getMPrice(cVo.getrNo());
			cVo.setmPrice(mPrice);
		}

		req.setAttribute("cList", cartList);
		req.setAttribute("cus", cus);

		req.getRequestDispatcher("/WEB-INF/views/orders/ordersdetail.jsp").forward(req, resp);
	}

}
