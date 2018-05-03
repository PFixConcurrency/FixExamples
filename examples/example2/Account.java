package example2;

public class Account {
    private int balance1;
    private int balance2;

    Account(int money1, int money2) {
        this.balance1 = money1;
        this.balance2 = money2;
    }

    public synchronized void setBalance1(int money) {
        this.balance1 = money;
    }

    public synchronized void setBalance2(int money) {
        this.balance2 = money;
    }

    public synchronized int getBalance1() {
        return balance1;
    }

    public synchronized int getBalance2() {
        return balance2;
    }
}