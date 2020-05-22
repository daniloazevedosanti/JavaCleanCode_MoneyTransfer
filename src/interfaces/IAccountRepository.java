package interfaces;

import domain.entities.Account;

public interface IAccountRepository {
	
	public Account getAccountById(int id); 
	public void addAccounts(Account account);

}