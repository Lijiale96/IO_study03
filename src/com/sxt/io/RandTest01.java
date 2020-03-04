package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * �����ȡ��д����  RandomAccessFile
 * 
 */

public class RandTest01 {

	public static void main(String[] args) throws IOException {
		//�ֶ��ٿ�
		File src = new File("src/com/sxt/io/Copy.java");
		//�ܳ���
		long len = src.length();
		//ÿ���С
		int blockSize = 1024;
		//���������ٿ�
		int size = (int)Math.ceil(len*1.0/blockSize);
		System.out.println(size);
		
		//��ʼλ�ú�ʵ�ʴ�С
		int beginPos=0;
		int actualSize = (int)(blockSize>len?len:blockSize);
		for (int i = 0; i < size; i++) {
			beginPos = i*blockSize;
			if (i==size-1) {  //���һ��
				actualSize = (int)len;
			}else {
				actualSize =blockSize;
				len-=actualSize;  //ʣ����
				
			}
			System.out.println(i+"-->"+beginPos+"-->"+actualSize);
			split(i,beginPos,actualSize);
		}		
	}

	
	/*
	 * ָ����i�����ʼλ�ú�ʵ�ʳ���
	 * 
	 * 
	 */
	//�ֿ�˼�룺��ʼ ��ʵ�ʴ�С
	public static void split(int i,int beginPos,int actualSize ) throws IOException {
		// TODO Auto-generated method stub
    RandomAccessFile raf = new RandomAccessFile(new File("src/com/sxt/io/Copy.java"),"r");
    //��ʼλ��
    //ʵ�ʴ�С
    //�����ȡ
    raf.seek(2);
    //��ȡ
    //3���������ֶζ�ȡ��
  		byte[] flush = new byte[1024*1];//��������
  		int len =-1;//���ܳ���
  		while ((len=raf.read(flush))!=-1) {
  			System.out.println(new String(flush,0,len));
  			if (actualSize>len) {  //��ȡ���ζ�ȡ����������
				System.out.println(new String(flush,0,len));
               actualSize -=len;
  			}else {
				System.out.println(new String(flush,0,actualSize));
				break;
			}
  		}
  		
    raf.close();
	}
	
	
	//ָ����ʼλ�ã���ȡʣ����������
	public static void test1() throws IOException {
		 RandomAccessFile raf = new RandomAccessFile(new File("src/com/sxt/io/Copy.java"),"r");
		   
		    //�����ȡ
		    raf.seek(2);
		    //��ȡ
		    //3���������ֶζ�ȡ��
		  		byte[] flush = new byte[1024*1];//��������
		  		int len =-1;//���ܳ���
		  		while ((len=raf.read(flush))!=-1) {
		  			System.out.println(new String(flush,0,len));
		  		}
		  		
		    raf.close();
	}
	
}
