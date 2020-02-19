package br.com.rocketAirlines.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.reflect.TypeToken;

import br.com.rocketAirlines.modelo.Voo;
import br.com.rocketAirlines.util.JsonConverter;
import br.com.rocketAirlines.util.WebHelper;

public class ListaVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String conteudo = WebHelper.GetJson("http://localhost:8080/taqui/listaVoos");

		Object lista = JsonConverter.fromJson(conteudo, new TypeToken<List<Voo>>() {}.getType());
		request.setAttribute("voos", lista);

		return "forward:listaVoos.jsp";
	}
}