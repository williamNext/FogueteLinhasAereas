package br.com.rocketAirlines.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.modelo.Cidade;
import br.com.rocketAirlines.modelo.Database;

public class CadastraVoo implements Acao {

	@SuppressWarnings("unchecked")
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		Calendar saida = (Calendar) request.getAttribute("saida");
//		Calendar chegada = (Calendar) request.getAttribute("chegada");
//		
//		
//		String origem = request.getParameter("origem");
//		String [] origemSplit = origem.split(",");
//		Cidade cidadeOrigem = new Cidade(origemSplit[0],new Pais(origemSplit[1]));
//		
//		
//		String destino = request.getParameter("destino");
//		String [] destinoSplit = destino.split(",");
//		Cidade cidadeDestino = new Cidade(destinoSplit[0],new Pais(destinoSplit[1]));
//		
//		Rota rota = new Rota(cidadeOrigem,cidadeDestino);
//		
//		Voo voo = new Voo();
////		VooDAO vooDAO = new VoodAO();		
//		
//		Cidade escala1 = new Cidade();
//		
////		List<Cidade> escalas = new ArrayList<Cidade>();
//		
//		if (request.getParameter("escala1") != "0") {
//			
//			String escala1 = request.getParameter("escala1");
//			String [] escala1Split = destino.split(",");
//			Cidade cidadeeEscala1 = new Cidade(destinoSplit[0],new Pais(destinoSplit[1]));
//			//escalas.add(new Cidade(destinoSplit[0],new Pais(destinoSplit[1])));
//			
//			escalas.add((Cidade) request.getAttribute("escala1"));
//			if (request.getParameter("escala2") != "0") {
//				escalas.add((Cidade) request.getAttribute("escala2"));
//				
//				if (request.getParameter("escala3") != "0") {
//					escalas.add((Cidade) request.getAttribute("escala3"));
//				}
//			}
//		} else {
//			escalas = null;
//		}
		Database database = new Database();
		
		List<Cidade> cidades = database.getCidades();
		
		request.setAttribute("cidades", cidades);
		
		return "forward:cadastroVoo.jsp";
	}

}
