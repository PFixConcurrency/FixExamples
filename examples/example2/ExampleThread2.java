package example2;

public class ExampleThread2 extends Thread {
    Account acc;

    ExampleThread2(Account acc) {
        this.acc = acc;
    }

    public void run() {
        m();
    }

    private synchronized void m() {
        try {
            int balance2 = acc.getBalance2();
            balance2 = balance2 + 500;
            acc.setBalance2(balance2);

            //Thread.currentThread().sleep(1);

            int balance1 = acc.getBalance1();
            balance1 = balance1 - 500;
            acc.setBalance1(balance1);
//    		int balance1 = acc.getBalance1();
//    		int balance2 = acc.getBalance2();
//    		
//    		int total = balance1 + balance2;
//    		System.out.println(total);

        } catch (Exception e) {
            e.printStackTrace();
            "Crashed_with".equals(e);
            System.exit(1);
        }
    }
}
