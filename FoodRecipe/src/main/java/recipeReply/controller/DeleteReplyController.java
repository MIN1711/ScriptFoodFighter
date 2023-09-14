package recipeReply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipeReply.service.IRecipeReplyService;
import recipeReply.service.RecipeReplyServiceImpl;
import recipeReply.vo.RecipeReplyVO;

@WebServlet("/recipe/deleteReply.do")
public class DeleteReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int rNo = Integer.parseInt(req.getParameter("rNo"));
		int rRNo = Integer.parseInt(req.getParameter("rRNo"));
		
		System.out.println(rNo);
		System.out.println(rRNo);
		

		IRecipeReplyService reService = RecipeReplyServiceImpl.getInstance();

		RecipeReplyVO rrVo = new RecipeReplyVO();
		rrVo.setrRNo(rRNo);
		rrVo.setrNo(rNo);

		int cnt = reService.removeRecReply(rrVo);
		System.out.println("삭제되나요!!!!!!!!!!!!!!!!!!!"+cnt);
//		try {
//			int cnt = reService.removeRecReply(rrVo);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		resp.sendRedirect(req.getContextPath() + "/recipe/detail.do?rNo=" + rNo);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
