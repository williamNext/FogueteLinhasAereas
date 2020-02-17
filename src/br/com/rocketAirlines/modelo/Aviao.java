package br.com.rocketAirlines.modelo;

import br.com.rocketAirlines.modelo.TipoAviao;

public class Aviao {

	private int id;
	private String nome;
	private String modelo;
	private TipoAviao tipo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public TipoAviao getTipo() {
		return tipo;
	}
	public void setTipo(TipoAviao tipo) {
		this.tipo = tipo;
	}
	
	
	
}
