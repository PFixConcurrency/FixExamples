package test;

public class Test {
    int a = 0;
    Ex b = new Ex();
    public static void main(String args[]) {
        Test t = new Test();
        t.a();
    }

    public synchronized void a(){
        synchronized (b){
            a++;
        }
    }

}
