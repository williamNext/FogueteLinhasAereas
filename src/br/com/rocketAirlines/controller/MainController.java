package br.com.rocketAirlines.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.acao.Acao;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String className = "br.com.rocketAirlines.acao." + getAcao(request.getRequestURI());
		String nome = null;

		try {
			Class classe = Class.forName(className);
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException e){
			System.out.println("Classe não encontrada: " + e.getMessage());
			return;
		} catch (Exception e) {
			System.out.println("Erro desconhecido: " + e.getMessage());
			return;
		}

		String[] tipoEndereco = nome.split(":");

		if (tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else if (tipoEndereco[0].equals("redirect")) {
			response.sendRedirect(tipoEndereco[1]);
		}
	}

	private String getAcao(String url) {
		if (url == null || url.isEmpty()) {
			return null;
		}

		String[] split = url.split("/");
		return split[split.length - 1];
	}

}