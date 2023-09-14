package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;

@WebServlet("/notice/delete.do")
public class DeleteNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String nNo = req.getParameter("nNo");

		INoticeService nService = NoticeServiceImpl.getInstance();

		int cnt = nService.removeNotice(nNo);

		resp.sendRedirect(req.getContextPath() + "/notice/list.do");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

}
