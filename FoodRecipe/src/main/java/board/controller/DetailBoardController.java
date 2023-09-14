package board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import boardReply.service.BoardReplyServiceImpl;
import boardReply.service.IBoardReplyService;
import boardReply.vo.BoardReplyVO;
import recom.service.IRecomService;
import recom.service.RecomServiceImpl;
import recom.vo.RecomVO;

@WebServlet("/board/detail.do")
public class DetailBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String bNo = req.getParameter("bNo");

		IBoardService bService = BoardServiceImpl.getInstance();

		BoardVO bv = bService.bnoBoard(bNo);

		req.setAttribute("bv", bv);

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bNo", bNo);

		// 게시물댓글 목록 관련 추가 시작
		// 정보 조회를 위한 서비스 객체 생성하기
		IBoardReplyService service = BoardReplyServiceImpl.getInstance();

		// 내용 저장
		List<BoardReplyVO> boardReplyList = service.displayBoardReply(map);

		// 결과 boardReplyList를 request에 담아서 출력할 페이지로 전달
		req.setAttribute("Replylist", boardReplyList);
		// 게시물댓글 목록 관련 끝

		// 좋아요 기능 구현

		HttpSession session = req.getSession();

		String cusId = (String) session.getAttribute("cusId");

		System.out.println(">>>>>>>>>>>>>>>>>>>>>" + cusId);

		if (cusId != null) {

			IRecomService rService = RecomServiceImpl.getInstance();

			RecomVO rv = new RecomVO();
			rv.setbNo(Integer.parseInt(bNo));
			rv.setCusId(cusId);

			int check = rService.countRec(rv);

			if (check > 0) {

				rv.setcNo("LIKE");

			} else {
				rv.setcNo("DISLIKE");
			}

			req.setAttribute("rv", rv);

		}else {
			
			RecomVO rv = new RecomVO();
			req.setAttribute("rv", rv);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/detail.jsp");

		dispatcher.forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
