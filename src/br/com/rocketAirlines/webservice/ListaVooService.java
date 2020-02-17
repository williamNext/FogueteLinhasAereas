package br.com.rocketAirlines.webservice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.dao.VooDAO;
import br.com.rocketAirlines.modelo.Voo;
import br.com.rocketAirlines.util.JsonConverter;

@WebServlet("/listaVoo")
public class ListaVooService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private VooDAO vooDAO = VooDAO.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Voo> lista = vooDAO.getLista();
		
		String json = JsonConverter.toJson(lista);
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

}
