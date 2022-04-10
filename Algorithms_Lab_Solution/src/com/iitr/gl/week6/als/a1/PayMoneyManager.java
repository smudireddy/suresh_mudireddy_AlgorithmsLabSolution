package com.iitr.gl.week6.als.a1;

import java.util.Arrays;

public class PayMoneyManager {

	private int[] transactions;
	private int[] cumulativeTransactions;
	private int noOfTransactions;
	
	public PayMoneyManager(int[] transactions, int noOfTransactions, int[] cumulativeTransactions) {
		this.noOfTransactions = noOfTransactions;
		this.transactions = transactions;
		this.cumulativeTransactions = cumulativeTransactions;
	}
	
	public int numberOfTransactionToAcheiveTargetMethod1(int targetAmount) {
		
		int transactionCounter = -1;
		int transactionAmount = 0;
		
		if (targetAmount > 0) {

			for (int i = 0; i < noOfTransactions; i++) {

				transactionAmount += transactions[i];
				++transactionCounter;

				if (transactionAmount >= targetAmount) {
					break;
				}
			}
		}
		else {
			transactionCounter = 0;
		}
		
		if (transactionAmount < targetAmount) {
			transactionCounter = -1;
		}
		
		return transactionCounter;
	}
	
	public int numberOfTransactionToAcheiveTargetMethod2(int targetAmount) {
		
		if(targetAmount == 0) {
			return 0;
		}
		return findNumberOfTransactionToAcheiveTarget(targetAmount, 0, noOfTransactions-1);
	}
	
	private int findNumberOfTransactionToAcheiveTarget(int targetAmount, int left, int right) {

		int transactionCounter = -1;
		
		if(targetAmount == cumulativeTransactions[right]) {
		   return right+1;	
		}
		else if(targetAmount <= cumulativeTransactions[left]) {
			return left+1;
		}else if(targetAmount > cumulativeTransactions[right]) {
			
		}
		else {

			if (left < right) {
				
				int mid = (left + right) / 2;
				
				if (targetAmount <= cumulativeTransactions[mid]) {
					transactionCounter = findNumberOfTransactionToAcheiveTarget(targetAmount, 0, mid);
				}
				else {
					transactionCounter = findNumberOfTransactionToAcheiveTarget(targetAmount, mid+1, right);
				}
			}		
		}
		return transactionCounter;
	}
}
