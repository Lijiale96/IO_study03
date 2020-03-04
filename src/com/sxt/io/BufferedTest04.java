package com.sxt.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * 文件字符输出流  加入缓存流
 * 1、创建源
 * 2、选择流
 * 3、操作
 * 4、释放资源
 */

public class BufferedTest04 {

	public static void main(String[] args) {
		//1、创建源
		File dest =new File("dest.txt");
		//2、选择流
		BufferedWriter writer = null;
		try {
		writer =new BufferedWriter(new FileWriter(dest)); //追加
		//3、操作（写出）
		//写法一
//		String msg ="IO is so easy\r\n李家乐能成功";
//		char[] datas = msg.toCharArray();//字符串-->字节数组（编码）
//		writer.write(datas, 0, datas.length);
		//写法二
//		String msg ="IO is so easy\r\n李家乐能成功";
//		writer.write(msg);
//		writer.write("add");
		//写法三
		writer.append("IO is so easy");
		writer.newLine();
		writer.append("李家乐能成功");
		writer.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4、释放资源
			try {
				if (null != writer) {
					writer.close();
				} 
			} catch (Exception e) {
				
			}
		}

	}

}
