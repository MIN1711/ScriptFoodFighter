package recipe.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.service.IRecipeService;
import recipe.service.RecipeServiceImpl;
import recipe.vo.RecipeVO;

@WebServlet
public class UpdateRecipeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rNo = Integer.parseInt(req.getParameter("rNo"));
		
		IRecipeService reService = 
				RecipeServiceImpl.getInstance();
		
		RecipeVO rv = reService.getRecipe(rNo);
		
		req.setAttribute("rv", rv);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(
				"/WEB-INF/views/recipe/updateRe.jsp");
				
	}
	// 각 데이터 설정 및 수정
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int rNo = Integer.parseInt(req.getParameter("rNo"));
		String rMenu = req.getParameter("rMenu");
		String rType = req.getParameter("rType");
		double rCal = Double.parseDouble(req.getParameter("rCal"));
		String rImgS = req.getParameter("rImgS");
		String rImsL = req.getParameter("rImgL"); 
		String rDt = req.getParameter("rDt");
		String rM1 = req.getParameter("rM1");
		String rMm1 = req.getParameter("rMm1");
		String rM2 = req.getParameter("rM2");
		String rMm2 = req.getParameter("rMm2");
		String rM3 = req.getParameter("rM3");
		String rMm3 = req.getParameter("rMm3");
		String rM4 = req.getParameter("rM4");
		String rMm4 = req.getParameter("rMm4");
		String rM5 = req.getParameter("rM5");
		String rMm5 = req.getParameter("rMm5");
		String rM6 = req.getParameter("rM6");
		String rMm6 = req.getParameter("rMm6");
		String rTip = req.getParameter("rTip");
		
		IRecipeService resService = RecipeServiceImpl.getInstance();
		
		RecipeVO rv = new RecipeVO(rNo, rMenu, rType, rCal, rImgS, rImsL, rDt, rM1, rMm1,
				rM2, rMm2, rM3, rMm3, rM4, rMm4, rM5, rMm5, rM6, rMm6, rTip	);
		
		int cnt = resService.modifyRecipe(rv);
		
		String msg = "";
		
		if(cnt > 0) {
			msg = "수정이 완료되었습니다.";
		}else {
			msg = "수정이 실패했습니다.";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/recipe/list.do");
	}
}
