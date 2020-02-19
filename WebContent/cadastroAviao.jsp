<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Avião</title>

<link href="cadastroAviao.css" rel="stylesheet" type="text/css" />

	<style type="text/css">
		<%@ include file="/css/cadastroAviao.css" %>  
	</style>
</head>
<body>
	<c:import url="Header.jsp"></c:import>

	<form action="CadastraAviao" method="post">
		<div class="container">

			<label for="nome-aviao">Nome do Avião</label> <input type="text"
				id="nome-aviao" name="nome"> <label for="modelo-aviao">Modelo
				do Avião</label> <input type="text" id="modelo-aviao" name="modelo">

			<label for="tipo-aviao">Tipo do Avião</label> <select
				class="selector" id="tipo-aviao" name="tipo">
				<option value="vazio">-</option>
				<option value="domestico">DOMÉSTICO</option>
				<option value="internacional">INTERNACIONAL</option>
			</select>

		</div>
		<input class="btn btn-primary" type="submit" value="cadastrar">
	</form>
	

</body>
</html>