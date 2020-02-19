<%@page import="java.util.List"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@page import="br.com.rocketAirlines.modelo.Cidade"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/cadastrovoo.css" rel="stylesheet" type="text/css" >
    <style type="text/css">
		<%@ include file="/css/cadastrovoo.css" %>  
	</style>
</head>
<body>
 
 	
 	<input type="hidden" id="placeholderCidades" value="${ arrayCidades }">
	<c:import url="Header.jsp"></c:import>
	<form action="CadastraVoo" method="post" >
	<div class="containerVoo" style="height: fit-content%!important;">

		<div class="voo">
			 <label for="cidadeOrigem">Cidade Origem</label> 
			<select class="selector" id="cidadeOrigem" name="cidadeOrigem">
				<option value="-">-</option>
				
				<c:forEach items="${ cidades }" var="cidade">
					<option value="${cidade.toString()}"><c:out value="${cidade.toString()}"></c:out> </option>
				</c:forEach>
				
			</select> 
			
			<label for="cidadeDestino">Cidade Destino</label> 
			 <select class="selector" id="cidadeDestino" name="cidadeDestino">
				<option value="-">-</option>
				
				<c:forEach items="${ cidades }" var="cidade">
					<option value="${cidade.toString()}"><c:out value="${cidade.toString()}"></c:out> </option>
				</c:forEach>
				
			</select> 
				
			<label for="aviao">Avião</label> 
			<select class="selector" id="aviao"  name="aviao" disabled>
				<option value="-">-</option>
				<c:forEach items="${avioes}" var="aviao">
					<option value="${aviao.toString()}"><c:out value="${aviao.toString()}"></c:out> </option>
				</c:forEach>
			</select>
				
			<label for="dataSaida" >Data Saida</label> 
			<input type="date" id="dataSaida" name="dataSaida" disabled >
			
			<label for="dataChegada" >Data Chegada</label> 
			<input type="date" id="dataChegada" name="dataChegada" disabled >
			
			<label for="horaSaida">Hora Prevista de saida</label> 
			<input type="time" value="horaSaida" id="horaSaida"  name="horaSaida" disabled >
			
			<label for="horaChegada">Hora Prevista de Chegada</label> 
			<input type="time" value="horaChegada" id="horaChegada" name="horaChegada" disabled>
			
		</div>

		<div class="escalas">
		
			<label for="escala2">Escala 1</label>
			<select class="selector" id="escala1" name="escala1" disabled>
				<option value="-">-</option>
				
				<c:forEach items="${ cidades }" var="cidade">
					<option value="${cidade.toString()}"><c:out value="${cidade.toString()}"></c:out> </option>
				</c:forEach>
				
			</select>
			
			<label for="escala2">Escala 2</label>
			<select class="selector" id="escala2" name="escala2" disabled>
				<option value="-">-</option>
				
				<c:forEach items="${ cidades }" var="cidade">
					<option value="${cidade.toString()}"><c:out value="${cidade.toString()}"></c:out> </option>
				</c:forEach>	
			</select>
			 
			<label for="nome-aviao">Escala 3</label> 
			<select class="selector" id="escala3" name="escala3" disabled>
				<option value="-">-</option>
				
				<c:forEach items="${ cidades }" var="cidade">
					<option value="${cidade.toString()}"><c:out value="${cidade.toString()}"></c:out> </option>
				</c:forEach>
				
			</select>
		
		</div>
	
	</div>
		
		<input type="submit" value="cadastrar" class="btn btn-primary">
	</form>
	
	<script type="text/javascript">
	
	 <%@ include file="/js/cadastroVoo.js" %>  

	</script>
		<%
 		String CitiesConcat ="";
 		List<Cidade> cities =(List<Cidade>)pageContext.getAttribute("cidades");
 		pageContext.setAttribute("arrayCidades", cities);
 	%>
	
</body>
</html>