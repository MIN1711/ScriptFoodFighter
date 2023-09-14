package customer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.service.CustomerServiceImpl;
import customer.service.ICustomerService;


@WebServlet("/customer/delete.do")
public class DeleteCustomerController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String cusId = req.getParameter("cusId");
		
		ICustomerService cusService = CustomerServiceImpl.getInstance();
		
		//삭제하기
		int cnt = cusService.removeCustomer(cusId);
		String msg = "";
		if(cnt > 0) {
			msg = "성공";
		}else {
			msg="실패";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath()+ "/logout.do");
		// getConteextPath쓰이는 이유? 클라이언트창에서는 써야하니까 / 클라이언트쪽에서 봤을 때는 여러가지 애플리케이션을 구분하다보니 필요함. form 쓸때는 안써 
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}	
}
