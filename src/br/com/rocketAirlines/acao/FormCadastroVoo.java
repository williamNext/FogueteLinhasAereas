package br.com.rocketAirlines.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.fluent.Request;

import com.google.gson.reflect.TypeToken;

import br.com.rocketAirlines.modelo.Aviao;
import br.com.rocketAirlines.modelo.Cidade;
import br.com.rocketAirlines.util.JsonConverter;
import br.com.rocketAirlines.util.WebHelper;

public class FormCadastroVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String jsonCidades = WebHelper.GetJson("http://localhost:8080/taqui/listaCidades");
		String jsonAvioes = WebHelper.GetJson("http://localhost:8080/taqui/listaAvioes");
		
		Object cidades = JsonConverter.fromJson(jsonCidades, new TypeToken<List<Cidade>>(){}.getType());
		Object avioes = JsonConverter.fromJson(jsonAvioes, new TypeToken<List<Aviao>>(){}.getType());
		
		request.setAttribute("cidades", cidades);
		request.setAttribute("avioes", avioes);
		
		return "forward:cadastroVoo.jsp";
	}

}
