package test;

import org.junit.Assert;
import org.junit.Test;

import domain.entities.Account;
import domain.repository.AccountRepository;
import domain.services.MoneyTransfer;
import interfaces.IAccountRepository;

public class AppTest {

	@Test
	public void main() {
		
		// 1: cenário
		IAccountRepository accountRepository = new AccountRepository();
		
		accountRepository.addAccounts(new Account(123, "Steve Brown", 1200.00));
		accountRepository.addAccounts(new Account(456, "Rose Strauss", 100.00));
		accountRepository.addAccounts(new Account(789, "Frank Cortez", 300.00));
		accountRepository.addAccounts(new Account(101, "Mary Williams", -10.00));
		
		//Views part 1
		System.out.println(accountRepository.getAccountById(123));
		System.out.println(accountRepository.getAccountById(456));
		System.out.println(accountRepository.getAccountById(789));
		System.out.println(accountRepository.getAccountById(101));
		
		// 2: ação
		MoneyTransfer process = new MoneyTransfer(accountRepository);
		
		// 3: validação
		double expected = 500.00;
		
		Assert.assertTrue(process.transfer(123, 456, 400.00));
		
		var actualTest1 = accountRepository.getAccountById(456).getBalance();
		Assert.assertEquals(expected, actualTest1, 0.02);

		var actualTest2 = accountRepository.getAccountById(123).getBalance();
		expected = 800.00;
		Assert.assertEquals(expected, actualTest2, 0.02);
		
		Assert.assertTrue(!process.transfer(789, 101, 400.00));
		
		//Views part 2
		System.out.println("\n-----------------------------------\n");
		System.out.println(accountRepository.getAccountById(123));
		System.out.println(accountRepository.getAccountById(456));
		System.out.println(accountRepository.getAccountById(789));
		System.out.println(accountRepository.getAccountById(101));

	}

}
