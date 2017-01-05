package test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HelloWorld {
	public static void main(String []args) {
	
		//textArea 换行处理
		String str = "实打实的\r\n,\r\nss\na\n";
		System.out.println(str);
		str=str.replaceAll("\r\n", "<br/>");
		str=str.replaceAll("\n", "<br/>");
		System.out.println(str);
		/*System.out.println(Long.toString(Long.valueOf(13813904285L),36));
		System.out.println(Long.parseLong("6cgfwrh", 36));*/
		/*SimpleDateFormat sdfShort = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdfLong = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdfLongTime = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdfLongTimePlus = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdfLongTimePlusMill = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
		SimpleDateFormat sdfLongTimePlus_s = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat myPattern = new SimpleDateFormat("yyyyMMddHHmmsss");
		SimpleDateFormat myPattern2 = new SimpleDateFormat("yyyyMMddHHmmssS");
		Date date = new Date();
		System.out.println(date.toString());
		System.out.println(sdfShort.format(date));
		System.out.println(sdfLong.format(date));
		System.out.println(sdfLongTime.format(date));
		System.out.println(sdfLongTimePlus.format(date));
		System.out.println(sdfLongTimePlusMill.format(date));
		System.out.println(sdfLongTimePlus_s.format(date));
		System.out.println(myPattern.format(date));
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmssS").format(date));*/
		
	}
}
