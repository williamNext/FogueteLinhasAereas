package br.com.rocketAirlines.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Database {

	private static List<Aviao> avioes = new ArrayList<>();
	private static List<Voo> voos = new ArrayList<>();
	private static List<Rota> rotas = new ArrayList<>();
	private static List<Cidade> cidades = new ArrayList<>();
	private static List<Pais> paises = new ArrayList<>();

	private static Integer chaveAviao = 1;
	private static Integer chaveVoo = 1;
	private static Integer chaveRota = 1;
	private static Integer chaveCidade = 1;
	private static Integer chavePais = 1;

	static {
		
		Aviao aviao1 = new Aviao();
		aviao1.setId(chaveAviao++);
		aviao1.setModelo("A319");
		aviao1.setNome("Airbus");
		aviao1.setTipo(TipoAviao.Domestico);

		Aviao aviao2 = new Aviao();
		aviao2.setId(chaveAviao++);
		aviao2.setModelo("A320");
		aviao2.setNome("Airbus");
		aviao2.setTipo(TipoAviao.Domestico);

		Aviao aviao3 = new Aviao();
		aviao3.setId(chaveAviao++);
		aviao3.setModelo("A320 NEO");
		aviao3.setNome("Airbus");
		aviao3.setTipo(TipoAviao.Internacional);

		Aviao aviao4 = new Aviao();
		aviao4.setId(chaveAviao++);
		aviao4.setModelo("A321");
		aviao4.setNome("Airbus");
		aviao4.setTipo(TipoAviao.Domestico);

		Aviao aviao5 = new Aviao();
		aviao5.setId(chaveAviao++);
		aviao5.setModelo("B767");
		aviao5.setNome("Boeing");
		aviao5.setTipo(TipoAviao.Internacional);

		avioes.add(aviao1);
		avioes.add(aviao2);
		avioes.add(aviao3);
		avioes.add(aviao4);
		avioes.add(aviao5);

		// -------------------------------------------------------

		Pais pais1 = new Pais();
		pais1.setId(chavePais++);
		pais1.setNome("Brasil");

		Pais pais2 = new Pais();
		pais2.setId(chavePais++);
		pais2.setNome("Estados Unidos");

		Pais pais3 = new Pais();
		pais3.setId(chavePais++);
		pais3.setNome("Canada");

		Pais pais4 = new Pais();
		pais4.setId(chavePais++);
		pais4.setNome("Fran�a");

		Pais pais5 = new Pais();
		pais5.setId(chavePais++);
		pais5.setNome("Portugal");

		paises.add(pais1);
		paises.add(pais2);
		paises.add(pais3);
		paises.add(pais4);
		paises.add(pais5);

		// -------------------------------------------------------

		Cidade cidade1 = new Cidade();
		cidade1.setId(chaveCidade++);
		cidade1.setNome("Porto Alegre");
		cidade1.setPais(pais1);

		Cidade cidade2 = new Cidade();
		cidade2.setId(chaveCidade++);
		cidade2.setNome("S�o Paulo");
		cidade2.setPais(pais1);

		Cidade cidade3 = new Cidade();
		cidade3.setId(chaveCidade++);
		cidade3.setNome("Atlanta");
		cidade3.setPais(pais2);

		Cidade cidade4 = new Cidade();
		cidade4.setId(chaveCidade++);
		cidade4.setNome("Los Angeles");
		cidade4.setPais(pais2);

		Cidade cidade5 = new Cidade();
		cidade5.setId(chaveCidade++);
		cidade5.setNome("Toronto");
		cidade5.setPais(pais3);

		Cidade cidade6 = new Cidade();
		cidade6.setId(chaveCidade++);
		cidade6.setNome("Montreal");
		cidade6.setPais(pais3);

		Cidade cidade7 = new Cidade();
		cidade7.setId(chaveCidade++);
		cidade7.setNome("Nice");
		cidade7.setPais(pais4);

		Cidade cidade8 = new Cidade();
		cidade8.setId(chaveCidade++);
		cidade8.setNome("Paris");
		cidade8.setPais(pais4);

		Cidade cidade9 = new Cidade();
		cidade9.setId(chaveCidade++);
		cidade9.setNome("Lisboa");
		cidade9.setPais(pais5);

		Cidade cidade10 = new Cidade();
		cidade10.setId(chaveCidade++);
		cidade10.setNome("Porto");
		cidade10.setPais(pais5);

		cidades.add(cidade1);
		cidades.add(cidade2);
		cidades.add(cidade3);
		cidades.add(cidade4);
		cidades.add(cidade5);
		cidades.add(cidade6);
		cidades.add(cidade7);
		cidades.add(cidade8);
		cidades.add(cidade9);
		cidades.add(cidade10);

		// -------------------------------------------------------

		Rota rota1 = new Rota();
		rota1.setDestino(cidade1);
		rota1.setOrigem(cidade2);
		rota1.setId(chaveRota++);

		Rota rota2 = new Rota();
		rota2.setDestino(cidade3);
		rota2.setOrigem(cidade4);
		rota2.setId(chaveRota++);

		Rota rota3 = new Rota();
		rota3.setDestino(cidade5);
		rota3.setOrigem(cidade6);
		rota3.setId(chaveRota++);

		Rota rota4 = new Rota();
		rota4.setDestino(cidade7);
		rota4.setOrigem(cidade8);
		rota4.setId(chaveRota++);

		Rota rota5 = new Rota();
		rota5.setDestino(cidade9);
		rota5.setOrigem(cidade10);
		rota5.setId(chaveRota++);

		rotas.add(rota1);
		rotas.add(rota2);
		rotas.add(rota3);
		rotas.add(rota4);
		rotas.add(rota5);

		// -------------------------------------------------------
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();

		Voo voo1 = new Voo();
		voo1.setAviao(aviao1);
		voo1.setId(chaveVoo++);
		voo1.setRota(rota1);
		
		
		c1.set(Calendar.YEAR, 2020);
		c1.set(Calendar.MONTH, 9);
		c1.set(Calendar.DAY_OF_MONTH, 11);
		c1.set(Calendar.HOUR, 18);
		c1.set(Calendar.MINUTE, 00);
		voo1.setDataHoraPartida(c1);
		
		//c.clear();
		
		c2.set(Calendar.YEAR, 2020);
		c2.set(Calendar.MONTH, 9);
		c2.set(Calendar.DAY_OF_MONTH, 11);
		c2.set(Calendar.HOUR, 20);
		c2.set(Calendar.MINUTE, 30);
		voo1.setDataHoraChegada(c2);
		
		Calendar c3 = Calendar.getInstance();
		Calendar c4 = Calendar.getInstance();
		

		Voo voo2 = new Voo();
		voo2.setAviao(aviao2);
		voo2.setId(chaveVoo++);
		voo2.setRota(rota2);
		c3.set(Calendar.YEAR, 2020);
		c3.set(Calendar.MONTH, 10);
		c3.set(Calendar.DAY_OF_MONTH, 21);
		c3.set(Calendar.HOUR, 18);
		c3.set(Calendar.MINUTE, 00);
		voo2.setDataHoraPartida(c3);
		
		//c.clear();
		
		c4.set(Calendar.YEAR, 2020);
		c4.set(Calendar.MONTH, 10);
		c4.set(Calendar.DAY_OF_MONTH, 22);
		c4.set(Calendar.HOUR, 2);
		c4.set(Calendar.MINUTE, 30);
		voo2.setDataHoraChegada(c4);

		Calendar c5 = Calendar.getInstance();
		Calendar c6 = Calendar.getInstance();
		
		Voo voo3 = new Voo();
		voo3.setAviao(aviao3);
		voo3.setId(chaveVoo++);
		voo3.setRota(rota3);
		c5.set(Calendar.YEAR, 2020);
		c5.set(Calendar.MONTH, 11);
		c5.set(Calendar.DAY_OF_MONTH, 5);
		c5.set(Calendar.HOUR, 23);
		c5.set(Calendar.MINUTE, 00);
		voo3.setDataHoraPartida(c5);
		
		c6.set(Calendar.YEAR, 2020);
		c6.set(Calendar.MONTH, 10);
		c6.set(Calendar.DAY_OF_MONTH, 6);
		c6.set(Calendar.HOUR, 12);
		c6.set(Calendar.MINUTE, 30);
		voo3.setDataHoraChegada(c6);
		
		Calendar c7 = Calendar.getInstance();
		Calendar c8 = Calendar.getInstance();

		Voo voo4 = new Voo();
		voo4.setAviao(aviao4);
		voo4.setId(chaveVoo++);
		voo4.setRota(rota4);
		c7.set(Calendar.YEAR, 2020);
		c7.set(Calendar.MONTH, 11);
		c7.set(Calendar.DAY_OF_MONTH, 16);
		c7.set(Calendar.HOUR, 23);
		c7.set(Calendar.MINUTE, 00);
		voo4.setDataHoraPartida(c7);
		
		c8.set(Calendar.YEAR, 2020);
		c8.set(Calendar.MONTH, 10);
		c8.set(Calendar.DAY_OF_MONTH, 17);
		c8.set(Calendar.HOUR, 11);
		c8.set(Calendar.MINUTE, 30);
		voo4.setDataHoraChegada(c8);
		
		Calendar c9 = Calendar.getInstance();
		Calendar c10 = Calendar.getInstance();

		Voo voo5 = new Voo();
		voo5.setAviao(aviao5);
		voo5.setId(chaveVoo++);
		voo5.setRota(rota5);
		c9.set(Calendar.YEAR, 2020);
		c9.set(Calendar.MONTH, 11);
		c9.set(Calendar.DAY_OF_MONTH, 20);
		c9.set(Calendar.HOUR, 23);
		c9.set(Calendar.MINUTE, 00);
		voo5.setDataHoraPartida(c9);
		
		c10.set(Calendar.YEAR, 2020);
		c10.set(Calendar.MONTH, 10);
		c10.set(Calendar.DAY_OF_MONTH, 21);
		c10.set(Calendar.HOUR, 13);
		c10.set(Calendar.MINUTE, 30);
		voo5.setDataHoraChegada(c10);

		voos.add(voo1);
		voos.add(voo2);
		voos.add(voo3);
		voos.add(voo4);
		voos.add(voo5);

	}

	public static boolean addAviao(Aviao aviao) {
		aviao.setId(chaveAviao++);
		return avioes.add(aviao);
	}

	public static boolean addVoo(Voo voo) {
		voo.setId(chaveVoo++);
		return voos.add(voo);
	}

	public static boolean addRota(Rota rota) {
		rota.setId(chaveRota++);
		return rotas.add(rota);
	}

	public static boolean addCidade(Cidade cidade) {
		cidade.setId(chaveCidade++);
		return cidades.add(cidade);
	}

	public static boolean addPais(Pais pais) {
		pais.setId(chavePais++);
		return paises.add(pais);
	}

	public static List<Aviao> getAvioes() {
		return avioes;
	}

	public static List<Voo> getVoos() {
		return voos;
	}

	public static List<Rota> getRotas() {
		return rotas;
	}

	public static List<Cidade> getCidades() {
		return cidades;
	}

	public static List<Pais> getPaises() {
		return paises;
	}

}