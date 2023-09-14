package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout.do")
public class LogoutController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    
    public LogoutController() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();// 세션 종료 
		
		res.sendRedirect(req.getContextPath()+"/mainpage.do" ); // contextroot(톰캣이 참조하는 프로젝트 고유의 이름)로 위치 지정  
		
		
		
	}

}
