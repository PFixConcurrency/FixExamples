public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            try {
                error();
            } catch (Exception e) {
                System.out.println("not");
            }
            System.out.println(111);
        }
    }

    static public void error() {
        System.out.println(1 / 0);
    }
}
