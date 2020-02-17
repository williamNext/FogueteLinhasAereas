package br.com.rocketAirlines.dao;

import java.util.Collections;
import java.util.List;

import br.com.rocketAirlines.modelo.Database;
import br.com.rocketAirlines.modelo.Pais;

public class PaisDAO {

	private static PaisDAO instance;

	public static synchronized PaisDAO getInstance() {
		if (instance == null) {
			instance = new PaisDAO();
		}
		return instance;
	}

	public boolean add(Pais pais) {
		return Database.addPais(pais);
	}

	public List<Pais> getLista() {
		return Collections.unmodifiableList(Database.getPaises());
	}
}
