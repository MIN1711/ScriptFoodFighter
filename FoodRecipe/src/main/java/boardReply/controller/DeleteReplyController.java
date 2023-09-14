package boardReply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import boardReply.service.BoardReplyServiceImpl;
import boardReply.service.IBoardReplyService;
import boardReply.vo.BoardReplyVO;

@WebServlet("/board/deleteReply.do")
public class DeleteReplyController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 받아와야할 파라미터
		int bNo = Integer.parseInt(req.getParameter("bNo"));
		int bRNo = Integer.parseInt(req.getParameter("bRNo"));

		// 서비스 객체 생성
		IBoardReplyService brService = BoardReplyServiceImpl.getInstance();

		// 파라미터 vo에 저장
		BoardReplyVO brVo = new BoardReplyVO();
		brVo.setbRNo(bRNo);
		brVo.setbNo(bNo);
		
		try {
			// 댓글 등록하기
			int cnt = brService.removeBrdReply(brVo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		resp.sendRedirect(req.getContextPath() + "/board/detail.do?bNo="+bNo);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}
}
