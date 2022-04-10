package com.iitr.gl.week6.als.a2;

import java.util.Scanner;

public class ALSA2Driver {

	public ALSA2Driver() {
		
	}

	public static void main(String[] args) {
		

		Scanner scanner = new Scanner(System.in);

		int option = 0;
		
		do {
			
			System.out.println("Please eneter the size of currency denominations");

			int size = scanner.nextInt();

			System.out.println("Please eneter the currency denominations");

			int[] denominations = new int[size];

			for (int i = 0; i < size; i++) {
				denominations[i] = scanner.nextInt();
			}
			
			CurrencyService service = new CurrencyService(denominations, size);
			service.displayDenominantions();

			do {

				System.out.println("Eneter the amount you have to pay");
				int amountToPay = scanner.nextInt();

				int notesCounter[] = service.currencyNotesToPay(amountToPay);
				int notes[] = service.getDenominations();

				System.out.println("\nDenominations need for payment :");
				for (int i = 0; i < notesCounter.length; i++) {

					if (notesCounter[i] != 0) {
						System.out.println(notes[i] + " : " + notesCounter[i]);
					}
				}

				System.out.println("\nDo you have other payment ? : [ No-0, Yes-Any other value]");
				option = scanner.nextInt();

			} while (option != 0);

			System.out.println("\nDo you want to continue ? :[ No-0, Yes-Any other value]");
			option = scanner.nextInt();

		} while (option != 0);
		
		scanner.close();
	}
}
