package test;
import java.util.Random;
import java.util.Scanner;


public class Demo1 {
	public static void main(String[] args) {
		Random random = new Random();
		int temp=random.nextInt(11);
		while (true) {
			Scanner sc= new Scanner(System.in);
			System.out.println("������Ҫ�µ���:"+temp);
			if(temp==sc.nextInt()){
				System.out.println("�¶���!");
				break;
			}else {
				System.out.println("������~");
			}
		}
	}
}
