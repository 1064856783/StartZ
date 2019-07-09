package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.LineNumberReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class QueryHLR {
    private static final Log logger = LogFactory.getLog(QueryHLR.class);
    
	public static void main(String[] args) throws Exception {
		/*
		 * System.out.println("����["+Thread.currentThread().getStackTrace()[1].
		 * getMethodName()+"]����"); StackTraceElement[]
		 * stackTrace=Thread.currentThread().getStackTrace(); new Test06().test();
		 */
		Scanner in =new Scanner(System.in);
		String filePath = "E:\\";
		String fileName = "new.txt";
		System.err.print("�������ѯ����TXT�ļ�������,���س�������룺");
		String tempInput = in.next();
		if (StringUtils.isNotBlank(tempInput)) {
			fileName = tempInput;
		}
		System.err.println("������ļ���Ϊ��"+fileName);
		StringBuilder readPath = new StringBuilder(filePath+fileName.trim()+".txt");
		System.out.println("�����ļ���"+readPath);
		InputStream read = null;
		try {
			read = new FileInputStream(readPath.toString());
		} catch (FileNotFoundException e) {
			System.err.println("�����˳�,�����ԣ�"+e.getMessage());
			return ;
		}catch (Exception e) {
			System.err.println("δ֪����,�����˳�,�����ԣ�"+e.getMessage());
			return ;
		}
		List<String> resultList = new ArrayList<String>();
		List<String> errorList = new ArrayList<String>();
		String[] readFileLines = readLineStream(read);
		List<String> readFileLinesList =new ArrayList<String>(Arrays.asList(readFileLines));
		int orginNum = readFileLinesList.size();
		//���Դ���
		int reTryNum = 10;
		try {
			/*
			 * List<String> stringss = Arrays.asList(ss); Collections.sort(stringss,new
			 * Comparator<String>() {
			 * 
			 * @Override public int compare(String o1, String o2) {
			 * if(o1.length()>o2.length()) return 0; else return 1; } });
			 * System.out.println(stringss.toString());
			 */
			HttpClient client = new HttpClient();
			// ���ó�ʱʱ��
			client.getHttpConnectionManager().getParams().setConnectionTimeout(reTryNum * 1000);
			client.getHttpConnectionManager().getParams().setSoTimeout(reTryNum * 1000);
			// ���ò���
//			StringBuilder tempList = new StringBuilder();
//			long startTime = System.currentTimeMillis(); System.currentTimeMillis()-startTime > 300000//����ѯ5����
			int curReTryNum = 0;
			while (readFileLinesList.size() >= 1&&curReTryNum<=reTryNum) {
				System.out.println("��"+curReTryNum+"������,ʣ������:"+readFileLinesList.size());
				curReTryNum++;
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
//					System.out.println("QueryLog:"+hlrIn);
					String[] arr = hlrIn.split(":");
					if (hlrIn.length() > 7 && arr.length >= 2 && StringUtils.isNotBlank(arr[1])) {
						readFileLinesList.remove(i);
						String temp = "INSERT INTO `yyvoinvdb1`.`bds_mobile_prefix`\r\n"
								+ "VALUES ('"+arr[0]+"0000', '"+arr[0]+"9999', '"+arr[1]+"', "
								+ "'*', '1', '7', '0', '2001-01-01 00:00:00', '2037-01-01 00:00:00', '');";
						resultList.add(temp);
						continue;
					}
					hlrIn = hlrIn.replaceAll("[:]", "").trim();
					GetMethod getMethod = new GetMethod("http://www.ip138.com:8080/search.asp?action=mobile&mobile=" + hlrIn);
					getMethod.setRequestHeader("CharSet", "GBK");
					getMethod.setRequestHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:67.0) Gecko/20100101 Firefox/67.0");
					try {
						client.executeMethod(getMethod);
						String retHtml = new String(getMethod.getResponseBodyAsString().getBytes("ISO-8859-1"), "gb2312");
						String sIndex = "<TR class=tdc bgcolor=#EFF1F3>\r\n" 
										+ "		<TD align=\"center\">�� ��</TD>\r\n"
										+ "		<TD align=\"center\" class=tdc2>";
						int sNum = retHtml.indexOf(sIndex) + sIndex.length();
						String region = retHtml.substring(sNum, sNum + 4).replaceAll("[iv=\"|<|/TD]", "");
						if(StringUtils.isBlank(region)) {
							String sIndex2 = "<TD align=\"center\">�� ��</TD>\r\n" + 
									"<!-- <td></td> --><TD align=\"center\" class=tdc2>";
							int sNum2 = retHtml.indexOf(sIndex2) + sIndex2.length();
							region = retHtml.substring(sNum2, sNum2 + 4).replaceAll("[iv=\"|<|/TD]", "");
						}
						
						if(StringUtils.isNotBlank(region)&&NumberUtils.isDigits(region)) {
							readFileLinesList.remove(i);
							String temp = "INSERT INTO `yyvoinvdb1`.`bds_mobile_prefix`\r\n"
									+ "VALUES ('"+hlrIn+"0000', '"+hlrIn+"9999', '"+region+"', "
									+ "'*', '1', '7', '0', '2001-01-01 00:00:00', '2037-01-01 00:00:00', '');";
							resultList.add(temp);
						}
					} catch (Exception e) {
						System.err.println("ErrorNum:"+hlrIn+"\nErrorLog:"+e.getMessage());
						errorList.add(hlrIn);
					}
					
					/*String retHtml = new String(getMethod.getResponseBodyAsString().getBytes("ISO-8859-1"), "gb2312");
					String sIndex = "<TR class=tdc bgcolor=#EFF1F3>\r\n" 
									+ "		<TD align=\"center\">�� ��</TD>\r\n"
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
					*/
				}
			}
			System.out.println("-----------------------");
			System.out.println("��ѯ����,ʣ������:"+readFileLinesList.size());
			if (readFileLinesList.size() > 0) {
				errorList.addAll(readFileLinesList);
			}
//			String[] sda = tempList.toString().split("#");
//			List<String> stringB = Arrays.asList(sda);
			//JDK1.7�Ժ�Array.sort�Ż���legacyMergeSort(��ͳ�鲢����) ���� Timsort
			/*System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
			Collections.sort(resultList, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (StringUtils.equals(o1, o1))
						return -1;
					else
						return 1;
				}
			});*/
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHH24mmss");
			String curTime =sf.format(new Date(System.currentTimeMillis()));
			writeFile(filePath+"result_"+curTime+".txt", resultList);
			if (errorList.size()>0) {
				writeFile(filePath+"error_"+curTime+".txt", errorList);
			}
			System.out.println("-----------------------");
			System.out.println("�ܹ�������"+orginNum);
			System.out.println("-----------------------");
			System.out.println("���������"+resultList.size());
			System.out.println("-----------------------");
			System.out.println("ʧ��������"+errorList.size());
			System.out.println("-----------------------");
			System.out.println("��ѯ��ɣ�");
			System.out.println("-----------------------");
			System.out.println("�ļ�����Ŀ¼��"+filePath+"\nʱ���Ϊ��"+curTime);
			System.out.println("-----------------------");
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
	 * System.out.println("����["+Thread.currentThread().getStackTrace()[2].
	 * getClassName()+"]��");
	 * System.out.println("����["+Thread.currentThread().getStackTrace()[2].
	 * getMethodName()+"]����");
	 * 
	 * }
	 */
}
