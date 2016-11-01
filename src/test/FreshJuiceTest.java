package test;

enum FreshJuiceSize {
	SMALL, MEDUIM, LARGE
}

class FreshJuice {
	FreshJuiceSize size;
}

public class FreshJuiceTest {
	public static void main(String[] args) {
		FreshJuice freshJuice = new FreshJuice();
		freshJuice.size = FreshJuiceSize.SMALL;
		System.out.println(freshJuice.size);
		if (freshJuice instanceof FreshJuice) {
			FreshJuice fJuice = (FreshJuice) freshJuice;
			System.out.println("True fjuice.size:"+fJuice.size);
		}
	}
}
