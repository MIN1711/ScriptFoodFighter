<%@page import="customer.vo.CustomerVO"%>
<%@page import="orders.vo.OrdersVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	OrdersVO ov = (OrdersVO) request.getAttribute("ov");
CustomerVO cus = (CustomerVO) request.getSession().getAttribute("loginId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pay</title>
<style type="text/css">

#kakao{
width: 280px; 
height: 400px;
border: none;
}

#kgpay{
width: 280px; 
height: 400px;
border: none;
}
#kaoimg{
width: 280px; 
height: 400px;
margin-left: -10px;
}
#kgimg{
width: 280px; 
height: 400px;
margin-left: -7px;
border: solid 1px ;
/* margin-bottom: 25px; */
}
* {
margin: 0px;
}
.cont {
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
}
.box {
	text-align: center;
}


<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">

</style>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
<script>
        var IMP = window.IMP;
        IMP.init("imp83030357");

        function requestkakaoPay() {
            IMP.request_pay({
                pg: 'kakaopay.TC0ONETIME',
                pay_method: 'card',
                merchant_uid: 'merchant_' + new Date().getTime(),
                name: '주문번호<%=ov.getoNo()%>',
                amount: <%=ov.getoMoney()%>,
                buyer_email: 'Iamport@chai.finance',
                buyer_name: '<%=cus.getcusName()%>',
                buyer_tel: '<%=cus.getcusTel()%>',
                buyer_addr: '<%=cus.getcusAddr()%>',
                buyer_postcode: '123-456'
            }, function (rsp) {
                if (rsp.success) {  // 결제가 성공했을 떄
                    // 결제가 완료되었을 떄 결제 정보를 뜨게 만듬
                    var msg = '결제가 완료되었습니다.';
                    msg += '고유ID : ' + rsp.imp_uid;
                    msg += '상점 거래ID : ' + rsp.merchant_uid;
                    msg += '결제 금액 : ' + rsp.paid_amount;
                    msg += '카드 승인번호 : ' + rsp.apply_num;
                    alert(msg);
                    opener.parent.location="/FoodRecipe/orders/success.do?mPayCode=120"; window.close();

                } else {    // 결제가 실패했을 때
                    // 결제에 실패했을떄 실패메세지와 실패사유를 출력
                    var msg = '결제에 실패하였습니다.';
                    msg += '실패 사유 : ' + rsp.error_msg;
                    alert(msg);
                    opener.parent.location="/FoodRecipe/orders/cart.do"; window.close();
                }

            });
        };
        
        function requestKGPay() {
        	IMP.request_pay({
        	    pg : 'html5_inicis.INIBillTst',
        	    pay_method : 'INIBillTst',
        	    merchant_uid: 'merchant_' + new Date().getTime(),
        	    name : '주문번호<%=ov.getoNo()%>',
        	    amount : <%=ov.getoMoney()%>,
        	    buyer_email : 'iamport@siot.do',
        	    buyer_name : '<%=cus.getcusName()%>',
        	    buyer_tel : '<%=cus.getcusTel()%>',
        	    buyer_addr : '<%=cus.getcusAddr()%>',
							buyer_postcode : '123-456',
						},
						function(rsp) {
							if (rsp.success) { // 결제가 성공했을 떄
								// 결제가 완료되었을 떄 결제 정보를 뜨게 만듬
								var msg = '결제가 완료되었습니다.';
								msg += '고유ID : ' + rsp.imp_uid;
								msg += '상점 거래ID : ' + rsp.merchant_uid;
								msg += '결제 금액 : ' + rsp.paid_amount;
								msg += '카드 승인번호 : ' + rsp.apply_num;
								alert(msg);
								opener.parent.location = "/FoodRecipe/orders/success.do?mPayCode=120";
								window.close();

							} else { // 결제가 실패했을 때
								// 결제에 실패했을떄 실패메세지와 실패사유를 출력
								var msg = '결제에 실패하였습니다.';
								msg += '실패 사유 : ' + rsp.error_msg;
								alert(msg);
								opener.parent.location = "/FoodRecipe/orders/cart.do";
								window.close();
							}
						});
	};
</script>

</head>

<body>
<div class="cont">
<div class="box">
<table>
<tr>
<td>
	<button id="kakao" onclick="requestkakaoPay()"><img id="kaoimg" alt="카카오페이" src="/FoodRecipe/images/kapay.jpg" ></button>
	<p style="text-align:center;">카카오페이</p>
</td>
<td>
	<button id="kgpay" onclick="requestKGPay()"><img id="kgimg" alt="KG이니시스" src="/FoodRecipe/images/kgimg.png" ></button>
	<p style="text-align:center;">카드결제</p>
</td>
</tr>
</table>
</div>
</div>
</body>

</html>