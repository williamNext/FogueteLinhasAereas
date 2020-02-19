package br.com.rocketAirlines.webservice;

import java.io.BufferedReader;
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

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		BufferedReader reader = request.getReader();
		String readLine = null;
		StringBuffer json = new StringBuffer(); 
		
		while((readLine = reader.readLine()) != null) {
			json.append(readLine);
		}
		
		Aviao aviao = JsonConverter.fromJson(json.toString(), Aviao.class);
		
		if (aviaoDAO.add(aviao)) {
			response.setStatus(200);
			return;
		}

		response.setStatus(500);
	}
}
