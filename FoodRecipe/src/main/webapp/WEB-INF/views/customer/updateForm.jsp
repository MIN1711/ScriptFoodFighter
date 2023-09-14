

<%@page import="customer.vo.CustomerVO"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%
   CustomerVO cv = (CustomerVO) request.getAttribute("cv");
/* List<CustomerVO> custList = (List<CustomerVO>) request.getAttribute("custList"); */


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 변경</title>
<link href="../images/cook.png" rel="shortcut icon" type="image/x-icon">
<%@include file="/header.jsp"%>
 <style>
body {
  padding:1.5em;
  background: #f5f5f5
}

table {
  border: 1px #a39485 solid;
  font-size: .9em;
  box-shadow: 0 2px 5px rgba(0,0,0,.25);
/*   width: 100%; */
  border-collapse: collapse;
  border-radius: 5px;
  overflow: hidden;
}

th {
  text-align: left;
}
  
thead {
  font-weight: bold;
  color: #fff;
  background: #73685d;
}
  
 td, th {
  padding: 1em .5em;
  vertical-align: middle;
}
  
 td {
  border-bottom: 1px solid rgba(0,0,0,.1);
  background: #fff;
}

a {
  color: #73685d;
}
  
 @media all and (max-width: 768px) {
    
  table, thead, tbody, th, td, tr {
    display: block;
  }
  
  th {
    text-align: right;
  }
  
  table {
    position: relative;  
    padding-bottom: 0;
    border: none;
    box-shadow: 0 0 10px rgba(0,0,0,.2);
    margin-left:auto; 
    margin-right:0;
    
  }
  
  thead {
    float: left;
    white-space: nowrap;
  }
  
  tbody {
/*     overflow-x: auto; */
    overflow-y: hidden;
    position: relative;
    white-space: nowrap;
  }
  
  tr {
    display: inline-block;
    vertical-align: top;
  }
  
  th {
    border-bottom: 1px solid #a39485;
  }
  
  td {
    border-bottom: 1px solid #e5e5e5;
  }
  }
  
  .upd {
     font-weight: bold;
  padding: 50px;
  margin-left: 38%;
  margin-right: 0;
  }


 </style>
</head>
 <body>
 
<div class="upd">
<h3><%=cv.getcusId()%>님의 정보 수정</h3>

<table>
<thead>
<tr>
<th>
<form action="update.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="cusId" value="<%=cv.getcusId()%>">
</th>
<th>
<input type="hidden" name="atchFileId" value="<%=cv.getcusImg()%>"> 
</th>
</tr>
</thead> 

<tbody>
<tr>
<td>닉네임</td>
<td><%=cv.getcusId()%></td>
</tr>
<tr>
<td>이름</td>
<td><input type="text" name="cusName"
               value="<%=cv.getcusName()%>"></td>
</tr>
<tr>
<td>전화번호</td>
<td><input type="text" name="cusTel"
               value="<%=cv.getcusTel()%>"></td>
</tr>
<tr>
<td>주소</td>
<td>
<textarea name="cusAddr"><%=cv.getcusAddr()%></textarea></td>
</tr>
<tr>
<td>비밀번호</td>
<td><input type="text" name="cusPw"
               value="<%=cv.getcusPw()%>"></td>

<tr>
            <td>프로필 이미지</td>
            <td><input type="file" name="cusImg" multiple="multiple">
            </td>
         </tr> 
          <tr align="center">
         <td colspan="2">
         
             <input type="submit" value="저장" >   
         <input type="button" value="취소" onClick="location.href='./detail.do?cusId=<%=cv.getcusId() %>'">
         </tr> 
</tbody>
</table>
</div>
</form>
</body>
</html>