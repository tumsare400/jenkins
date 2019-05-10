package com.pspl.bankapp.model;

import com.pspl.bankapp.specification.BankSpecification;

public abstract class BankAccount implements BankSpecification {
	
	private int accId;
	private String accHolderName;
	private String accType;
	private double balance;
	
	private static int accIdGenerator;
	private static String bankName;
	
	public BankAccount() {
		this.accId = ++accIdGenerator;
	}

	public BankAccount(String accHolderName, String accType, double balance) {
		this();
		this.accHolderName = accHolderName;
		this.accType = accType;
		this.balance = balance;
	}

	public String getAccHolderName() {
		return accHolderName;
	}

	public void setAccHolderName(String accHolderName) {
		this.accHolderName = accHolderName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccId() {
		return accId;
	}

	public static void displayBankName() {
		System.out.println("Bank Name : " + bankName);
	}
	
	@Override
	public String toString() {
		return "BankAccount [accId=" + accId + ", accHolderName=" + accHolderName + ", accType=" + accType
				+ ", balance=" + balance + "]";
	}
	
	static {
		accIdGenerator = 1000;
		bankName = "ICICI Bank";
	}
	
}
