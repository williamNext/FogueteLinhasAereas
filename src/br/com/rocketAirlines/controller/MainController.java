//package br.com.rocketAirlines.controller;
//
//import java.io.IOException;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import br.com.rocketAirlines.acao.Acao;
//
///**
// * Servlet implementation class MainController
// */
//@WebServlet("/")
//public class MainController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	@Override
//    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       
//       
//        System.out.println(request.getRequestURI());
//        response.getWriter().print("Entrando...");
//       
//       
//        String className = "acao." + getAcao(request.getRequestURI());
//        String nome = null;
//       
//        try {
//            Class classe = Class.forName(className);//carrega a classe com o nome
//            Acao acao = (Acao) classe.newInstance();
//            nome = acao.executa(request,response);
//        } catch (Exception e) {
//           
//        }
//       if(nome != null) {
//    	   String[] tipoEndereco = nome.split(":");
//           
//    	   if(tipoEndereco[0].equals("forward")) {
//               RequestDispatcher rd = request.getRequestDispatcher("/" + tipoEndereco[1]);
//               rd.forward(request, response);
//           } else if (tipoEndereco[0].equals("redirect")){
//               response.sendRedirect(tipoEndereco[1]);
//           }
//       }
//    }
//   
//    private String getAcao(String url) {
//        if(url == null || url.isEmpty()) {
//           
//        }
//       
//        String[] split = url.split("/");
//        return split[split.length-1];
//    }
//
//}