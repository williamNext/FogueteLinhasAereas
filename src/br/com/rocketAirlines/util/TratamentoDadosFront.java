package br.com.rocketAirlines.util;


import java.util.List;

import br.com.rocketAirlines.modelo.Aviao;
import br.com.rocketAirlines.modelo.Database;
import br.com.rocketAirlines.modelo.TipoAviao;

public class TratamentoDadosFront {
	
	public Aviao TrataDadosAviao(String aviao){
		
		Database database = new Database();
		List <Aviao> avioes = database.getAvioes();
		
		TipoAviao tipo;
		
		System.out.println(aviao);
		String fields[] = aviao.split(",");
		System.out.println(fields);
		if (fields[2].equalsIgnoreCase("Doméstico")) {
			tipo = TipoAviao.Domestico;
		} else {
			tipo = TipoAviao.Internacional;
		}
		
		Aviao aviao2 = new Aviao(fields[0], fields[1],tipo);
		
		for (Aviao aeronave : avioes) {
			if(aeronave.equals(aviao2)) {
				return aeronave;
			} 
				
		}
		return null;
	}
	
}
