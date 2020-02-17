package br.com.rocketAirlines.dao;

import java.util.Collections;
import java.util.List;

import br.com.rocketAirlines.modelo.Aviao;
import br.com.rocketAirlines.modelo.Database;


public class AviaoDAO {

	private static AviaoDAO instance;
	
	public static synchronized AviaoDAO getInstance() {
		if(instance == null) {
			instance = new AviaoDAO();
		}
		return instance;
	}
	
	public boolean add(Aviao aviao) {
		return Database.addAviao(aviao);
	}
	
	public List<Aviao> getLista() {
		return Collections.unmodifiableList(Database.getAvioes());
	}
}

