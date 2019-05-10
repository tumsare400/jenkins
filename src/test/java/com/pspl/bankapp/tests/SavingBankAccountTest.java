package com.pspl.bankapp.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.pspl.bankapp.exceptions.LowBalanceException;
import com.pspl.bankapp.model.SavingBankAccount;

public class SavingBankAccountTest {

	private SavingBankAccount account;

	@Before
	public void setUp() {
		account = new SavingBankAccount("John", "Saving", 25000);
	}

	@Test
	public void testDeposit() {
		account.deposit(5000.78);
		assertEquals(30000.78, account.getBalance(), 0.001);
		account.deposit(3678.67);
		assertEquals(33679.448, account.getBalance(), 0.003);
	}

	@Test
	public void testWithdrawWithoutException() throws Exception {
		account.withdraw(5698.78);
		assertEquals(19301.22, account.getBalance(), 0.001);
		account.withdraw(4500);
		assertEquals(14801.22, account.getBalance(), 0.001);
	}

	@Test(expected = LowBalanceException.class)
	public void testWithdrawWithException() throws Exception {
		account.withdraw(12000);
		assertEquals(13000, account.getBalance(), 0.001);
		account.withdraw(5000);
		assertEquals(8000, account.getBalance(), 0.001);
	}

	@After
	public void tearDown() {
		account = null;
	}
}
