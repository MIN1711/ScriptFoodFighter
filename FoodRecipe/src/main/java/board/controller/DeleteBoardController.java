package board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/board/delete.do")
public class DeleteBoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bNo = Integer.parseInt(req.getParameter("bNo"));

        IBoardService bService = BoardServiceImpl.getInstance();

        // 댓글 유무 확인
        boolean hasReply = bService.hasReply(bNo);
        boolean hasLike = bService.hasLike(bNo);
        
        System.out.println(hasReply);
        System.out.println(hasLike);
        BoardVO bv = new BoardVO();
        bv.setbNo(bNo);

        if (hasReply) { // 댓글이 있을 때
            System.out.println("댓글있다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            
            int replyCnt = bService.removeBoardReply(bv);

            if (hasLike) { // 추천이 있을 때
            	System.out.println("추천있다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                int cnt = bService.removeBoardLike(bv);
            }
            int cnt = bService.removeBoard(bNo);
            resp.sendRedirect(req.getContextPath() + "/board/list.do");
        } else { // 댓글이 없는 경우
        	System.out.println("댓글없다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if (hasLike) { // 추천이 있을 때
               	System.out.println("추천있다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                int cnt = bService.removeBoardLike(bv);
            }
            int cnt = bService.removeBoard(bNo);
            resp.sendRedirect(req.getContextPath() + "/board/list.do");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}