package test;

public class Demo4 {

	public static void main(String[] args) {
		new Demo4();
		System.out.println("Demo4.main()");
	}

	static {
		System.out.println("Demo4.static{ }");
	}

	public Demo4() {
		System.out.println("Demo4.Demo4()");
	}

	{
		System.out.println("Demo4.{ }");
	}
}
