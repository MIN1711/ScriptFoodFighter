package qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qna.service.IQnAService;
import qna.service.QnAServiceImpl;
import qna.vo.QnAVO;

@WebServlet("/qna/delete.do")
public class DeleteQnAController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    int qNo = Integer.parseInt(req.getParameter("qNo"));

	    IQnAService qService = QnAServiceImpl.getInstance();

	    // 댓글 유무 확인
	    boolean hasReply = qService.hasReply(qNo);

	    if (hasReply) { // 댓글 있을 때
	    	System.out.println(">>>>>>>>>>>>>>>>>>넘어오나?");
	    	
	        // 댓글 삭제
	        QnAVO qv = new QnAVO();
	        qv.setqNo(qNo);
	        int replyCnt = qService.removeQnAReply(qv);

	        if (replyCnt > 0) {
	        	System.out.println("댓글 삭제 성공! 게시물 삭제 실행");
	            int cnt = qService.removeQnA(qNo);
	            resp.sendRedirect(req.getContextPath() + "/qna/list.do");
	        } else {
	            System.out.println("댓글 삭제 실패");
	        }
	    } else { // 댓글이 없는 경우 게시물만 삭제
	        int cnt = qService.removeQnA(qNo);
	        resp.sendRedirect(req.getContextPath() + "/qna/list.do");
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
	}
}
