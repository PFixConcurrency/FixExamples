package example2;

public class ExampleTwo {static Object o = new Object();
    public static void main(String[] args) {
        String url = "key1=Alice&key2=Bob";


        Account acc = new Account(1000, 1000);
        int total = 2000;

        Thread t1 = new ExampleThread1(acc);
        Thread t2 = new ExampleThread2(acc);

        System.out.println("before: " + "balance1 + balance2 = " + total);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        total = acc.getBalance1() + acc.getBalance2();
        System.out.println("after : " + "balance1 + balance2 = " + total);
        if (total != 2000) {
            throw new RuntimeException();
        }
    }
//    }
}