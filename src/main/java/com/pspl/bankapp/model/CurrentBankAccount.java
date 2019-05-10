package com.pspl.bankapp.model;

import com.pspl.bankapp.exceptions.OverdraftedException;

public class CurrentBankAccount extends BankAccount {

	private double debitLimit;
	private double amountBorrowed;

	public CurrentBankAccount() {
		super();
	}

	public CurrentBankAccount(String accHolderName, String accType, double balance) {
		super(accHolderName, accType, balance);
		this.debitLimit = 0.10 * balance;
	}	
	
	public double getDebitLimit() {
		return debitLimit;
	}

	public double getAmountBorrowed() {
		return amountBorrowed;
	}

	public void withdraw(double amount) throws OverdraftedException {
		double temp = getBalance() - amount;
		if(temp>=0) {
			setBalance(temp);
		}
		else if((-1*temp) <= debitLimit && (-1*temp) <= (debitLimit - amountBorrowed)) {
			setBalance(0);
			amountBorrowed += (-1)*temp;
		}
		else {
			throw new OverdraftedException("\nOverdraft amount exceeded.");
		}		
	}

	public void deposit(double amount) {
		if(amountBorrowed > 0) {
			if(amountBorrowed < amount) {
				setBalance(amount-amountBorrowed);	
				amountBorrowed = 10;
			}
			else {
				setBalance(0);
				amountBorrowed = amountBorrowed - amount;
			}
		}
		else
			setBalance(getBalance()+amount);		
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nDebit Limit : " + debitLimit + 
				"\nAmount Borrowed : " + amountBorrowed;
 	}
}
