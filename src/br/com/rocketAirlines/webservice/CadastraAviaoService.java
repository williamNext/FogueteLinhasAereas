package br.com.rocketAirlines.webservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.dao.AviaoDAO;
import br.com.rocketAirlines.modelo.Aviao;
import br.com.rocketAirlines.util.JsonConverter;

@WebServlet("/cadastraAviao")
public class CadastraAviaoService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final AviaoDAO aviaoDAO = AviaoDAO.getInstance();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String json = request.getReader().readLine();

		Aviao aviao = JsonConverter.fromJson(json, Aviao.class);
		aviaoDAO.add(aviao);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		// response.getWriter().print("Inserido");
		response.setStatus(200);
	}

}
