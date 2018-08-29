package test;

class Outer {
	public void test() {
		new Object() {
			public void run() {
				System.out.println(".run()");
			}
		}.run();
	}
}

public class Demo6 {

	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.test();
	}
}
