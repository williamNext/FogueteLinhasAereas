package br.com.rocketAirlines.webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.dao.AviaoDAO;
import br.com.rocketAirlines.modelo.Aviao;
import br.com.rocketAirlines.util.JsonConverter;

@WebServlet("/listaAvioes")
public class ListaAviaoService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final AviaoDAO aviaoDAO = AviaoDAO.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Aviao> lista = aviaoDAO.getLista();
		String json = JsonConverter.toJson(lista);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
	}
}
