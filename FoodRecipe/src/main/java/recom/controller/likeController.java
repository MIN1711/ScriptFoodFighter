package recom.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import recom.service.IRecomService;
import recom.service.RecomServiceImpl;
import recom.vo.RecomVO;

@WebServlet("/board/like.do")
public class likeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public likeController() {
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		IRecomService rService = RecomServiceImpl.getInstance();
		HttpSession session = req.getSession();

		int bNo = Integer.parseInt(req.getParameter("bNo"));
		String cusId = (String) session.getAttribute("cusId");
		String cNo = req.getParameter("cNo");

		RecomVO rv = new RecomVO();

		rv.setbNo(bNo);
		rv.setCusId(cusId);
		int cnt = 0;
		if (cNo.equals("DISLIKE")) {
			cnt = rService.insertRec(rv);
		} else {
			cnt = rService.deleteRec(rv);
		}

		PrintWriter out = resp.getWriter();
		if(cnt>0 && cNo.equals("DISLIKE")) {
			out.print("{\"cNo\": \"LIKE\"}");
		} else {
			out.print("{\"cNo\": \"DISLIKE\"}");
		}
		
		
		
		
		// resp.sendRedirect(req.getContextPath() + "/board/detail.do");

	}

}
