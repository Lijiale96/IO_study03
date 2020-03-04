package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/*
 * ��������
 * 1��д�����ȡ
 * 2����ȡ��˳����д������һ��
 * 
 * DataOutputStream
 * DataInputStream
 * 
 */

public class DataTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//д��
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
		//������������
		dos.writeUTF("���������");
		dos.writeBoolean(false);
		dos.writeInt(18);
		dos.writeChar('a');
		dos.flush();
		byte[] datas =baos.toByteArray();
		System.out.println(datas.length);
		//��ȡ
		DataInputStream dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		//˳����д��һ��
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
