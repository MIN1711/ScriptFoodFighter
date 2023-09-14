
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%

String res= (String)request.getAttribute("resid");

	 
	if(res != null){
		//값 존재시 사용불가 코드 생성 - json데이터
%>
		{
			"code" : "fail",
			"msg" : "사용불가"
			
		}
<%
	}else {
		//사용가능 코드 생성
%>
		{
			"code" : "ok",
			"msg" : "사용가능"
		}
<%
	}
%>