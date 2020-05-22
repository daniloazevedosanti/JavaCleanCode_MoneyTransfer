package domain.entities;

public class Account {

	private int id;
	private String holder;
	private double balance;
	
	public Account(int id, String holder, double balance) {
		this.id = id;
		this.holder = holder;
		
		if(balance > 0)
			this.balance = balance;
		else
			this.balance = 0;
	}

	public int getId() {
		return id;
	}
	
	public String getHolder() {
		return holder;
	}
	
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void depositBalance(double balance) {
		if (balance > 0)
			this.balance += balance;
	}
	
	public boolean withdrawBalance(double balance) {
		if(this.getBalance() >= balance ) {
			this.balance -= balance;
			return true;
		}
		return false;
	}
	
	public String toString() {
		return "Account "
				+this.getId()
				+", Holder: "
				+this.getHolder()
				+", Balance $ "
				+String.format("%.2f", this.getBalance());
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
