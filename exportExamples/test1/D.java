package test1;

public class D {

    int x = 0;

    void m1() {
synchronized (this){         x++;
}    }

    void m2() {
synchronized (this){         x *= 2;
}    }

    void test() throws Exception{
        final D d = new D();
        Thread d1 = new Thread() {
            public void run() {
                d.m1();
            }
        };
        Thread d2 = new Thread() {
            public void run() {
                d.m2();
            }
        };
        d1.start();
        d2.start();
        d1.join();
        d2.join();
synchronized (this){         if(d.x < 1){
            throw new Exception();
        }
}    }
    public static void main(String[] args) throws Exception {
        D d= new D();
        d.test();
    }
}
