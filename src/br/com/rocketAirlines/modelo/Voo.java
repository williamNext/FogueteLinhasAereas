package br.com.rocketAirlines.modelo;

import java.util.Calendar;
import java.util.List;

public class Voo {
	
	private int id;
	private Calendar dataHoraPartida;
	private Calendar dataHoraChegada;
	private Rota rota;
	private List<Cidade> escalas;
	private Aviao aviao;
	
	
	public Voo() {
		
	}
	
	
	public Voo(Calendar dataHoraPartida, Calendar dataHoraChegada, Rota rota, List<Cidade> escalas,
			Aviao aviao) {
		this.dataHoraPartida = dataHoraPartida;
		this.dataHoraChegada = dataHoraChegada;
		this.rota = rota;
		this.escalas = escalas;
		this.aviao = aviao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getDataHoraPartida() {
		return dataHoraPartida;
	}
	public void setDataHoraPartida(Calendar dataHoraPartida) {
		this.dataHoraPartida = dataHoraPartida;
	}
	public Calendar getDataHoraChegada() {
		return dataHoraChegada;
	}
	public void setDataHoraChegada(Calendar dataHoraChegada) {
		this.dataHoraChegada = dataHoraChegada;
	}
	public Rota getRota() {
		return rota;
	}
	public void setRota(Rota rota) {
		this.rota = rota;
	}
	public List<Cidade> getEscalas() {
		return escalas;
	}
	public void setEscalas(List<Cidade> escalas) {
		this.escalas = escalas;
	}
	public Aviao getAviao() {
		return aviao;
	}
	public void setAviao(Aviao aviao) {
		this.aviao = aviao;
	}
	
	@Override
	public String toString() {
		return this.aviao.getNome()+this.dataHoraChegada.get(Calendar.DATE)+rota.getDestino();
	}
	
}