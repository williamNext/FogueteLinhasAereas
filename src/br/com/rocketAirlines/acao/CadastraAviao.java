package br.com.rocketAirlines.acao;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.modelo.Aviao;
import br.com.rocketAirlines.modelo.TipoAviao;
import br.com.rocketAirlines.util.JsonConverter;
import br.com.rocketAirlines.util.WebHelper;

public class CadastraAviao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Aviao aviao = new Aviao();
		aviao.setNome(request.getParameter("nome"));
		aviao.setModelo(request.getParameter("modelo"));
		String tipo = request.getParameter("tipo");
		
		if(tipo.equals("domestico")) {
			aviao.setTipo(TipoAviao.Domestico);
		}
		else if(tipo.equals("internacional")) {
			aviao.setTipo(TipoAviao.Internacional);
		}

		String json = JsonConverter.toJson(aviao);
		WebHelper.PostJson("http://localhost:8080/taqui/cadastraAviao", json);
		
		return "redirect:FormCadastroAviao";
	}
}