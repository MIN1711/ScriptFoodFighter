package wish.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import wish.service.IWishService;
import wish.service.WishServiceImpl;
import wish.vo.WishVO;

@WebServlet("/wish/wish.do")
public class WishController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public WishController() {
   }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      doPost(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      IWishService service = WishServiceImpl.getInstance();
      HttpSession session = request.getSession();

      int rNo = Integer.parseInt(request.getParameter("rNo"));
      String cusId = (String) session.getAttribute("cusId");
      String cNo = request.getParameter("cNo");

      WishVO wv = new WishVO();

      wv.setrNo(rNo);
      wv.setCusId(cusId);
      int cnt = 0;
      
      if (cNo.equals("DISLIKE")) {
         cnt = service.insertWish(wv);
      } else {
         cnt = service.deleteWish(wv);
      }

      PrintWriter out = response.getWriter();
      
      if (cnt > 0 && cNo.equals("DISLIKE")) {
         out.print("{\"cNo\": \"LIKE\"}");
      } else {
         out.print("{\"cNo\": \"DISLIKE\"}");
      }
      // wish 목록 출력은 마이페이지에서 실행
   }
}