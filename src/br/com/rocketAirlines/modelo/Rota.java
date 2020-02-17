package br.com.rocketAirlines.modelo;

import br.com.rocketAirlines.modelo.Cidade;

public class Rota {
	
	int id;
	Cidade origem;
	Cidade destino;
	
	
	public Rota(Cidade cidadeOrigem, Cidade cidadeDestino) {
		this.destino = cidadeDestino;
		this.origem = cidadeOrigem;
	}
	
	public Rota() {
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cidade getOrigem() {
		return origem;
	}
	public void setOrigem(Cidade origem) {
		this.origem = origem;
	}
	public Cidade getDestino() {
		return destino;
	}
	public void setDestino(Cidade destino) {
		this.destino = destino;
	}
	
	
}