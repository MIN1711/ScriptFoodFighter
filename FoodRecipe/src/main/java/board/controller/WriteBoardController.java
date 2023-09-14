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

@WebServlet("/board/insert.do")
public class WriteBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/board/insert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bTitle = req.getParameter("bTitle");
		String bCon = req.getParameter("bCon");
		String cusId = req.getParameter("cusId");
		String ctgNo = req.getParameter("ctgNo");

		// 서비스 객체 생성
		IBoardService brdService = BoardServiceImpl.getInstance();

		BoardVO brdVo = new BoardVO();
		brdVo.setbTitle(bTitle);
		brdVo.setbCon(bCon);
		brdVo.setCusId(cusId);
		brdVo.setCtgNo(ctgNo);

		int cnt = brdService.registBoard(brdVo);

		resp.sendRedirect(req.getContextPath() + "/board/list.do");

	}

}
