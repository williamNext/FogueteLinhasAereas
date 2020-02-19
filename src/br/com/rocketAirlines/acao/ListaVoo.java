package br.com.rocketAirlines.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.fluent.Request;

import com.google.gson.reflect.TypeToken;

import br.com.rocketAirlines.modelo.Voo;
import br.com.rocketAirlines.util.JsonConverter;

public class ListaVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String conteudo = Request
			.Get("http://localhost:8080/taqui/listaVoos")
			.execute()
			.returnContent()
			.asString();
		
		Object lista = JsonConverter.fromJson(conteudo, new TypeToken<List<Voo>>(){}.getType());
		request.setAttribute("voos", lista);		

		return "forward:listaVoos.jsp";
	}
}