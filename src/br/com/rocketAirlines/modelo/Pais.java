package br.com.rocketAirlines.modelo;
public class Pais {
	
	private int id;
	private String nome;
	
	
	
	public Pais(String pais) {
		this.nome = pais;
	}
	
	public Pais() {
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
	
	
	
}
