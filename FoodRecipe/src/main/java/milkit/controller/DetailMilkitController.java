package milkit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import milkit.service.IMiltkitService;
import milkit.service.MilkitServiceImpl;
import milkit.vo.MilkitVO;
import recipe.service.IRecipeService;
import recipe.service.RecipeServiceImpl;
import recipe.vo.RecipeVO;

@WebServlet("/recipe/milkit.do")
public class DetailMilkitController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rNo = Integer.parseInt(req.getParameter("rNo"));
		
		IRecipeService rService = 
				RecipeServiceImpl.getInstance();
		
		RecipeVO rv = rService.getRecipe(rNo);
		
		req.setAttribute("rv", rv);
		
		IMiltkitService mkService = 
				MilkitServiceImpl.getInstance();
		
		MilkitVO mkv = mkService.getMilkit(rNo);
		
		req.setAttribute("mkv", mkv);
		
		RequestDispatcher dispatcher =
				req.getRequestDispatcher(
				"/WEB-INF/views/recipe/milkit.jsp");
		dispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
