package test;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TypeTest {
/*	public static void main(String[] args) {
		// byte
		System.out.println("�������ͣ�byte ������λ����" + Byte.SIZE);
		System.out.println("��װ�ࣺjava.lang.Byte");
		System.out.println("��Сֵ��Byte.MIN_VALUE=" + Byte.MIN_VALUE);
		System.out.println("���ֵ��Byte.MAX_VALUE=" + Byte.MAX_VALUE);
		System.out.println();

		// short
		System.out.println("�������ͣ�short ������λ����" + Short.SIZE);
		System.out.println("��װ�ࣺjava.lang.Short");
		System.out.println("��Сֵ��Short.MIN_VALUE=" + Short.MIN_VALUE);
		System.out.println("���ֵ��Short.MAX_VALUE=" + Short.MAX_VALUE);
		System.out.println();

		// int
		System.out.println("�������ͣ�int ������λ����" + Integer.SIZE);
		System.out.println("��װ�ࣺjava.lang.Integer");
		System.out.println("��Сֵ��Integer.MIN_VALUE=" + Integer.MIN_VALUE);
		System.out.println("���ֵ��Integer.MAX_VALUE=" + Integer.MAX_VALUE);
		System.out.println();

		// long
		System.out.println("�������ͣ�long ������λ����" + Long.SIZE);
		System.out.println("��װ�ࣺjava.lang.Long");
		System.out.println("��Сֵ��Long.MIN_VALUE=" + Long.MIN_VALUE);
		System.out.println("���ֵ��Long.MAX_VALUE=" + Long.MAX_VALUE);
		System.out.println();

		// float
		System.out.println("�������ͣ�float ������λ����" + Float.SIZE);
		System.out.println("��װ�ࣺjava.lang.Float");
		System.out.println("��Сֵ��Float.MIN_VALUE=" + Float.MIN_VALUE);
		System.out.println("���ֵ��Float.MAX_VALUE=" + Float.MAX_VALUE);
		System.out.println();

		// double
		System.out.println("�������ͣ�double ������λ����" + Double.SIZE);
		System.out.println("��װ�ࣺjava.lang.Double");
		System.out.println("��Сֵ��Double.MIN_VALUE=" + Double.MIN_VALUE);
		System.out.println("���ֵ��Double.MAX_VALUE=" + Double.MAX_VALUE);
		System.out.println();

		// char
		System.out.println("�������ͣ�char ������λ����" + Character.SIZE);
		System.out.println("��װ�ࣺjava.lang.Character");
		// ����ֵ��ʽ�������ַ���ʽ��Character.MIN_VALUE���������̨
		System.out.println("��Сֵ��Character.MIN_VALUE="
				+ (int) Character.MIN_VALUE);
		// ����ֵ��ʽ�������ַ���ʽ��Character.MAX_VALUE���������̨
		System.out.println("���ֵ��Character.MAX_VALUE="
				+ (int) Character.MAX_VALUE);

	}
*/
	
	public static void main(String[] args) {
	/*	Date date=new Date();
		long l=date.getTime();
		Date date2=new Date(l);
		System.out.println(date.toString()+":::"+l+";;;"+date2);
		
		
		try { 
	         System.out.println(new Date( )+"\n"); 
	         Thread.sleep(1000*3);   // ����3��
	         System.out.println(new Date( )); 
	      } catch (Exception e) { 
	          System.out.println("Got an exception!"); 
	      }*/
		
		 // ��ָ��ģʽ���ַ�������
	      String line = "This order was placed for QT3000! OK?";
	      String pattern = "(.*)(\\d+)(.*)";

	      // ���� Pattern ����
	      Pattern r = Pattern.compile(pattern);

	      // ���ڴ��� matcher ����
	      Matcher m = r.matcher(line);
	      if (m.find( )) {
	         System.out.println("Found value: " + m.group(0) );
	         System.out.println("Found value: " + m.group(1) );
	         System.out.println("Found value: " + m.group(2) );
	      } else {
	         System.out.println("NO MATCH");
	      }
	}
}
