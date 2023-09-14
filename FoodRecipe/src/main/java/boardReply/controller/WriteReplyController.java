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

@WebServlet("/board/Reply.do")
public class WriteReplyController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/board/detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 받아와야할 파라미터
		int bNo = Integer.parseInt(request.getParameter("bNo"));
		String brCont = request.getParameter("bRCont");
		String cusId = request.getParameter("cusId");

		// 서비스 객체 생성
		IBoardReplyService brdService = BoardReplyServiceImpl.getInstance();

		// 받아온 파라미터를 vo에 저장
		BoardReplyVO brVo = new BoardReplyVO();
		brVo.setbNo(bNo);
		brVo.setbRCont(brCont);
		brVo.setCusId(cusId);

		try {
			// 댓글 등록하기
			int cnt = brdService.registBrdReply(brVo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// bNo받아와 redirect --> ajax에서 reload() 사용
		//response.sendRedirect(request.getContextPath() + "/board/detail.do?bNo=" + bNo);

	}
}
