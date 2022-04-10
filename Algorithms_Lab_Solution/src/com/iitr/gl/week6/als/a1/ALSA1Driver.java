package com.iitr.gl.week6.als.a1;

import java.util.Scanner;

import com.iitr.gl.week6.als.a2.CurrencyService;

public class ALSA1Driver {

	public ALSA1Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int option = 0;
		
		do {
			
			System.out.println("Please eneter the number of transactions");

			int size = scanner.nextInt();

			System.out.println("Eneter the values of transactions");

			int[] transactions = new int[size];
			int[] cumulativeTransactions = new int[size];

			for (int i = 0; i < size; i++) {
				transactions[i] = scanner.nextInt();
				cumulativeTransactions[i] = transactions[i] +((i > 0)?cumulativeTransactions[i-1]:0);
			}

			PayMoneyManager service = new PayMoneyManager(transactions, size, cumulativeTransactions);
			
			do {

				System.out.println("Eneter the target");
				int targetAmount = scanner.nextInt();
				
				int transactionsCount = service.numberOfTransactionToAcheiveTargetMethod2(targetAmount);
				if(transactionsCount >= 0) {
					System.out.println("Target " + targetAmount + " achieved after " + transactionsCount + " transactions");	
				}
				else {
					System.out.println("Target " + targetAmount + " can't be achieved");
				}

				System.out.println("\nDo you have other target? : [ No-0, Yes-Any other value]");
				option = scanner.nextInt();

			} while (option != 0);

			System.out.println("\nDo you want repeat? : [ No-0, Yes-Any other value]");
			option = scanner.nextInt();

		} while (option != 0);
		
		scanner.close();
	}
}
