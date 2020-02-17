package br.com.rocketAirlines.dao;

import java.util.Collections;
import java.util.List;

import br.com.rocketAirlines.modelo.Cidade;
import br.com.rocketAirlines.modelo.Database;

public class CidadeDAO {

	private static CidadeDAO instance;

	public static synchronized CidadeDAO getInstance() {
		if (instance == null) {
			instance = new CidadeDAO();
		}
		return instance;
	}

	public boolean add(Cidade cidade) {
		return Database.addCidade(cidade);
	}
	
	public List<Cidade> getLista() {
		return Collections.unmodifiableList(Database.getCidades());
	}
}
