package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CodeCounter {
    
    static long normalLines = 0;//正常代码行
    static long commentLines = 0;//注释行
    static long whiteLines = 0;//空白行
    
    public static void main(String[] args) {
        //找到某个文件夹,该文件夹下面在没有文件夹，这里没有写递归处理不在同一文件夹的文件
        File f = new File("E:\\");
        File[] codeFiles = f.listFiles();
        for(File child : codeFiles){
            //只统计java文件
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
        //表示是否为注释开始
        boolean comment = false;
        try {
            br = new BufferedReader(new FileReader(f));
            String line = "";
            while((line = br.readLine()) != null) {
                //去掉注释符/*前面可能出现的空白
                line = line.trim();
                //空行 因为readLine()将字符串取出来时，已经去掉了换行符\n
                //所以不是"^[\\s&&[^\\n]]*\\n$"
                if(line.matches("^[\\s&&[^\\n]]*$")) {
                    whiteLines ++;
                } else if (line.startsWith("/*") && !line.endsWith("*/")) {
                    //统计多行/*****/
                    commentLines ++;
                    comment = true;    
                } else if (line.startsWith("/*") && line.endsWith("*/")) {
                    //统计一行/**/
                    commentLines ++;
                } else if (true == comment) {
                    //统计*/
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

