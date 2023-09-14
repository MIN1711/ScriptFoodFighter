package main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import recipe.service.IRecipeService;
import recipe.service.RecipeServiceImpl;
import recipe.vo.RecipeVO;


@WebServlet(value = "/mainpage.do")
public class MainRecipeController extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      //객체 생성
      IRecipeService recipeService = RecipeServiceImpl.getInstance();
      
      //조회
      List<RecipeVO> recipeList = recipeService.displayAllRecipe();
      
      //출력을 위한 데이터 저장
      req.setAttribute("reList", recipeList);
      
      //포워딩
      req.getRequestDispatcher("Main.jsp").forward(req, resp);   
      
   
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
      doGet(req, resp);
   }
}
