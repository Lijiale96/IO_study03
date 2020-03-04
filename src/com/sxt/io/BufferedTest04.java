package com.sxt.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
 * �ļ��ַ������  ���뻺����
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 */

public class BufferedTest04 {

	public static void main(String[] args) {
		//1������Դ
		File dest =new File("dest.txt");
		//2��ѡ����
		BufferedWriter writer = null;
		try {
		writer =new BufferedWriter(new FileWriter(dest)); //׷��
		//3��������д����
		//д��һ
//		String msg ="IO is so easy\r\n������ܳɹ�";
//		char[] datas = msg.toCharArray();//�ַ���-->�ֽ����飨���룩
//		writer.write(datas, 0, datas.length);
		//д����
//		String msg ="IO is so easy\r\n������ܳɹ�";
//		writer.write(msg);
//		writer.write("add");
		//д����
		writer.append("IO is so easy");
		writer.newLine();
		writer.append("������ܳɹ�");
		writer.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4���ͷ���Դ
			try {
				if (null != writer) {
					writer.close();
				} 
			} catch (Exception e) {
				
			}
		}

	}

}
