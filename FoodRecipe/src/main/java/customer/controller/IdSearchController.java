package customer.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.service.CustomerServiceImpl;
import customer.service.ICustomerService;
import customer.vo.CustomerVO;
import recipe.service.IRecipeService;
import recipe.service.RecipeServiceImpl;
import recipe.vo.RecipeVO;

@WebServlet("/customer/idSearch.do")
public class IdSearchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/customer/idSearch.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String cusId = req.getParameter("cusId");
		String cusName = req.getParameter("cusName");
		String cusTel = req.getParameter("cusTel");
		String cusAddr = req.getParameter("cusAddr");
		String cusPw = req.getParameter("cusPw");
		String cusImg = req.getParameter("cusImg");
		String cusAct = req.getParameter("cusAct");
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("cusName", cusName);
			map.put("cusTel", cusTel);
			
			ICustomerService cusServ = 
					CustomerServiceImpl.getInstance();
			
			//ICustomerService cusServ = new CustomerServiceImpl();
			
			
			CustomerVO cv = new CustomerVO(cusId, cusName, cusTel, cusAddr, cusPw, cusImg, cusAct);
			
			String idSearch = cusServ.findId(map);
			
			PrintWriter out = resp.getWriter();
			
			if(idSearch != null) {
				System.out.println("해당 회원 존재");
				out.println("{\"code\": \"OK\", \"data\": \"" + idSearch + "\"}");
				
			}else {
				System.out.println("해당 회원 존재하지 않습니다.");
				out.println("{\"code\": \"FAIL\"}");
			}
			
			
			
		}
		
	}

