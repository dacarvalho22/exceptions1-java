package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.etities.Reservado;
import model.exceptions.ExcecaoDominio;

public class Programa {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		int numQuarto;
		Date dataEntra = null;
		Date dataSaida = null;
		
		try {
			System.out.print("Número do Quarto: ");
			numQuarto = sc.nextInt();
			System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
			dataEntra = formato.parse(sc.next());
			System.out.print("Entre com a data de saída (dd/MM/yyyy): ");
			dataSaida = formato.parse(sc.next());
			
			Reservado reserva = new Reservado(numQuarto, dataEntra, dataSaida);
			System.out.println("Reservado: " + reserva);
	
			System.out.println();
			System.out.println("Entre dados para atualização da reserva: ");
			System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
			dataEntra = formato.parse(sc.next());			
			System.out.print("Entre com a data de saída (dd/MM/yyyy): ");
			dataSaida = formato.parse(sc.next());
			
			reserva.atualizaDatas(dataEntra, dataSaida);
			System.out.println("Reservado: " + reserva);
		}catch(ParseException e){
			System.out.println("Formato da data errada !");
		}catch(ExcecaoDominio e) {
			System.out.println("Erro ao reservar: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Erro inesperado !");
		}
		
		sc.close();
	}

}
