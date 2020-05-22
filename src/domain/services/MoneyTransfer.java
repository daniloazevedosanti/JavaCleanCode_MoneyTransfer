package domain.services;

import interfaces.IAccountRepository;

public class MoneyTransfer  {

	private IAccountRepository accountRepository;
	
	public MoneyTransfer(IAccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public boolean transfer(int origemAccountId, int destinyAccountId, double amount) {
		var origem = accountRepository.getAccountById(origemAccountId);
		var destiny = accountRepository.getAccountById(destinyAccountId);
		if(origem != null && destiny != null) {
			if (origem.withdrawBalance(amount)) {
				destiny.depositBalance(amount);
				return true;
			}
			else
				return false;
		}
		return false;
	}
}
