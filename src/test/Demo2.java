package test;

public class Demo2 {
	public static void main(String[] args) {
		outer:for (int i = 1; i < 10; i++) {
			inner:for (int j = 1; j < i+1; j++) {
				System.out.print(i+"*"+j+"="+i*j+"\t");
				continue inner;
			}
			System.out.println();
		}
	}
}
