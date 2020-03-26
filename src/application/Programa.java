package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.etities.Reservado;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

		int numQuarto;
		Date dataEntra = null;
		Date dataSaida = null;
		
		System.out.print("N�mero do Quarto: ");
		numQuarto = sc.nextInt();
		System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
		dataEntra = formato.parse(sc.next());
		System.out.print("Entre com a data de sa�da (dd/MM/yyyy): ");
		dataSaida = formato.parse(sc.next());

		if (!dataSaida.after(dataEntra)) {
			System.out.println("Erro na reserva: a data do sa�da deve ser posterior � data do entrada. ");
		} else {
			Reservado reserva = new Reservado(numQuarto, dataEntra, dataSaida);
			System.out.println("Reservado: " + reserva);

			System.out.println();
			System.out.println("Entre dados para atualiza��o da reserva: ");
			System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
			dataEntra = formato.parse(sc.next());			
			System.out.print("Entre com a data de sa�da (dd/MM/yyyy): ");
			dataSaida = formato.parse(sc.next());
			
			String error = 	reserva.atualizaDatas(dataEntra, dataSaida);
			if(error != null) {
				System.out.println("Erro na reserva: " + error);
			}else {
				System.out.println("Reservado: " + reserva);
			}			
		}
		sc.close();
	}

}
