package domain.repository;

import java.util.ArrayList;
import java.util.List;

import domain.entities.Account;
import interfaces.IAccountRepository;


public class AccountRepository implements IAccountRepository {

	private List<Account> accounts = new ArrayList<>();
	
	@Override
	public Account getAccountById(int id) {
		for(var item : this.accounts) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void addAccounts(Account account) {
		accounts.add(account);
	}

}
