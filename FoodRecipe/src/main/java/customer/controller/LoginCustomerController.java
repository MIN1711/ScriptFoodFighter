package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.service.CustomerServiceImpl;
import customer.service.ICustomerService;
import customer.vo.CustomerVO;

@WebServlet("/loginChk.do")
public class LoginCustomerController extends HttpServlet{

private static final long serialVersionUID = 1L;
    
    public LoginCustomerController() {
        super();
       
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">>>>>>>>>>>> 잘들어옴");
		
		//WEB-INF폴더 내부 jsp로 이동하기 위해 requestDispatcher객체 도움을 받음
		//request.getRequestDispatcher("WEB-INF/security_index.jsp").forward(request, response);
		String cusId = request.getParameter("cusId");
		String cusPw = request.getParameter("cusPw");
		
		System.out.println("들어왔나요?"+cusId+cusPw);
		
		CustomerVO cv = new CustomerVO();
		cv.setcusId(cusId);
		cv.setcusPw(cusPw);
		
		ICustomerService service = CustomerServiceImpl.getInstance();
		
		CustomerVO loginId = service.loginChk(cv);
		
		request.setAttribute("cusId", cusId);
		
		request.setAttribute("res",loginId);
		
		
		if(loginId != null) {
			HttpSession session = request.getSession();
			session.setAttribute("loginId" , loginId);
			session.setAttribute("cusId", cusId);
			
			System.out.println("loginId" + loginId);
		}
		request.getRequestDispatcher("/loadTest.jsp").forward(request, response);

	}
}


	


