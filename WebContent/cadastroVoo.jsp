<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="cadastrovoo.css" rel="stylesheet" type="text/css" >
</head>
<body>
 
	
	<c:import url="Header.jsp"></c:import>
	<form action="" method="post" >
	<div class="containerVoo" style="height: fit-content%!important;">

		<div class="voo">
			 <label for="cidadeOrigem">Cidade Origem</label> 
			<select class="selector" id="cidadeOrigem" name="cidadeOrigem">
				<option value="-">-</option>
				
				<c:forEach begin="1" end="5" var="item">
					<option value="${item}"><c:out value="${item}"></c:out> </option>
				</c:forEach>
				
			</select> 
			
			
			<label for="cidadeDestino">Cidade Destino</label> 
			 <select class="selector" id="cidadeDestino" name="cidadeDestino">
				<option value="-">-</option>
				
				<c:forEach begin="1" end="5" var="item">
					<option value="${item}"><c:out value="${item}"></c:out> </option>
				</c:forEach>
				
			</select> 
			
			
			
			<label for="aviao">Avião</label> 
			<select class="selector" id="aviao"  name="avião" disabled>
				<option value="-">-</option>
				<option value="domestico">Doméstico</option>
				<option value="internacional">Internacional</option>
			</select>
				
			<label for="data" >Data</label> 
			<input type="date" id="data" name="data" disabled >
			
			<label for="horaSaida">Hora Prevista de saida</label> 
			<input type="time" value="horaSaida" id="horaSaida"  name="horaSaida" disabled >
			
			<label for="horaChegada">Hora Prevista de Chegada</label> 
			<input type="time" value="horaChegada" id="horaChegada" name="horaChegada" disabled>

			
			
		</div>

		<div class="escalas">
		
			<label for="escala2">Escala 1</label>
			<select class="selector" id="escala1" id="escala1" disabled>
				<option value="-">-</option>
				
				<c:forEach begin="1" end="5" var="item">
					<option value="${item}"><c:out value="${item}"></c:out> </option>
				</c:forEach>
				
			</select>
			
			<label for="escala2">Escala 2</label>
			<select class="selector" id="escala2" name="escala2" disabled>
				<option value="-">-</option>
				
				<c:forEach begin="1" end="5" var="item">
					<option value="${item}"><c:out value="${item}"></c:out> </option>
				</c:forEach>
				
			</select>
			 
			<label for="nome-aviao">Escala 3</label> 
			<select class="selector" id="escala3" name="escala3" disabled>
				<option value="-">-</option>
				
				<c:forEach begin="1" end="5" var="item">
					<option value="${item}"><c:out value="${item}"></c:out> </option>
				</c:forEach>
				
			</select>
		
		</div>
	
	</div>
		
		<input type="submit" value="cadastrar" class="btn btn-primary">
	</form>
	
	<!-- não quer puxar o js externo NÃO FAZER ESSA COISA HORRÍVEL PFVR -->
	<script type="text/javascript">
	
	var input = document.querySelector('#cidadeOrigem');
	var input2 = document.querySelector('#cidadeDestino');

	input.addEventListener('change',function enableInput(event) {
				if (($("#cidadeOrigem").val() != "-")&& ($("#cidadeDestino").val() != "-")) {
					$('#data').prop("disabled", false);
					console.log("asdasd");
					removeDisbled();
				}
			});

	input2.addEventListener('change',function enableInput(event) {
				if (($("#cidadeOrigem").val() != "-")&& ($("#cidadeDestino").val() != "-")) {
					removeDisbled();
				}
			});


	function removeDisbled(){
		$('#data').prop("disabled", false),
		$('#horaSaida').prop("disabled", false),
		$('#horaChegada').prop("disabled", false),
		$('#aviao').prop("disabled", false),
		$('#escala1').prop("disabled", false),
		$('#escala2').prop("disabled", false),
		$('#escala3').prop("disabled", false);
		
	}
	
	$(document).ready(function() {
		  $(window).keydown(function(event){
		    if(event.keyCode == 13) {
		      event.preventDefault();
		      return false;
		    }
		  });
		});
	</script>
	
</body>
</html>