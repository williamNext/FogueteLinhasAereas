package br.com.rocketAirlines.dao;

import java.util.Collections;
import java.util.List;

import br.com.rocketAirlines.modelo.Database;
import br.com.rocketAirlines.modelo.Rota;

public class RotaDAO {

	private static RotaDAO instance;

	public static synchronized RotaDAO getInstance() {
		if (instance == null) {
			instance = new RotaDAO();
		}
		return instance;
	}

	public boolean add(Rota rota) {
		return Database.addRota(rota);
	}

	public List<Rota> getLista() {
		return Collections.unmodifiableList(Database.getRotas());
	}
}
