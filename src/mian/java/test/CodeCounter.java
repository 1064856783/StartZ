package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeCounter {
    
    static long normalLines = 0;//����������
    static long commentLines = 0;//ע����
    static long whiteLines = 0;//�հ���
    
    public static void main(String[] args) {
        //�ҵ�ĳ���ļ���,���ļ���������û���ļ��У�����û��д�ݹ鴦����ͬһ�ļ��е��ļ�
        File f = new File("E:\\");
        File[] codeFiles = f.listFiles();
        for(File child : codeFiles){
            //ֻͳ��java�ļ�
            if(child.getName().matches(".*\\.java$")) {
                parse(child);
            }
        }
        
        System.out.println("normalLines:" + normalLines);
        System.out.println("commentLines:" + commentLines);
        System.out.println("whiteLines:" + whiteLines);
        
    }

    private static void parse(File f) {
        BufferedReader br = null;
        //��ʾ�Ƿ�Ϊע�Ϳ�ʼ
        boolean comment = false;
        try {
            br = new BufferedReader(new FileReader(f));
            String line = "";
            while((line = br.readLine()) != null) {
                //ȥ��ע�ͷ�/*ǰ����ܳ��ֵĿհ�
                line = line.trim();
                //���� ��ΪreadLine()���ַ���ȡ����ʱ���Ѿ�ȥ���˻��з�\n
                //���Բ���"^[\\s&&[^\\n]]*\\n$"
                if(line.matches("^[\\s&&[^\\n]]*$")) {
                    whiteLines ++;
                } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                    //ͳ�ƶ���/*****/
                    commentLines ++;
                    comment = true;    
                } else if (line.startsWith("/*") && line.endsWith("*/")) {
                    //ͳ��һ��/**/
                    commentLines ++;
                } else if (true == comment) {
                    //ͳ��*/
                    commentLines ++;
                    if(line.endsWith("*/")) {
                        comment = false;
                    }
                } else if (line.startsWith("//")) {
                    commentLines ++;
                } else {
                    normalLines ++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null) {
                try {
                    br.close();
                    br = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

