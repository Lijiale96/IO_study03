package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/*
 * 数据流：
 * 1、写出后读取
 * 2、读取的顺序与写出保持一致
 * 
 * DataOutputStream
 * DataInputStream
 * 
 */

public class DataTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//写出
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		//操作数据类型
		dos.writeUTF("编程辛酸泪");
		dos.writeBoolean(false);
		dos.writeInt(18);
		dos.writeChar('a');
		dos.flush();
		byte[] datas =baos.toByteArray();
		System.out.println(datas.length);
		//读取
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//顺序与写出一致
		String msg =dis.readUTF();
		boolean flag = dis.readBoolean();
		int age =dis.readInt();
		char ch =dis.readChar();
		
		System.out.println(msg);
		System.out.println(age);
		System.out.println(flag);
		System.out.println(ch);
	}

}
