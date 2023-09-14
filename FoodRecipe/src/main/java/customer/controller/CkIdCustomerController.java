package customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.service.CustomerServiceImpl;
import customer.service.ICustomerService;
import customer.vo.CustomerVO;


@WebServlet("/customer/IdChk.do")
public class CkIdCustomerController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 
		String inputId = req.getParameter("id");
		
		ICustomerService service = CustomerServiceImpl.getInstance();
		
		String res = service.selectById(inputId);
		
		req.setAttribute("resid", res);
		
		req.getRequestDispatcher("/idChk2.jsp").forward(req,resp);
	}
}    
