package reorder1;

/*
 * Created 2005-2-4
 * @author Xuan
 * Updated to make the class members both ints and to complete
 * the check() return value so it indicates if one or both values have
 * been changed
 */
public class SetCheck {
    private int a=0;
    private int b=0;
    void set() {
synchronized (this){         a = 1;
	b = -1;
}    }
	
    boolean check() {
synchronized (this){ 	return ((a==0 && b==0)  || (a==1 && b==-1));
}    }
}
