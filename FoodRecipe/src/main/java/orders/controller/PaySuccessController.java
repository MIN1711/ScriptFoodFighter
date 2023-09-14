package orders.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customer.vo.CustomerVO;
import orders.service.IOrdersService;
import orders.service.IPaymentService;
import orders.service.OrdersServiceImpl;
import orders.service.PaymentServiceImpl;
import orders.vo.OrdersVO;
import orders.vo.PaymentVO;

@WebServlet("/orders/success.do")
public class PaySuccessController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CustomerVO cus = (CustomerVO) req.getSession().getAttribute("loginId");
		String cusId = cus.getcusId();
		
		IOrdersService ordersService = OrdersServiceImpl.getInstance();
		IPaymentService payService = PaymentServiceImpl.getInstance();
		
		int oNo = ordersService.getOno(cusId); // 결제중인 주문번호 -> 결제 N인 가장 최근 주문번호
		
		int mPayCode = Integer.parseInt(req.getParameter("mPayCode")); // 결제수단 코드
		
		OrdersVO ov = new OrdersVO();
		PaymentVO pv = new PaymentVO();
		
		ordersService.orderPaid(oNo); // 주문상태 Y로 변경
		int money = ordersService.getMoney(oNo); // 주문의 가격
		
		// 결제정보 저장
		pv.setoNo(oNo); // 주문번호
		pv.setPayMoney(money); //가격
		pv.setmPayCode(mPayCode); //결제수단
		
		payService.paysuccess(pv);
		
		resp.sendRedirect(req.getContextPath() + "/customer/mybuylist.do?cusId=" + cusId);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

}
