package customer.controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import customer.service.CustomerServiceImpl;
import customer.service.FileServiceImpl;
import customer.service.ICustomerService;
import customer.service.IFileService;
import customer.vo.CustomerVO;



@MultipartConfig
@WebServlet("/customer/insert.do")
public class InsertCustomerController extends HttpServlet{
   
	
	
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      req.getRequestDispatcher("/WEB-INF/views/customer/join.jsp").forward(req, resp);
   }
  
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      String filePath ="";
      String cusId = req.getParameter("cusId");
      String cusName = req.getParameter("cusName");
      String cusTel = req.getParameter("cusTel");
      String cusAddr = req.getParameter("cusAddr");
      String cusPw = req.getParameter("cusPw");
      String cusAct="Y";
     

      
      // 서비스 객체 생성
      ICustomerService cusService = CustomerServiceImpl.getInstance();
     
      IFileService fileService = FileServiceImpl.getInstance();
 
      try {
    	  filePath = fileService.saveFile(req);
      }catch(Exception e) {
    	  e.printStackTrace();
      }
      
      CustomerVO cv = new CustomerVO(cusId, cusName, cusTel, cusAddr, cusPw, filePath, cusAct);
  
      // 회원 정보 등록하기
      int cnt = cusService.registCustomer(cv);
      
      String msg = "";
      
      if(cnt > 0) {
         // 성공
    	  msg = "성공";
      }else {
         // 실패..
    	  msg = "실패";
      }
    	
      req.getSession().setAttribute("msg", msg);
      
      resp.sendRedirect(req.getContextPath() + "/mainpage.do");
           
   }
   
}



