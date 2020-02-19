package br.com.rocketAirlines.webservice;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.dao.VooDAO;
import br.com.rocketAirlines.modelo.Voo;
import br.com.rocketAirlines.util.JsonConverter;

@WebServlet("/cadastraVoo")
public class CadastraVooService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private final VooDAO vooDAO = VooDAO.getInstance();

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
		
		Voo voo = JsonConverter.fromJson(json.toString(), Voo.class);
		
		if(vooDAO.add(voo)) {
			response.setStatus(200);
			return;
		}

		response.setStatus(500);
	}
}
