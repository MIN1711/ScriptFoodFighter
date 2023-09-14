package board.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;

@WebServlet("/board/update.do")
public class UpdateBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bNo = req.getParameter("bNo");

		IBoardService bService = BoardServiceImpl.getInstance();

		BoardVO bv = bService.bnoBoard(bNo);

		req.setAttribute("bv", bv);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/update.jsp");

		dispatcher.forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int bNo = Integer.parseInt(req.getParameter("bNo"));
		String bTitle = req.getParameter("bTitle");
		String bCon = req.getParameter("bCon");
		String cusId = req.getParameter("cusId");
		String ctgNo = req.getParameter("ctgNo");

		// 서비스 객체 생성
		IBoardService brdService = BoardServiceImpl.getInstance();

		BoardVO brdVo = new BoardVO();
		brdVo.setbNo(bNo);
		brdVo.setbTitle(bTitle);
		brdVo.setbCon(bCon);
		brdVo.setCusId(cusId);
		brdVo.setCtgNo(ctgNo);

		// 게시글 수정하기
		int cnt = brdService.modifyBoard(brdVo);

		resp.sendRedirect(req.getContextPath() + "/board/list.do");

	}

}
