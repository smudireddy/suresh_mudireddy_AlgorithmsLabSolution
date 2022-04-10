package com.iitr.gl.week6.als.a2;

import java.util.Arrays;

public class CurrencyService {
	
	private int[] denominations = null;
	private int noOfDenominations;
	private int[] notesCounter = null;

	public CurrencyService(int[] denominations, int noOfDenominations ) {
		
		this.denominations = denominations;
		this.noOfDenominations = noOfDenominations;
		
		sortDenominationsByMergeSortmethod();
		
		//Note: Insertion Sort is the right choice as Denominations set is small and Merge sort is not a right candidate 
		//sortDenominationsByInsertionSortMethod();
	}
	
	public void displayDenominantions() {
		
		System.out.println("Currency Denominantions: ");
		for (int i = 0; i < denominations.length; i++) {
			System.out.println(denominations[i] + " ");
		}
	}
	
	private void mergeDenominations(int left, int right, int mid) {
		
		int leftLen  = mid - left +1;
		int rightLen = right - mid;
		
		int[] leftArray = new int[leftLen];
		int[] rightArray = new int[rightLen];
		
		for (int i = 0; i < leftLen; i++) {
			leftArray[i] =  denominations[left+i];
		}
		
		for (int i = 0; i < rightLen; i++) {
			rightArray[i] =  denominations[mid+1+i];
		}
		
		int i = 0;
		int j = 0;
		int k = left-1;
		
		while(i < leftLen && j < rightLen) {
		
			if(leftArray[i] >= rightArray[j]) {
				k++;
				denominations[k] =  leftArray[i];
				i++;
			}
			else {
				k++;
				denominations[k] =  rightArray[j];
				j++;
			}
		}
		
		while(i<leftLen) {
			k++;
			denominations[k] =  leftArray[i];
			i++;
		}
		
		while(j<rightLen) {
			k++;
			denominations[k] =  rightArray[j];
			j++;
		}
	}
	
	private void sortDenominations(int left, int right) {
		
		if (right > left) {
			
			int mid = (left+right)/2;

			sortDenominations(left, mid);
			sortDenominations(mid+1, right);
			mergeDenominations(left, right, mid);
		}
	}
	
	private void sortDenominationsByMergeSortmethod() {
		
		sortDenominations(0, noOfDenominations-1);
	}
	
	//Note: To use this method uncomment the line in the constructor
	private void sortDenominationsByInsertionSortMethod() {
		
		for (int i = 1; i < noOfDenominations; i++) {
			
			int j = i-1;
			int key = denominations[i];
			
			while(denominations[j] < key && j >= 0 ) {
				denominations[j+1] = denominations[j];
				--j;
			}
			denominations[j+1] = key;
		}
	}
	
	public int[] currencyNotesToPay(int amountToPay) {
		
		displayDenominantions();
		
		if(amountToPay == 0) {
			return null;
		}
		
		if (notesCounter == null) {
			notesCounter = new int[noOfDenominations];
		}
		Arrays.fill(notesCounter, 0);
		
		for (int i = 0; i < noOfDenominations; i++) {
			
			if (amountToPay >= denominations[i]) {
				notesCounter[i] = amountToPay / denominations[i];
				amountToPay = amountToPay - (denominations[i] * notesCounter[i]);
			}
		}
		return notesCounter;
	}
	
	public int[] getDenominations() {
		return Arrays.copyOf(this.denominations, this.noOfDenominations) ;
	}
}
