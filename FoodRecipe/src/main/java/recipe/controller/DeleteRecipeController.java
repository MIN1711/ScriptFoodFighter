package recipe.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.service.IRecipeService;
import recipe.service.RecipeServiceImpl;

@WebServlet("/recipe/delete.do")
public class DeleteRecipeController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int rNo = Integer.parseInt(req.getParameter("rNo"));
	
		IRecipeService reService = RecipeServiceImpl.getInstance();
		
		int cnt = reService.removeRecipe(rNo);
		
		String msg = "";
		if(cnt > 0) {
			msg = "회원 삭제를 성공했습니다.";
		}else {
			msg = "회원 삭제를 실패했습니다.";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(
				req.getContextPath() + "/recipe/delete.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
