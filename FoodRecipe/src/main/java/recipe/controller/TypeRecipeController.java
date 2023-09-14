package recipe.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.service.IRecipeService;
import recipe.service.RecipeServiceImpl;
import recipe.vo.RecipeVO;


@WebServlet(value = "/recipe/listtype.do")
public class TypeRecipeController extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   
	  String rType = req.getParameter("rType");
	  String rMenu = req.getParameter("rMenu");
	  
	  RecipeVO rv = new RecipeVO();
	  
	  rv.setrType(rType);
	  rv.setrMenu(rMenu);
	   
      //객체 생성
      IRecipeService recipeService = RecipeServiceImpl.getInstance();
      
      //조회
      Map<String, Object> rmap = new HashMap<String, Object>();
      rmap.put("rType", rv.getrType());
      rmap.put("rMenu", rv.getrMenu());
      
      List<RecipeVO> recipeList = recipeService.recipeList(rmap);

      
      //출력을 위한 데이터 저장
      req.setAttribute("rt", recipeList);
      req.setAttribute("rType", rType);
      
      //포워딩
      req.getRequestDispatcher("/WEB-INF/views/recipe/listtype.jsp").forward(req, resp);
      
   
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
      doGet(req, resp);
   }
}