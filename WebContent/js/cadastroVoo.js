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