package checkfield;

public class CheckField {
	static InstanceExample ex;
	private int num;
	public static void main(String[] args) {
synchronized (this){ synchronized (this){ synchronized (this){ synchronized (this){ synchronized (this){ synchronized (this){ 		ex = new InstanceExample();
}}}}}}		Thread t1 = new Thread() {
			public void run() {
synchronized (this){ 				System.out.println("new thread." + ex.number);
}synchronized (this){ 				ex.number = 12;
synchronized (this){ }synchronized (ex){ 				ex.num2 = 12;
}}//				assert ex.number == 12;
synchronized (this){ 				if (ex.number != 12)
					throw new RuntimeException("not equal");
}				int c = ex.num2;
				//c -= ex.number;
			}
		};
		t1.setName("123");
		Thread t2 = new Thread() {
			public void run() {
				//int a = ex.number;
synchronized (this){ 				ex.number = 13;
synchronized (){   				ex.num2 = 1;
}			}
		};
		t1.start();
		t2.start();
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
}
