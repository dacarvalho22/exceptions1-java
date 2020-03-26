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
		Date dataHoje = new Date();

		System.out.print("Número do Quarto: ");
		numQuarto = sc.nextInt();
		System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
		dataEntra = formato.parse(sc.next());
		System.out.print("Entre com a data de saída (dd/MM/yyyy): ");
		dataSaida = formato.parse(sc.next());

		if (!dataSaida.after(dataEntra)) {
			System.out.println("Erro na reserva: a data do saída deve ser posterior à data do entrada. ");
		} else {
			Reservado reserva = new Reservado(numQuarto, dataEntra, dataSaida);
			System.out.println("Reservado: " + reserva);

			System.out.println();
			System.out.println("Entre dados para atualização da reserva: ");
			System.out.print("Entre com a data de entrada (dd/MM/yyyy): ");
			dataEntra = formato.parse(sc.next());
			System.out.print("Entre com a data de saída (dd/MM/yyyy): ");
			dataSaida = formato.parse(sc.next());

			if (dataEntra.before(dataHoje) && dataSaida.before(dataHoje)) {
				System.out.println("Erro na reserva: As datas de reserva para atualização devem ser futuras. ");
			} else if (!dataSaida.after(dataEntra)) {
				System.out.println("Erro na reserva: a data de saída deve ser posterior à data do entrada. ");
			} else {
				reserva.atualizaDatas(dataEntra, dataSaida);
				System.out.println("Reservado: " + reserva);
			}

		}

		sc.close();
	}

}
