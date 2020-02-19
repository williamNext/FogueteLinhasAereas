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

import com.google.gson.reflect.TypeToken;

import br.com.rocketAirlines.modelo.Aviao;
import br.com.rocketAirlines.modelo.Cidade;
import br.com.rocketAirlines.modelo.Database;
import br.com.rocketAirlines.modelo.Rota;
import br.com.rocketAirlines.modelo.TipoAviao;
import br.com.rocketAirlines.modelo.Voo;
import br.com.rocketAirlines.util.JsonConverter;
import br.com.rocketAirlines.util.WebHelper;

public class CadastraVoo implements Acao {

	
	
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
		String dataChegada = request.getParameter("dataChegada");
		String dataSaida = request.getParameter("dataSaida");
		String horaSaida = request.getParameter("horaSaida");
		String horaChegada= request.getParameter("horaChegada");
		String escala1= request.getParameter("escala1");
		String escala2= request.getParameter("escala2");
		String escala3= request.getParameter("escala3");
		
		List <Aviao> avioes = JsonConverter.fromJson(WebHelper.GetJson("http://localhost:8080/taqui/listaAvioes"), 
				new TypeToken<List<Aviao>>() {}.getType());
		TipoAviao tipo;
		String fields[] = aviao.split(",");
		
		if (fields[2].equalsIgnoreCase("Domestico")) {
			tipo = TipoAviao.Domestico;
		} else {
			tipo = TipoAviao.Internacional;
		}
		
		Aviao aviao2 = new Aviao();
		aviao2.setNome(fields[0]);
		aviao2.setModelo(fields[1]);
		aviao2.setTipo(tipo);
		
		for (Aviao aeronave : avioes) {
			if(aeronave.equals(aviao2)) {
				aviaoRecuperado = aeronave;
			} 
				
		}
//	-------------------------------------------------------------------------	
		Calendar cal_saida = Calendar.getInstance();
		Calendar cal_chegada = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			cal_saida.setTime(sdf.parse(dataSaida+" "+ horaSaida));
			cal_chegada.setTime(sdf.parse(dataChegada+" "+ horaChegada));
			dataHoraChegada = cal_chegada;
			dataHoraSaida = cal_saida;
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		System.out.println("passei calendar");
//	---------------------------------------------------------------------------	
		cidades = JsonConverter.fromJson(WebHelper.GetJson("http://localhost:8080/taqui/listaCidades"), 
				new TypeToken<List<Cidade>>() {}.getType());
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
			
			if (cidade.getNome().equals(origem[0])) {
				cidade_origem = cidade;
			}
			
			if (cidade.getNome().equals(destino[0])) {
				cidade_destino = cidade;
			}
		}
		
		Rota rota = new Rota(cidade_origem, cidade_destino);
//--------------------------------------------------------
		Voo voo = new Voo();
		voo.setAviao(aviaoRecuperado);
		voo.setDataHoraChegada(dataHoraChegada);
		voo.setDataHoraPartida(dataHoraSaida);
		voo.setEscalas(escalas);
		voo.setRota(rota);
		
		String json = JsonConverter.toJson(voo);
		WebHelper.PostJson("http://localhost:8080/taqui/cadastraVoo", json);
		
		return "forward:FormCadastroVoo";
	}

}
