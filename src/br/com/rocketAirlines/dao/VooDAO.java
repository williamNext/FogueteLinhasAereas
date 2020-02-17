package br.com.rocketAirlines.dao;

import java.util.Collections;
import java.util.List;

import br.com.rocketAirlines.modelo.Database;
import br.com.rocketAirlines.modelo.Voo;

public class VooDAO {

	private static VooDAO instance;

	public static synchronized VooDAO getInstance() {
		if (instance == null) {
			instance = new VooDAO();
		}

		return instance;
	}

	public boolean add(Voo voo) {
		return Database.addVoo(voo);
	}

	public List<Voo> getLista() {
		return Collections.unmodifiableList(Database.getVoos());
	}

}
