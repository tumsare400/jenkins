package com.pspl.bankapp.model;

import com.pspl.bankapp.exceptions.LowBalanceException;

public class SavingBankAccount extends BankAccount {
	
	private static final int MIN_BAL = 10000;
	
	public SavingBankAccount() {
		super();
	}

	public SavingBankAccount(String accHolderName, String accType, double balance) {
		super(accHolderName, accType, balance);
	}

	public void withdraw(double amount) throws Exception {
		double temp = getBalance() - amount;
		if(temp > MIN_BAL) {
			setBalance(temp);
		}
		else 
			throw new LowBalanceException("Insufficient balance...");
	}

	public void deposit(double amount) {
		setBalance(getBalance() + amount);
	}
}







