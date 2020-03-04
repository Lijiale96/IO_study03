package com.sxt.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/*
 * �ļ��ֽ������ ���뻺����
 * 1������Դ
 * 2��ѡ����
 * 3������
 * 4���ͷ���Դ
 */

public class BufferedTest02 {

	public static void main(String[] args) {
		//1������Դ
		File dest =new File("dest.txt");
		//2��ѡ����
		OutputStream os = null;
		try {
		os =new BufferedOutputStream(new FileOutputStream(dest)); //׷��
		//3��������д����
		String msg ="IO is so easy\r\n";
		byte[] datas = msg.getBytes();//�ַ���-->�ֽ����飨���룩
		os.write(datas, 0, datas.length);
		os.flush();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			//4���ͷ���Դ
			try {
				if (null != os) {
					os.close();
				} 
			} catch (Exception e) {
				
			}
		}

	}

}
