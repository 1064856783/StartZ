package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;

public class QueryHLR {
	
	public static void main(String[] args) throws Exception {
		/*
		 * System.out.println("调用["+Thread.currentThread().getStackTrace()[1].
		 * getMethodName()+"]方法"); StackTraceElement[]
		 * stackTrace=Thread.currentThread().getStackTrace(); new Test06().test();
		 */
		InputStream read = new FileInputStream("E:\\new.txt");
		try {
			String[] readFileLines = readLineStream(read);
			
			List<String> readFileLinesList =new ArrayList<String>(Arrays.asList(readFileLines));
			
			/*
			 * List<String> stringss = Arrays.asList(ss); Collections.sort(stringss,new
			 * Comparator<String>() {
			 * 
			 * @Override public int compare(String o1, String o2) {
			 * if(o1.length()>o2.length()) return 0; else return 1; } });
			 * System.out.println(stringss.toString());
			 */
			HttpClient client = new HttpClient();
			// 设置超时时间
			client.getHttpConnectionManager().getParams().setConnectionTimeout(10 * 1000);
			client.getHttpConnectionManager().getParams().setSoTimeout(10 * 1000);
			// 设置参数
//			StringBuilder tempList = new StringBuilder();
			List<String> resultList = new ArrayList<String>();
//			long startTime = System.currentTimeMillis(); System.currentTimeMillis()-startTime > 300000//最多查询5分钟
			while (readFileLinesList.size() >= 1) {
//				System.out.println("While!!");
				for (int i = 0; i < readFileLinesList.size(); i++) {
//					System.out.println("For!!");
					/*
					 * String hlrAndRegion = readFileLines[i].trim(); String hlr = hlrAndRegion;
					 * String[] arr = hlrAndRegion.split(":"); if (arr.length >=
					 * 2&&StringUtils.isNotBlank(arr[2])) { resultList.add(hlrAndRegion); continue;
					 * }
					 */
					String hlrIn = readFileLinesList.get(i).trim();
					String[] arr = hlrIn.split(":");
					if (hlrIn.length() > 7 && arr.length >= 2 && StringUtils.isNotBlank(arr[1])) {
						readFileLinesList.remove(i);
						String temp = "INSERT INTO `yyvoinvdb1`.`bds_mobile_prefix`\r\n"
								+ "VALUES ('"+arr[0]+"0000', '"+arr[0]+"9999', '"+arr[1]+"', "
								+ "'*', '1', '7', '0', '2001-01-01 00:00:00', '2037-01-01 00:00:00', '');";
						
						resultList.add(temp);
						continue;
					}
					hlrIn =hlrIn.replaceAll("[:]", "");
					GetMethod getMethod = new GetMethod("http://www.ip138.com:8080/search.asp?action=mobile&mobile=" + hlrIn);
					getMethod.setRequestHeader("CharSet", "GBK");
					client.executeMethod(getMethod);
					String retHtml = new String(getMethod.getResponseBodyAsString().getBytes("ISO-8859-1"), "gb2312");
					String sIndex = "<TR class=tdc bgcolor=#EFF1F3>\r\n" 
									+ "		<TD align=\"center\">区 号</TD>\r\n"
									+ "		<TD align=\"center\" class=tdc2>";
					int sNum = retHtml.indexOf(sIndex) + sIndex.length();
					String region = retHtml.substring(sNum, sNum + 4).replaceAll("[iv=\"|<|/TD]", "");
					if(StringUtils.isNotBlank(region)) {
						readFileLinesList.remove(i);
						String temp = "INSERT INTO `yyvoinvdb1`.`bds_mobile_prefix`\r\n"
								+ "VALUES ('"+hlrIn+"0000', '"+hlrIn+"9999', '"+region+"', "
								+ "'*', '1', '7', '0', '2001-01-01 00:00:00', '2037-01-01 00:00:00', '');";
						resultList.add(temp);
					}
					
				}
			}
			if (readFileLinesList.size() > 0) {
				resultList.addAll(readFileLinesList);
			}
//			String[] sda = tempList.toString().split("#");
//			List<String> stringB = Arrays.asList(sda);
			//JDK1.7以后Array.sort优化了legacyMergeSort(传统归并排序) 改用 Timsort
			System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
			Collections.sort(resultList, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (o1.length() > o2.length())
						return -1;
					else
						return 1;
				}
			});
			System.out.println(resultList.toString());
			writeFile("E:\\result.txt", resultList);
			System.out.println("查询完成！");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
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
	
	 public final static void writeFile( String aFileName , List<String> contextList ) throws Exception{
	    	File file = new File( aFileName );
			FileOutputStream fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos, true, "UTF-8");
			for (String string : contextList) {
				ps.println(string);
			}
			ps.flush(); ps.close(); ps = null;
			fos.close(); fos = null;
	    }
	/*
	 * private void test() { StackTraceElement[]
	 * stackTraced=Thread.currentThread().getStackTrace();
	 * System.out.println("调用["+Thread.currentThread().getStackTrace()[2].
	 * getClassName()+"]类");
	 * System.out.println("调用["+Thread.currentThread().getStackTrace()[2].
	 * getMethodName()+"]方法");
	 * 
	 * }
	 */
}
