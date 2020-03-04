package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 *  文件拷贝：文件字节输入、输出流
 *
 */

public class CopyTxt {

	/*
	 * 思考：利用递归 制作文件夹的拷贝
	 * 
	 */
	public static void main(String[] args) {
	long t1 =  System.currentTimeMillis();
  copy ("abc.txt","abc-copy.txt");	
	}
	
	
	public static void copy(String srcPath,String destPath) {
		//1、创建源
//		File src =new File("p.png"); //源头
//		File dest =new File("pcopy.png"); //目的地
		File src =new File(srcPath); //源头
		File dest =new File(destPath); //目的地
		//2、选择流
		
		try {
	    BufferedReader br =new BufferedReader(new FileReader(src));	
		BufferedWriter bw =new BufferedWriter(new FileWriter(dest)); //追加
		
		//3、操作（分段读取）
	   String line = null;
		while ((line = br.readLine())!=null) {
			bw.write(line);//逐行写出
			bw.newLine();
		}
		bw.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static void copy2(String srcPath,String destPath) {
		//1、创建源
//		File src =new File("p.png"); //源头
//		File dest =new File("pcopy.png"); //目的地
		File src =new File(srcPath); //源头
		File dest =new File(destPath); //目的地
		//2、选择流
		
		try(InputStream is=new FileInputStream(src);
			OutputStream os=new FileOutputStream(dest,true);) {
	  
		//3、操作（分段读取）
		byte[] flush = new byte[1024*1];//缓冲容器
		int len =-1;//接受长度
		while ((len=is.read(flush))!=-1) {
			os.write(flush, 0,len);//3、操作（分段写出）
		}
		os.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
