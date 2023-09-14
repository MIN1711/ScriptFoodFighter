package customer.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customer.service.CustomerServiceImpl;
import customer.service.FileServiceImpl;
import customer.service.ICustomerService;
import customer.service.IFileService;
import customer.vo.CustomerVO;

@MultipartConfig
@WebServlet("/customer/update.do") // servletTest에 web.xml(<servlet></servlet>썼던거 대신 씀 )
public class UpdateCustomerController extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      String cusId = req.getParameter("cusId");
      
      ICustomerService cusService = CustomerServiceImpl.getInstance();
         
      IFileService fileService = FileServiceImpl.getInstance();
      
      CustomerVO cv = cusService.getCustomer(cusId);
      
      req.setAttribute("cv", cv);
      
      RequestDispatcher dispatcher = req.getRequestDispatcher(
                           "/WEB-INF/views/customer/updateForm.jsp");
      dispatcher.forward(req,resp);
      
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
         
         
         // 서비스 객체 생성
         IFileService fileService = FileServiceImpl.getInstance();
         
         
            try {
               // 첨부파일 경로 저장
               filePath = fileService.saveFile(req);
            } catch (Exception e) {
               e.printStackTrace();
            }
         CustomerVO cv = new CustomerVO(cusId, cusName, cusTel, cusAddr, cusPw, filePath, cusAct);
         
         
         // 회원 정보 수정하기
         int cnt = cusService.modifyCustomer(cv);
         
         String msg = "";
         
         if(cnt > 0) {
            // 성공
            msg = "성공";
            CustomerVO loginId = cusService.loginChk(cv);
            req.getSession().setAttribute("loginId", loginId);
         }else {
            // 실패..
            msg = "실패";
         }
          
         req.getSession().setAttribute("msg", msg);
         
         resp.sendRedirect(req.getContextPath() + "/customer/detail.do?cusId="+ URLEncoder.encode(cusId, "UTF-8"));
   }
   
   }