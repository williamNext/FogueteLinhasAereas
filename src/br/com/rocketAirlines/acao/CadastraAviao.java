package br.com.rocketAirlines.acao;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.modelo.Aviao;
import br.com.rocketAirlines.modelo.TipoAviao;

public class CadastraAviao implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Aviao aviao = new Aviao();
//		AviaoDAO aviaoDAO = new AviaoDAO();

		String nomeAviao = request.getParameter("nome");
		String modeloAviao = request.getParameter("modelo");
		TipoAviao tipoVoo = (TipoAviao) request.getAttribute("tipoVoo");

//		aviaoDAO.add(aviao);

		return "redirect:entrada?acao=ListaEmpresas";
	}
}