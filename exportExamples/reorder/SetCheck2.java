package reorder;

/*
 * Created 2005-2-4
 * @author Xuan
 * Updated to make the class members both ints and to complete
 * the check() return value so it indicates if one or both values have
 * been changed
 */
public class SetCheck2 {
static Object objectFix = new Object();    private int a=0;
    private int b=0;
    void set(int i) {
//    synchronized (this) {
synchronized (objectFix){      	a = i;
    	System.out.println("a set to " + i);
//    }
//	synchronized (this) {
		b = -i;
		System.out.println("b set to " + -i);
}//	}
    }

    boolean check() {
synchronized (objectFix){ synchronized (objectFix){     	System.out.println("a = " + a + " b = " + b);
	return (a + b == 0);
 } }    }
}
