<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="listavoo.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<c:import url="Header.html"></c:import>
	<div class="mainContainer">
		<div class="tableTitle">
			<h3>Lista de Voos</h3>
		</div>

		<div class="tableContainer" style="overflow-x:scroll !important;">

			<%  %>
			<table class="table">
				<thead class="thead-dark" >
					<tr>
						<th scope="col">N� Voo</th>
						<th scope="col">Origem</th>
						<th scope="col">Destino</th>
						<th scope="col">Data</th>
						<th scope="col">Hora Saida</th>
						<th scope="col">Hora Chegada</th>
						<th scope="col">Avi�o</th>
						<th scope="col">Escalas</th>
					</tr>
				</thead>
				<tr>
					<td>1</td>
					<td>S�o Paulo, SP</td>
					<td>Paris, FR</td>
					<td>02/08/2020</td>
					<td>08:00</td>
					<td>19:00</td>
					<td>Boeing 747</td>
					<td>sem escalas</td>
				<c:forEach items="${avioes}" var="aviao"></c:forEach>
				</tr>
				
				<% 
					List<Integer> num = new ArrayList<Integer>();
					 for(int i=0; i<100;i++){
						 num.add(i);
					 }
					
					 
					  pageContext.setAttribute("num", num);
				%>
				
				
				<!-- 
				
				 -->
				<c:forEach items="${num}" var="num" >
					
				<tr>
					<td>${num}</td>
					<td>${num}</td>
					<td>${num}</td>
					<td>${num}</td>
					<td>${num}</td>
					<td>${num}</td>
					<td>${num}</td>
					<td>${num}</td>
					
				
				</tr>
					
				</c:forEach>
				
			</table>


		</div>
	</div>
</body>
</html>