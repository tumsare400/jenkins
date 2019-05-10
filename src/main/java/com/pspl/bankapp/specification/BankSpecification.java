package com.pspl.bankapp.specification;

public interface BankSpecification {
	
	public void withdraw(double amount) throws Exception;
	
	public void deposit(double amount);	
}
