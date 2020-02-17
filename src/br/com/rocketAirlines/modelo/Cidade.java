package br.com.rocketAirlines.modelo;

import br.com.rocketAirlines.modelo.Pais;

public class Cidade {

	private int id;
	private String nome;
	private Pais pais;
	
	
	public Cidade(String cidade, Pais pais2) {
		this.nome = cidade;
		this.pais = pais2;	
	}
	public Cidade() {
		
	}
	
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
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
	
}