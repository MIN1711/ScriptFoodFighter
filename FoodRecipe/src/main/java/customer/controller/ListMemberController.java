package customer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.service.CustomerServiceImpl;
import customer.service.ICustomerService;
import customer.vo.CustomerVO;


@WebServlet(value = "/customer/list.do")
public class ListMemberController extends HttpServlet{
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
      // 1. 서비스 객체 생성하기
      ICustomerService cusService = CustomerServiceImpl.getInstance();
      
      // 2. 회원정보 조회
      List<CustomerVO> cusList = cusService.displayAllCustomer();
      
      // 3. 화면 출력을 위한 데이터 저장
      req.setAttribute("cusList", cusList);
      
      // 4. 해당 화면으로 포워딩
      req.getRequestDispatcher("/WEB-INF/views/customer/list.jsp").forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req, resp);
   }
}