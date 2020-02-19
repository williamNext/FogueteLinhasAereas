<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Voos</title>
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
		<div class="tableContainer" style="overflow-x: scroll !important;">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">N° Voo</th>
						<th scope="col">Origem</th>
						<th scope="col">Destino</th>
						<th scope="col">Data e Hora Saida</th>
						<th scope="col">Data e Hora Chegada</th>
						<th scope="col">Avião</th>
						<th scope="col">Escalas</th>
					</tr>
				</thead>
				<c:forEach items="${voos}" var="voo">
					<tr>
						<td>${voo.id}</td>
						<td>${voo.rota.origem.nome}</td>
						<td>${voo.rota.destino.nome}</td>	
						<td><fmt:formatDate value="${voo.dataHoraPartida}" pattern="dd/MM/yyyy HH:mm"/></td>
						<td><fmt:formatDate value="${voo.dataHoraChegada}" pattern="dd/MM/yyyy HH:mm"/></td>
						<td>${voo.aviao.nome}, ${voo.aviao.modelo}</td>
						<td>${voo.getEscalasAsString()}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>