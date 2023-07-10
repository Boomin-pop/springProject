<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>                                         
<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css' rel='stylesheet'>       
<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'></script>         
</head>
<body>
<div class="container w-70 h-70 border m-auto mt-5">
<h3 class="text-center mt-5 mb-5">스프링 게시판</h3>
<table class="table mt-5">
   <thead>
      <tr>
         <th>번호</th>
         <th>제목</th>
         <th>조회수</th>
         <th>글쓴이</th>
         <th>등록일</th>
      </tr> 
   </thead>
   <tbody>
      <c:forEach var="dto" items="${list}">
		<tr>
         <td>${dto.bid}</td>
      <%--    <td><a href="boardRead.do?bid="${list.getBid}">${list.getSubject}</a></td> --%>
      	 <td>${dto.subject}</td>
         <td>${dto.hit}</td>
         <td>${dto.writer}</td>
         <td>${dto.reg_date}</td>
      </tr>
      </c:forEach>
      <tr>
         <td colspan="5" class="text-center">
         	<a href="register.do" class="btn btn-primary mt-5" id="btn-write">글쓰기</a>
         </td>
      </tr>
   </tbody>
</table>
</div>
</body>