package br.com.rocketAirlines.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.dao.CidadeDAO;
import br.com.rocketAirlines.modelo.Cidade;
import br.com.rocketAirlines.util.JsonConverter;

@WebServlet("/listaCidades")
public class ListaCidadeService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final CidadeDAO cidadeDAO = CidadeDAO.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Cidade> cidades = cidadeDAO.getLista();
		String json = JsonConverter.toJson(cidades);
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
	}

}
