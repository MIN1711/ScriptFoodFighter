package notice.controller;

import java.io.IOException;
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

@WebServlet("/notice/insert.do")
public class WriteNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/notice/insert.jsp").forward(request, response);
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
		int cnt = nService.registNotice(nv);

		resp.sendRedirect(req.getContextPath() + "/notice/list.do");

	}

}
