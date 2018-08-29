package test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;


public class QueryHLR {
	public static void main(String[] args) throws Exception {
		/*System.out.println("调用["+Thread.currentThread().getStackTrace()[1].getMethodName()+"]方法");
		StackTraceElement[] stackTrace=Thread.currentThread().getStackTrace();
		new Test06().test();*/
		InputStream read = new FileInputStream("E:\\new.txt");
		try {
			String[]  ss= readLineStream(read);
			/*List<String> stringss = Arrays.asList(ss);
			Collections.sort(stringss,new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length()>o2.length())
						return 0;
					else
						return 1;
				}
			});
			System.out.println(stringss.toString());*/
			HttpClient client = new HttpClient();
			
			//设置超时时间
			client.getHttpConnectionManager().getParams().setConnectionTimeout(10 * 1000);
			client.getHttpConnectionManager().getParams().setSoTimeout(10 * 1000);
			
			String parStr="";
			//设置参数
			StringBuilder tt = new StringBuilder();
			for (int i = 0 ; i<ss.length;i++) {
				/*if(string.split(" ").length>0) {
					continue;
				}
				*/
				String te= ss[i].trim();
				String teNum=te;
				String[] arr= te.split("\\s+");
				if(arr.length>0) {
					teNum=arr[0];
				}
				GetMethod getMethod = new GetMethod("http://www.ip138.com:8080/search.asp?mobile="+teNum+"&action=mobile");
				getMethod.setRequestHeader("CharSet", "GBK");
				client.executeMethod(getMethod);
				String s =new String(getMethod.getResponseBodyAsString().getBytes("ISO-8859-1"), "gb2312");;
				String hh = "<TR class=tdc bgcolor=#EFF1F3>\r\n" + 
						"		<TD align=\"center\">区 号</TD>\r\n" + 
						"		<TD align=\"center\" class=tdc2>";
				int x1 = s.indexOf(hh) ;
				String ssd = s.substring(x1+hh.length(),x1+hh.length()+4);
				String sd = ssd.replaceAll("[iv=\"|<|/TD]", "");
				tt.append(teNum+":"+sd+"#");
			}
			String[] sda= tt.toString().split("#");
			List<String> stringB =  Arrays.asList(sda);
			Collections.sort(stringB,new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if(o1.length()>o2.length())
						return 0;
					else
						return 1;
				}
			});
			System.out.println(stringB.toString());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			read.close();
		}
		
		
	}
	
	public final static String[] readLineStream(java.io.InputStream aStream) throws Exception {
		LineNumberReader reader = null;
		try {

			reader = new LineNumberReader(new java.io.InputStreamReader(aStream));
			return _readLineStream(reader);
		} finally {
			try {
				if (reader != null) {
					reader.close();
					reader = null;
				}
			} catch (Throwable t) {
			}
		}
	}

	public final static String[] _readLineStream(LineNumberReader aReader) throws Exception {
		java.util.List aILinesSKEL = new java.util.ArrayList();
		String line;
		while ((line = aReader.readLine()) != null)
			aILinesSKEL.add(line);
		return (String[]) aILinesSKEL.toArray(new String[] {});
	}
	/*private void test() {
		StackTraceElement[] stackTraced=Thread.currentThread().getStackTrace();
		System.out.println("调用["+Thread.currentThread().getStackTrace()[2].getClassName()+"]类");
		System.out.println("调用["+Thread.currentThread().getStackTrace()[2].getMethodName()+"]方法");

	}*/
}
