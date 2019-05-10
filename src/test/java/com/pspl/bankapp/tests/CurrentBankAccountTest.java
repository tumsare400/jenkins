package com.pspl.bankapp.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pspl.bankapp.exceptions.OverdraftedException;
import com.pspl.bankapp.model.CurrentBankAccount;

public class CurrentBankAccountTest {

	private CurrentBankAccount account;
	
	@Before
	public void setUp() {
		account = new CurrentBankAccount("John", "Current", 100000);
	}
	
	@Test
	public void testDepositWithoutBorrowAmount() throws OverdraftedException {
		account.withdraw(75000);
		account.deposit(10000);
		assertEquals(35000, account.getBalance(), 0.01);
		assertEquals(0, account.getAmountBorrowed(), 0.01);
		account.deposit(8765.34);
		assertEquals(43765.34, account.getBalance(), 0.01);
		assertEquals(0, account.getAmountBorrowed(), 0.01);
	}
	
	@Test
	public void testDepositWithBorrowAmount() throws OverdraftedException {
		account.withdraw(107000);
		assertEquals(0, account.getBalance(), 0.01);
		assertEquals(7000, account.getAmountBorrowed(), 0.01);
		account.withdraw(2000);
		assertEquals(0, account.getBalance(), 0.01);
		assertEquals(9000, account.getAmountBorrowed(), 0.01);
		account.deposit(4000);
		assertEquals(0, account.getBalance(), 0.01);
		assertEquals(5000, account.getAmountBorrowed(), 0.01);
		account.deposit(10000);
		assertEquals(5000, account.getBalance(), 0.01);
		assertEquals(0, account.getAmountBorrowed(), 0.01);
	}
	
	@Test
	public void testWithdrawWithoutBorrowAmount() throws OverdraftedException {
		account.withdraw(50000);
		assertEquals(50000, account.getBalance(), 0.01);
		assertEquals(0, account.getAmountBorrowed(), 0.01);
		account.withdraw(34987.57);
		assertEquals(15012.43, account.getBalance(), 0.01);
		assertEquals(0, account.getAmountBorrowed(), 0.01);
		account.withdraw(5000);
		assertEquals(10012.43, account.getBalance(), 0.01);
		assertEquals(0, account.getAmountBorrowed(), 0.01);
	}
	
	@Test
	public void testWithdrawWithBorrowAmountAndWithoutException() throws OverdraftedException {
		account.withdraw(105000);
		assertEquals(0, account.getBalance(), 0.01);
		assertEquals(5000, account.getAmountBorrowed(), 0.01);
		account.withdraw(2345.78);
		assertEquals(0, account.getBalance(), 0.01);
		assertEquals(7345.78, account.getAmountBorrowed(), 0.01);
		account.withdraw(1000);
		assertEquals(0, account.getBalance(), 0.01);
		assertEquals(8345.78, account.getAmountBorrowed(), 0.01);
	}
	
	@Test(expected=OverdraftedException.class)
	public void testWithdrawWithBorrowAmountAndWithException() throws OverdraftedException  {
		account.withdraw(105000);
		assertEquals(0, account.getBalance(), 0.01);
		assertEquals(5000, account.getAmountBorrowed(), 0.01);
		account.withdraw(2345.78);
		assertEquals(0, account.getBalance(), 0.01);
		assertEquals(7345.78, account.getAmountBorrowed(), 0.01);
		account.withdraw(5000);
		assertEquals(0, account.getBalance(), 0.01);
		assertEquals(12345.78, account.getAmountBorrowed(), 0.01);
	}	
	
	@After
	public void tearDown() {
		account = null;
	}

}


