package test;

public class Test {
   /* int num=1;
	class Inclass{
		public void testInclass() throws Exception {
			
			System.out.println("�ڲ���!+�ⲿ������num:"+num);
		}
	}*/
	public static void main(String[] args) throws Exception {
	/*	System.out.println("�ⲿ��!");
		Test.Inclass ic =new Test().new Inclass();
		ic.testInclass();*/
	/*	String s="!123!  !abc!  !DEF!";
		char[] sa=s.toCharArray();
		String s2=new String(sa);
		String[] s3 = s.split("!");
		for (String string : s3) {
			
			System.out.println("*"+string);
		}
		System.out.println(s.toUpperCase()+" ! "+s.toLowerCase()+" ! "+s.trim());	
		for(char s1:sa)
			System.out.println(s1);
			System.out.println(s2);*/
		
/*		String os_name = System.getProperty("os.arch");
		System.out.println(os_name + System.getenv("Java_Home"));
		System.out.println("java�汾�ţ�" + System.getProperty("java.version")); // java�汾��
		System.out.println("Java�ṩ�����ƣ�" + System.getProperty("java.vendor")); // Java�ṩ������
		System.out.println("Java�ṩ����վ��" + System.getProperty("java.vendor.url")); // Java�ṩ����վ
		System.out.println("jreĿ¼��" + System.getProperty("java.home")); // Java��Ŷ��Ӧ����jreĿ¼
		System.out.println("Java������淶�汾�ţ�" + System.getProperty("java.vm.specification.version")); // Java������淶�汾��
		System.out.println("Java������淶�ṩ�̣�" + System.getProperty("java.vm.specification.vendor")); // Java������淶�ṩ��
		System.out.println("Java������淶���ƣ�" + System.getProperty("java.vm.specification.name")); // Java������淶����
		System.out.println("Java������汾�ţ�" + System.getProperty("java.vm.version")); // Java������汾��
		System.out.println("Java������ṩ�̣�" + System.getProperty("java.vm.vendor")); // Java������ṩ��
		System.out.println("Java��������ƣ�" + System.getProperty("java.vm.name")); // Java���������
		System.out.println("Java�淶�汾�ţ�" + System.getProperty("java.specification.version")); // Java�淶�汾��
		System.out.println("Java�淶�ṩ�̣�" + System.getProperty("java.specification.vendor")); // Java�淶�ṩ��
		System.out.println("Java�淶���ƣ�" + System.getProperty("java.specification.name")); // Java�淶����
		System.out.println("Java��汾�ţ�" + System.getProperty("java.class.version")); // Java��汾��
		System.out.println("Java��·����" + System.getProperty("java.class.path")); // Java��·��
		System.out.println("Java lib·����" + System.getProperty("java.library.path")); // Java lib·��
		System.out.println("Java���������ʱ·����" + System.getProperty("java.io.tmpdir")); // Java���������ʱ·��
		System.out.println("Java��������" + System.getProperty("java.compiler")); // Java������
		System.out.println("Javaִ��·����" + System.getProperty("java.ext.dirs")); // Javaִ��·��
		System.out.println("����ϵͳ���ƣ�" + System.getProperty("os.name")); // ����ϵͳ����
		System.out.println("����ϵͳ�ļܹ���" + System.getProperty("os.arch")); // ����ϵͳ�ļܹ�
		System.out.println("����ϵͳ�汾�ţ�" + System.getProperty("os.version")); // ����ϵͳ�汾��
		System.out.println("�ļ��ָ�����" + System.getProperty("file.separator")); // �ļ��ָ���
		System.out.println("·���ָ�����" + System.getProperty("path.separator")); // ·���ָ���
		System.out.println("ֱ�߷ָ�����" + System.getProperty("line.separator")); // ֱ�߷ָ���
		System.out.println("����ϵͳ�û�����" + System.getProperty("user.name")); // �û���
		System.out.println("����ϵͳ�û�����Ŀ¼��" + System.getProperty("user.home")); // �û�����Ŀ¼
		System.out.println("��ǰ��������Ŀ¼��" + System.getProperty("user.dir")); // ��ǰ��������Ŀ¼
*/	
		
	/*	Runtime run=Runtime.getRuntime();
		Process pc=run.exec("E:\\Program Files\\Tencent\\QQ\\Bin\\QQScLauncher.exe");
		System.out.println(run.freeMemory());*/
		
	/*	Calendar calender = Calendar.getInstance();
		int year = calender.get(Calendar.YEAR);
		int month = calender.get(Calendar.MONTH) + 1;
		int day = calender.get(Calendar.DAY_OF_MONTH);
		int week = calender.get(Calendar.DAY_OF_WEEK);
		if (week == 1) {
			week = 7;
		} else {
			week -= 1;
		}
		
		int hour = calender.get(Calendar.HOUR_OF_DAY);
		int minute = calender.get(Calendar.MINUTE);
		int second = calender.get(Calendar.SECOND);
		System.out.println(year + "��" + month + "��" + day + "�� ����" + week + " "
				+ hour + ":" + minute + ":" + second);*/

		/*// ʮ����ת������
		String binaryString = Integer.toBinaryString(100);
		System.out.println(binaryString); // 1100100
		// ʮ����תʮ������
		String hexString = Integer.toHexString(100);
		System.out.println(hexString); // 64

		// ʮ����ת�˽���
		String octalString = Integer.toOctalString(100);
		System.out.println(octalString); // 144


		// �ַ���ת��Ӧ�Ľ���
		int parseInt3 = Integer.parseInt(octalString);
		System.out.println(parseInt3);
		// ������תʮ����
		int parseInt4 = Integer.parseInt(binaryString, 2);
		System.out.println(parseInt4);
		// ʮ������תʮ����
		int parseInt5 = Integer.parseInt(hexString, 16);
		System.out.println(parseInt5);
		// �˽���תʮ����
		int parseInt6 = Integer.parseInt(octalString, 8);
		System.out.println(parseInt6);
		
		Integer x = new Integer(5);//װ��
		int intValue = x.intValue(); //����

		// 5.0����д
		// �Զ�װ�䡣new Integer(5);
		Integer y = 5;  
		// ���������,x �������Զ�����,�����int �� ��5���мӷ�������ٽ��ͽ���װ�丳��x��
		y = y + 5; // ��ͨ��Integer.intValue() �������в���
*/
		  System.out.println("test!");
	}


}
