package test;

import java.io.*;

public class BRRead {
	public static void main(String args[]) throws IOException {
		/*Character c;
		// ʹ�� System.in ���� BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter characters, 'q' to quit.");
		// ��ȡ�ַ�
		do {
			c = (char) br.read();
			System.out.print(c + "-");
		} while (c != 'q');

		String str;
		System.out.println("Enter lines of text.");
		System.out.println("Enter 'end' to quit.");
		do {
			str = br.readLine();
			System.out.println(str);
		} while (!str.equals("end"));
*/
/*		try {
			byte bWrite[] = { 11, 21, 3, 40, 5 };
			OutputStream os = new FileOutputStream("test.txt");
			for (int x = 0; x < bWrite.length; x++) {
				os.write(bWrite[x]); // writes the bytes
			}
			os.close();

			InputStream is = new FileInputStream("test.txt");
			int size = is.available();

			for (int i = 0; i < size; i++) {
				System.out.print((char) is.read() + "  ");
			}
			is.close();
		} catch (IOException e) {
			System.out.print("Exception");
		}*/
		
		File f = new File("a.txt");
		FileOutputStream fop = new FileOutputStream(f);
		// ����FileOutputStream����,�ļ������ڻ��Զ��½�
		
		OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
		// ����OutputStreamWriter����,��������ָ������,Ĭ��Ϊ����ϵͳĬ�ϱ���,windows����gbk
		
		writer.append("��������");
		// д�뵽������
		
		writer.append("\r\n");
		//����
		
		writer.append("English");
		// ˢ�»����,д�뵽�ļ�,��������Ѿ�û��д���������,ֱ��closeҲ��д��
		
		writer.close();
		//�ر�д����,ͬʱ��ѻ���������д���ļ�,���������ע�͵�
		
		fop.close();
		// �ر������,�ͷ�ϵͳ��Դ

		FileInputStream fip = new FileInputStream(f);
		// ����FileInputStream����
		
		InputStreamReader reader = new InputStreamReader(fip, "UTF-8");
		// ����InputStreamReader����,������д����ͬ

		StringBuffer sb = new StringBuffer();
		while (reader.ready()) {
			sb.append((char) reader.read());
			// ת��char�ӵ�StringBuffer������
		}
		System.out.println(sb.toString());
		reader.close();
		// �رն�ȡ��
		
		fip.close();
		// �ر�������,�ͷ�ϵͳ��Դ

	}
}
