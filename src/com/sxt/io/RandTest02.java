package com.sxt.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * �����ȡ��д����  RandomAccessFile
 * 
 */

public class RandTest02 {

	public static void main(String[] args) throws IOException {
		//�ֶ��ٿ�
		File src = new File("p.png");
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
	
	
	//ָ����ʼλ�ã���ȡʣ����������
	public static void split(int i,int beginPos,int actualSize ) throws IOException {
		 RandomAccessFile raf = new RandomAccessFile(new File("p.png"),"r");
		 RandomAccessFile raf2 = new RandomAccessFile(new File("dest/"+i+"p.png"),"rw");

		    //�����ȡ
		    raf.seek(beginPos);
		    //��ȡ
		    //3���������ֶζ�ȡ��
		  		byte[] flush = new byte[1024*1];//��������
		  		int len =-1;//���ܳ���
		  		while ((len=raf.read(flush))!=-1) {
		  		  			if (actualSize>len) {  //��ȡ���ζ�ȡ����������
		  						raf2.write(flush,0,len);
		  		               actualSize -=len;
		  		  			}else {
		  						raf2.write(flush,0,actualSize);
		  						break;
		  					}
		  		}
		  		
		    raf2.close();
		    raf.close();
	}
	
}
