package test;

public class Test {
   /* int num=1;
	class Inclass{
		public void testInclass() throws Exception {
			
			System.out.println("内部类!+外部类属性num:"+num);
		}
	}*/
	public static void main(String[] args) throws Exception {
	/*	System.out.println("外部类!");
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
		System.out.println("java版本号：" + System.getProperty("java.version")); // java版本号
		System.out.println("Java提供商名称：" + System.getProperty("java.vendor")); // Java提供商名称
		System.out.println("Java提供商网站：" + System.getProperty("java.vendor.url")); // Java提供商网站
		System.out.println("jre目录：" + System.getProperty("java.home")); // Java，哦，应该是jre目录
		System.out.println("Java虚拟机规范版本号：" + System.getProperty("java.vm.specification.version")); // Java虚拟机规范版本号
		System.out.println("Java虚拟机规范提供商：" + System.getProperty("java.vm.specification.vendor")); // Java虚拟机规范提供商
		System.out.println("Java虚拟机规范名称：" + System.getProperty("java.vm.specification.name")); // Java虚拟机规范名称
		System.out.println("Java虚拟机版本号：" + System.getProperty("java.vm.version")); // Java虚拟机版本号
		System.out.println("Java虚拟机提供商：" + System.getProperty("java.vm.vendor")); // Java虚拟机提供商
		System.out.println("Java虚拟机名称：" + System.getProperty("java.vm.name")); // Java虚拟机名称
		System.out.println("Java规范版本号：" + System.getProperty("java.specification.version")); // Java规范版本号
		System.out.println("Java规范提供商：" + System.getProperty("java.specification.vendor")); // Java规范提供商
		System.out.println("Java规范名称：" + System.getProperty("java.specification.name")); // Java规范名称
		System.out.println("Java类版本号：" + System.getProperty("java.class.version")); // Java类版本号
		System.out.println("Java类路径：" + System.getProperty("java.class.path")); // Java类路径
		System.out.println("Java lib路径：" + System.getProperty("java.library.path")); // Java lib路径
		System.out.println("Java输入输出临时路径：" + System.getProperty("java.io.tmpdir")); // Java输入输出临时路径
		System.out.println("Java编译器：" + System.getProperty("java.compiler")); // Java编译器
		System.out.println("Java执行路径：" + System.getProperty("java.ext.dirs")); // Java执行路径
		System.out.println("操作系统名称：" + System.getProperty("os.name")); // 操作系统名称
		System.out.println("操作系统的架构：" + System.getProperty("os.arch")); // 操作系统的架构
		System.out.println("操作系统版本号：" + System.getProperty("os.version")); // 操作系统版本号
		System.out.println("文件分隔符：" + System.getProperty("file.separator")); // 文件分隔符
		System.out.println("路径分隔符：" + System.getProperty("path.separator")); // 路径分隔符
		System.out.println("直线分隔符：" + System.getProperty("line.separator")); // 直线分隔符
		System.out.println("操作系统用户名：" + System.getProperty("user.name")); // 用户名
		System.out.println("操作系统用户的主目录：" + System.getProperty("user.home")); // 用户的主目录
		System.out.println("当前程序所在目录：" + System.getProperty("user.dir")); // 当前程序所在目录
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
		System.out.println(year + "年" + month + "月" + day + "日 星期" + week + " "
				+ hour + ":" + minute + ":" + second);*/

		/*// 十进制转二进制
		String binaryString = Integer.toBinaryString(100);
		System.out.println(binaryString); // 1100100
		// 十进制转十六进制
		String hexString = Integer.toHexString(100);
		System.out.println(hexString); // 64

		// 十进制转八进制
		String octalString = Integer.toOctalString(100);
		System.out.println(octalString); // 144


		// 字符串转对应的进制
		int parseInt3 = Integer.parseInt(octalString);
		System.out.println(parseInt3);
		// 二进制转十进制
		int parseInt4 = Integer.parseInt(binaryString, 2);
		System.out.println(parseInt4);
		// 十六进制转十进制
		int parseInt5 = Integer.parseInt(hexString, 16);
		System.out.println(parseInt5);
		// 八进制转十进制
		int parseInt6 = Integer.parseInt(octalString, 8);
		System.out.println(parseInt6);
		
		Integer x = new Integer(5);//装箱
		int intValue = x.intValue(); //拆箱

		// 5.0简化书写
		// 自动装箱。new Integer(5);
		Integer y = 5;  
		// 对象加整数,x 进行了自动拆箱,变成了int 型 和5进行加法运算后再将和进行装箱赋给x。
		y = y + 5; // 是通过Integer.intValue() 方法进行拆箱
*/
		  System.out.println("test!");
	}


}
