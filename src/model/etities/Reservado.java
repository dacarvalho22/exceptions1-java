package model.etities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Reservado {
	
	private Integer numQuartos;
	private Date entrada;
	private Date saida;

	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public Reservado(Integer numQuartos, Date entrada, Date saida) {
		this.numQuartos = numQuartos;
		this.entrada = entrada;
		this.saida = saida;
	}

	public Integer getNumQuartos() {
		return numQuartos;
	}

	public void setNumQuartos(Integer numQuartos) {
		this.numQuartos = numQuartos;
	}

	public Date getEntrada() {
		return entrada;
	}

	public Date getSaida() {
		return saida;
	}
	
	public long duracao() {
		long diff = saida.getTime() - entrada.getTime(); 
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); 
	}
	
	public void atualizaDatas(Date entrada, Date saida) {
		this.entrada = entrada;
		this.saida = saida;				
	}

	@Override
	public String toString() {
		return "Quarto: "
				+ this.numQuartos
				+ ", Entrada:  "
				+ formato.format(this.entrada)
				+ ", Saída: "
				+ formato.format(this.saida)
				+ ", " + duracao() + " noites";				
	}
	
}
