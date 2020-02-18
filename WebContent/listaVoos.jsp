<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
 <%@page import="br.com.rocketAirlines.modelo.Voo"%>   
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href=" ">
	
	<style type="text/css">
			<%@ include file="/css/listavoo.css" %>  
	</style>
</head>
<body>

	<c:import url="Header.jsp"></c:import>
	<div class="mainContainer">
		<div class="tableTitle">
			<h3>Lista de Voos</h3>
		</div>

		<div class="tableContainer" style="overflow-x:scroll !important;">

			<%  %>
			<table class="table">
				<thead class="thead-dark" >
					<tr>
						<th scope="col">N° Voo</th>
						<th scope="col">Origem</th>
						<th scope="col">Destino</th>
						<th scope="col">Data</th>
						<th scope="col">Hora Saida</th>
						<th scope="col">Hora Chegada</th>
						<th scope="col">Avião</th>
						<th scope="col">Escalas</th>
					</tr>
				</thead>
				<tr>
					<td>1</td>
					<td>São Paulo, SP</td>
					<td>Paris, FR</td>
					<td>02/08/2020</td>
					<td>08:00</td>
					<td>19:00</td>
					<td>Boeing 747</td>
					<td>sem escalas</td>
				</tr>
				

				
				
				<!-- 
				
				 -->
				<c:forEach items="${voos}" var="num" >
					
				<tr>
					<td>${num.id}</td>

					
				
				</tr>
					
				</c:forEach>
				
			</table>


		</div>
	</div>
</body>
</html>