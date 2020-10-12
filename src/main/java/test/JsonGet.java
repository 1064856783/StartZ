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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class JsonGet {
    private static final Log logger = LogFactory.getLog(QueryHLR.class);
    
	public static void main(String[] args) throws Exception {
		/*
		 * System.out.println("调用["+Thread.currentThread().getStackTrace()[1].
		 * getMethodName()+"]方法"); StackTraceElement[]
		 * stackTrace=Thread.currentThread().getStackTrace(); new Test06().test();
		 */
		Scanner in =new Scanner(System.in);
		String filePath = "E:\\";
		String fileName = "new.txt";
		System.err.print("请输入查询区号TXT文件的名称,按回车完成输入：");
		String tempInput = in.next();
		if (StringUtils.isNotBlank(tempInput)) {
			fileName = tempInput;
		}
		System.err.println("输入的文件名为："+fileName);
		StringBuilder readPath = new StringBuilder(filePath+fileName.trim()+".txt");
		System.out.println("导入文件："+readPath);
		InputStream read = null;
		try {
			read = new FileInputStream(readPath.toString());
		} catch (FileNotFoundException e) {
			System.err.println("程序退出,请重试："+e.getMessage());
			return ;
		}catch (Exception e) {
			System.err.println("未知错误,程序退出,请重试："+e.getMessage());
			return ;
		}
		List<String> resultList = new ArrayList<String>();
		List<String> errorList = new ArrayList<String>();
		String[] readFileLines = readLineStream(read);
		List<String> readFileLinesList =new ArrayList<String>(Arrays.asList(readFileLines));
		int orginNum = readFileLinesList.size();
		//重试次数
		int reTryNum = 0;
		try {
			int curReTryNum = 0;
			while (readFileLinesList.size() >= 1&&curReTryNum<=reTryNum) {
				System.out.println("第"+curReTryNum+"次重试,剩余数量:"+readFileLinesList.size());
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
					try {
						JSONObject parseObject = JSON.parseObject(hlrIn);
						JSONObject jsonObject = parseObject.getJSONObject("data").getJSONObject("basic");
						String accountGroup = jsonObject.getString("accountGroup");
		                String custName = jsonObject.getString("custName");
		                String busiLicenceNo = jsonObject.getString("busiLicenceNo");
		                resultList.add("accountGroup:"+accountGroup+" \t custName:"+custName+" \t busiLicenceNo:"+busiLicenceNo);
		                readFileLinesList.remove(i);
					} catch (Exception e) {
						System.err.println("ErrorNum:"+hlrIn+"\nErrorLog:"+e.getMessage());
						errorList.add(hlrIn);
					}
				}
			}
			System.out.println("-----------------------");
			System.out.println("查询结束,剩余数量:"+readFileLinesList.size());
			if (readFileLinesList.size() > 0) {
				errorList.addAll(readFileLinesList);
			}
//			String[] sda = tempList.toString().split("#");
//			List<String> stringB = Arrays.asList(sda);
			//JDK1.7以后Array.sort优化了legacyMergeSort(传统归并排序) 改用 Timsort
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
			System.out.println("总共数量："+orginNum);
			System.out.println("-----------------------");
			System.out.println("完成数量："+resultList.size());
			System.out.println("-----------------------");
			System.out.println("失败数量："+errorList.size());
			System.out.println("-----------------------");
			System.out.println("查询完成！");
			System.out.println("-----------------------");
			System.out.println("文件生成目录："+filePath+"\n时间戳为："+curTime);
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
	 * System.out.println("调用["+Thread.currentThread().getStackTrace()[2].
	 * getClassName()+"]类");
	 * System.out.println("调用["+Thread.currentThread().getStackTrace()[2].
	 * getMethodName()+"]方法");
	 * 
	 * }
	 */
}
