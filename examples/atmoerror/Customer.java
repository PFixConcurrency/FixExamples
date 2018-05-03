package atmoerror;

public class Customer implements Runnable {

    private BankAccount account;
    private int cash;

    public Customer(int cash, BankAccount account) {
        this.cash = cash;
        this.account = account;
    }

    public void cost(int n) {
        cash -= n;
        account.add(n);
    }

    @Override
    public void run() {

        while (cash > 0) {  //直至将钱用光
            cost(1);
        }

        System.out.println("total: " + account.getTotal());   //打印出银行账户的总计金额
        //这是原程序中的判断
        /*if (account.getTotal() != 10)
            throw new RuntimeException();*/
    }

}
