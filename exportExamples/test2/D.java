package test2;

public class D {

volatile boolean flagFix = false;    int x = 0;

    void m1() {
        x++;
flagFix = true;    }

    void m2() {
            x *= 2;
    }

    void test() throws Exception {
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
while(!flagFix);        if (d.x < 2) {
            throw new Exception();
        }

    }

    public static void main(String[] args) throws Exception {
        D d = new D();
        d.test();
    }
}
