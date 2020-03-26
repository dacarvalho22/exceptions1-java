package model.etities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.ExcecaoDominio;

public class Reservado {
	
	private Integer numQuartos;
	private Date entrada;
	private Date saida;

	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	public Reservado(Integer numQuartos, Date entrada, Date saida) {
		if (entrada.after(saida)) {
			throw new ExcecaoDominio("A data de sa�da deve ser posterior � data do entrada. ");
		} 
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
	
	// M�todo criado para tratar o error na CLASSE PRINCIPAL
	public void atualizaDatas(Date entrada, Date saida) {
		Date dataHoje = new Date();
		String msg = null;
		if (entrada.before(dataHoje) && saida.before(dataHoje)) {
			throw new ExcecaoDominio("As datas de reserva para atualiza��o devem ser futuras. ");
		}else if (entrada.after(saida)) {
			throw new ExcecaoDominio("A data de sa�da deve ser posterior � data do entrada. ");
		} 
		this.entrada = entrada;
		this.saida = saida;		
	}

	@Override
	public String toString() {
		return "Quarto: "
				+ this.numQuartos
				+ ", Entrada:  "
				+ formato.format(this.entrada)
				+ ", Sa�da: "
				+ formato.format(this.saida)
				+ ", " + duracao() + " noites";				
	}
	
}
