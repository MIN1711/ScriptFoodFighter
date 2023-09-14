package recipe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import recipe.service.IRecipeService;
import recipe.service.RecipeServiceImpl;
import recipe.vo.RecipeVO;
import recipeReply.service.IRecipeReplyService;
import recipeReply.service.RecipeReplyServiceImpl;
import recipeReply.vo.RecipeReplyVO;
import wish.service.IWishService;
import wish.service.WishServiceImpl;
import wish.vo.WishVO;

@WebServlet("/recipe/detail.do")
public class DetailRecipeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 레시피 관련 시작
		int rNo = Integer.parseInt(req.getParameter("rNo"));

		IRecipeService reService = RecipeServiceImpl.getInstance();

		RecipeVO rv = reService.getRecipe(rNo);

		req.setAttribute("rv", rv);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rNo", rNo);

		IRecipeReplyService recService = RecipeReplyServiceImpl.getInstance();

		List<RecipeReplyVO> recipeReplyList = recService.displayRecipeReply(map);

		req.setAttribute("replylist", recipeReplyList);
		// 레시피 관련 끝
		
		// 좋아요 시작
		HttpSession session = req.getSession();

		String cusId = (String) session.getAttribute("cusId");
		System.out.println(">>>>>>>>>>>>>>>>>>>>>" + cusId);

		if (cusId != null) {

			IWishService wservice = WishServiceImpl.getInstance();
 
			WishVO wv = new WishVO();
			wv.setrNo(rNo);
			wv.setCusId(cusId);

			int check = wservice.countWish(wv);

			if (check > 0) {
				wv.setcNo("LIKE");
			} else {
				wv.setcNo("DISLIKE");
			}
			req.setAttribute("wv", wv);
		}
		// 좋아요 끝
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/recipe/detail.jsp");
		
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
