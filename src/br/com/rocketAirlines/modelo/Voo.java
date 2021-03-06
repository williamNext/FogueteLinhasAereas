package br.com.rocketAirlines.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Voo {
	
	private int id;
	private Calendar dataHoraPartida;
	private Calendar dataHoraChegada;
	private Rota rota;
	private List<Cidade> escalas;
	private Aviao aviao;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDataHoraPartida() {
		return dataHoraPartida.getTime();
	}
	
	public void setDataHoraPartida(Calendar dataHoraPartida) {
		this.dataHoraPartida = dataHoraPartida;
	}
	
	public Date getDataHoraChegada() {
		return dataHoraChegada.getTime();
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
	
	public String getEscalasAsString() {
		
		if(escalas == null) {
			return "Sem escalas";
		}
		
		String cidade = "";
		
		for (Cidade cid : escalas) {
			cidade += cid.getNome() + " ,";
		}
		
		if(!cidade.isEmpty()) {
			cidade = cidade.substring(0, cidade.length() - 2);
			return cidade;
		}
		
		return "Sem escalas";
	}
	
	@Override
	public String toString() {
		return this.aviao.getNome()+this.dataHoraChegada.get(Calendar.DATE)+rota.getDestino();
	}
}