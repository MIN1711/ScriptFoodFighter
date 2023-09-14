package notice.controller;

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
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import notice.vo.NoticeVO;

@WebServlet("/notice/update.do")
public class UpdateNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nNo = req.getParameter("nNo");

		INoticeService nService = NoticeServiceImpl.getInstance();

		NoticeVO nv = nService.nnoBoard(nNo);

		req.setAttribute("nv", nv);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/update.jsp");

		dispatcher.forward(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nNo = req.getParameter("nNo");
		String nCon = req.getParameter("nCon");
		String manCod ="admin";

		// 서비스 객체 생성
		INoticeService nService = NoticeServiceImpl.getInstance();

		NoticeVO nv = new NoticeVO();
		nv.setnNo(nNo);
		nv.setnCon(nCon);
		nv.setManCod(manCod);

		// 게시글 수정하기
		int cnt = nService.modifyNotice(nv);

		resp.sendRedirect(req.getContextPath() + "/notice/list.do");

	}

}
