package br.com.rocketAirlines.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rocketAirlines.modelo.Aviao;
import br.com.rocketAirlines.modelo.Cidade;
import br.com.rocketAirlines.modelo.Database;
import br.com.rocketAirlines.modelo.Rota;
import br.com.rocketAirlines.modelo.TipoAviao;
import br.com.rocketAirlines.modelo.Voo;

public class SalvaVoo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        Aviao aviaoRecuperado=null;
        Calendar dataHoraSaida=null;
        Calendar dataHoraChegada=null;
        Cidade cidade_origem = null;
        Cidade cidade_destino =null;
        List<Cidade> escalas = new ArrayList<Cidade>();
        List<Cidade> cidades;
		Database database = new Database();
		
		String cidadeOrigem = request.getParameter("cidadeOrigem");
		String cidadeDestino= request.getParameter("cidadeDestino");
		String aviao= request.getParameter("aviao");
		String data = request.getParameter("data");
		String horaSaida = request.getParameter("horaSaida");
		String horaChegada= request.getParameter("horaChegada");
		String escala1= request.getParameter("escala1");
		String escala2= request.getParameter("escala2");
		String escala3= request.getParameter("escala3");
		
		
	//		
//
		List <Aviao> avioes = database.getAvioes();
		TipoAviao tipo;
		String fields[] = aviao.split(",");
		
		if (fields[2].equalsIgnoreCase("Domestico")) {
			tipo = TipoAviao.Domestico;
		} else {
			tipo = TipoAviao.Internacional;
		}
		
		Aviao aviao2 = new Aviao(fields[0], fields[1],tipo);
		for (Aviao aeronave : avioes) {
			if(aeronave.equals(aviao2)) {
				aviaoRecuperado = aeronave;
			} 
				
		}
		System.out.println("passei aviao");
//	-------------------------------------------------------------------------	
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			cal.setTime(sdf.parse(data+" "+ horaSaida));
			dataHoraChegada = cal;
			dataHoraSaida = cal;
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		System.out.println("passei calendar");
//	---------------------------------------------------------------------------	
//		O ERRO ESTA AQUI
		cidades = database.getCidades();
		String escala_1[] = escala1.split(",");
		String escala_2 []= escala2.split(",");
		String escala_3 []= escala3.split(",");
		String origem []= cidadeOrigem.split(",");
		String destino []= cidadeDestino.split(",");
		
		for (Cidade cidade : cidades) {
			if (cidade.getNome().equals(escala_1[0]) 
			    ||cidade.getNome().equals(escala_2[0]) 
				||cidade.getNome().equals(escala_3[0])) {
						escalas.add(cidade);
			}
			
			if (cidade.getNome().equals(origem)) {
				cidade_origem = cidade;
			}
			if (cidade.getNome().equals(destino)) {
				cidade_destino = cidade;
			}
		}
		System.out.println("passei cidades");
		Rota rota = new Rota(cidade_origem,cidade_destino);
		System.out.println("passei rota");
//--------------------------------------------------------
		Voo voo = new Voo(dataHoraSaida, dataHoraChegada, rota, escalas, aviaoRecuperado);
		System.out.println("passei voo");
		System.out.println(voo);
		
		return "forward:CadastraVoo";
	}

	
}
