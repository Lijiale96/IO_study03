package com.sxt.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

/*
 * ת������InputStreamReader OutputStreamWriter
 * 1�����ַ�������ʽ�����ֽ��������ı���
 * 2��ָ���ַ���
 * 
 */
public class ConvertTest02 {

	public static void main(String[] args) {

  // ���������� ���ذٶȵ�Դ����
	try(BufferedReader reader =
			new BufferedReader(
		new InputStreamReader(
				new URL("http://www.baidu.com").openStream(),"UTF-8"));
		
		BufferedWriter writer =
				new BufferedWriter(
			new OutputStreamWriter(
					new FileOutputStream("baidu.html"),"UTF-8"));){
	//3����������ȡ��	
		String msg;
		while ((msg=reader.readLine())!=null){
		//System.out.print(msg);
			writer.write(msg);//�ַ�����ͳһ������������
			writer.newLine();
		}
		writer.flush();
	
	}catch(IOException e) {
		System.out.println("�����쳣");
	}
	
	}
	
	public static void test1() {

		  // ���������� ���ذٶȵ�Դ����
			try(InputStream is =new URL("http://www.baidu.com").openStream();){
			//3����������ȡ��	
				int temp;
				while ((temp=is.read())!=-1) {
					System.out.print((char)temp);//�ֽ���������������
				}
			
			}catch(IOException e) {
				System.out.println("�����쳣");
			}
			
			}

}
