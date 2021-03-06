package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.transform.Source;

/*
 *  文件拷贝：文件字节输入、输出流
 *
 */

public class Copy {

	/*
	 * 思考：利用递归 制作文件夹的拷贝
	 * 
	 */
	public static void main(String[] args) {
	long t1 =  System.currentTimeMillis();
  copy ("IO开篇.MP4","IO-copy.txt");	
	long t2 = System.currentTimeMillis();
			System.out.println(t2-t1);
	}
	
	
	public static void copy(String srcPath,String destPath) {
		//1、创建源
//		File src =new File("p.png"); //源头
//		File dest =new File("pcopy.png"); //目的地
		File src =new File(srcPath); //源头
		File dest =new File(destPath); //目的地
		//2、选择流
		InputStream is =null;
		OutputStream os = null;
		try {
	    is =new BufferedInputStream(new FileInputStream(src));	
		os =new BufferedOutputStream(new FileOutputStream(dest)); //追加
		
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
		}finally {
			//4、释放资源  分别关闭 先打开的后关闭
			try {
				if (null != os) {
					os.close();
				} 
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				if (null!=is) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
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
