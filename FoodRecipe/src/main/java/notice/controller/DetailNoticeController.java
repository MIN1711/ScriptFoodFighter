package notice.controller;

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

import board.service.BoardServiceImpl;
import board.service.IBoardService;
import board.vo.BoardVO;
import boardReply.service.BoardReplyServiceImpl;
import boardReply.service.IBoardReplyService;
import boardReply.vo.BoardReplyVO;
import notice.service.INoticeService;
import notice.service.NoticeServiceImpl;
import notice.vo.NoticeVO;

@WebServlet("/notice/detail.do")
public class DetailNoticeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String nNo = req.getParameter("nNo");

		INoticeService nService = NoticeServiceImpl.getInstance();

		NoticeVO nv = nService.nnoBoard(nNo);
		req.setAttribute("nv", nv);

		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("nNo", nNo);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp");

		dispatcher.forward(req, res);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
