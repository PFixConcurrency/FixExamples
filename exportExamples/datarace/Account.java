package datarace;

public class Account {

	private int balance;//���

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
synchronized (){ 		this.balance = balance;
}	}
	
}
