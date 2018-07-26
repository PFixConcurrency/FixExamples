public class Test {

    int total = 0;
    public static void main(String[] args){
        Test t  = new Test();
        System.out.println(t.getTotal());
    }
    public  int getTotal() {
        synchronized (this){return total;}
    }
}
