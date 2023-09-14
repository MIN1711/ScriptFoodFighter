
<%@page import="customer.vo.CustomerVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
CustomerVO login = (CustomerVO)request.getAttribute("res");
	if(login != null ) {
		// 성공 결과 
%>		{"rs" : "OK", "cusId":"<%=login.getcusId()%>"}
<% 	}else{// 실패결과
%>		{"rs" : "입력하신 정보가 일치하지 않습니다." }
<% 	}
%>	