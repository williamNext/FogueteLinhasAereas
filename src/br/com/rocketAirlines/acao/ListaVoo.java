package br.com.rocketAirlines.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.fluent.Request;

import br.com.rocketAirlines.modelo.Voo;
import br.com.rocketAirlines.util.JsonConverter;

public class ListaVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Requesfdsa");
		
		String conteudo = Request
			.Get("http://localhost:8080/rocketAirlines/listaVoo")
			.execute()
			.returnContent()
			.asString();
		System.out.println("Requesfdsa6.5512");
		Voo voos = JsonConverter.fromJson(conteudo, Voo.class);
		
//		VooDAO vooDAO = new VooDAO();		
//		List<Voo> lista = vooDAO.getVoo();

//		request.setAttribute("voos", lista);

		return "forward:listaVoos.jsp";
	}
}