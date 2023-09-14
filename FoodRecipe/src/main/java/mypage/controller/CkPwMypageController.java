package mypage.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mypage.service.IMypageService;
import mypage.service.MypageServiceImpl;

@WebServlet("/mypage/PwChk.do")
public class CkPwMypageController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inputPw = req.getParameter("pw");
		
		IMypageService service = MypageServiceImpl.getInstance();
		
		String res = service.selectByPw(inputPw);
		
		req.setAttribute("respw", res);
		
		req.getRequestDispatcher("/pwChk.jsp").forward(req, resp);
		
	}
	
	
}
