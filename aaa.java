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
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
 * �������˼���װ �ָ�
 * 
 */

public class SplitFile {
     //Դͷ
	private File src;
	//Ŀ�ĵأ��ļ��У�
	private String destDir;
	//���зָ����ļ��洢·��
	private List<String> destPaths;
	
	//ÿ���С
	private int blockSize;
	
	//���������ٿ�
	private int size;
	
	public SplitFile(String srcPath,String destDir,int blockSize) {
		this.src = new File(srcPath);
		this.destDir =destDir;
		this.blockSize=blockSize;
		this.destPaths =new ArrayList<String>();
		
		//��ʼ��
		init();
		
	}
	
	private void init() {
		//�ܳ���
		long len = this.src.length();
		
		//���������ٿ�
		this.size = (int)Math.ceil(len*1.0/blockSize);
	   //·��
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	
	/*
	 * �ָ�
	 * 1������ÿһ�����ʼλ�úʹ�С
	 * 2���ָ�
	 * 
	 */
	public void split() throws IOException{
		//�ܳ���
		long len = src.length();	
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
		    splitDetail(i,beginPos,actualSize);
			}		
	}
	
	/*
	 * ָ����i�����ʼλ�ú�ʵ�ʳ���
	 * 
	 * 
	 */
	
	
	//ָ����ʼλ�ã���ȡʣ����������
	private void splitDetail(int i,int beginPos,int actualSize ) throws IOException {
		 RandomAccessFile raf = new RandomAccessFile(this.src,"r");
		 RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");

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

	
/*
 * �ļ��ĺϲ�	
 */
	public void merge(String destPath) throws IOException {
	//�����
	OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
	Vector<InputStream> vi =new Vector<InputStream>();
	SequenceInputStream sis =null;
	
	//������
	for (int i = 0; i < destPaths.size(); i++) {
		vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));	
	}
	sis = new SequenceInputStream(vi.elements());
		//����
		//3���������ֶζ�ȡ��
	byte[] flush = new byte[1024*1];//��������
    int len =-1;//���ܳ���
    while ((len=sis.read(flush))!=-1) {
	os.write(flush, 0,len);//3���������ֶ�д����
				}
	os.flush();
	sis.close();
	os.close();
	}
	
public static void main(String[] args) throws IOException {
	 SplitFile sf = new SplitFile("src/com/sxt/io/SplitFile.java","dest",1024);
	 sf.split();
	 sf.merge("aaa.java");
}	
}
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
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/*
 * �������˼���װ �ָ�
 * 
 */

public class SplitFile {
     //Դͷ
	private File src;
	//Ŀ�ĵأ��ļ��У�
	private String destDir;
	//���зָ����ļ��洢·��
	private List<String> destPaths;
	
	//ÿ���С
	private int blockSize;
	
	//���������ٿ�
	private int size;
	
	public SplitFile(String srcPath,String destDir,int blockSize) {
		this.src = new File(srcPath);
		this.destDir =destDir;
		this.blockSize=blockSize;
		this.destPaths =new ArrayList<String>();
		
		//��ʼ��
		init();
		
	}
	
	private void init() {
		//�ܳ���
		long len = this.src.length();
		
		//���������ٿ�
		this.size = (int)Math.ceil(len*1.0/blockSize);
	   //·��
		for (int i = 0; i < size; i++) {
			this.destPaths.add(this.destDir+"/"+i+"-"+this.src.getName());
		}
	}
	
	/*
	 * �ָ�
	 * 1������ÿһ�����ʼλ�úʹ�С
	 * 2���ָ�
	 * 
	 */
	public void split() throws IOException{
		//�ܳ���
		long len = src.length();	
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
		    splitDetail(i,beginPos,actualSize);
			}		
	}
	
	/*
	 * ָ����i�����ʼλ�ú�ʵ�ʳ���
	 * 
	 * 
	 */
	
	
	//ָ����ʼλ�ã���ȡʣ����������
	private void splitDetail(int i,int beginPos,int actualSize ) throws IOException {
		 RandomAccessFile raf = new RandomAccessFile(this.src,"r");
		 RandomAccessFile raf2 = new RandomAccessFile(this.destPaths.get(i),"rw");

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

	
/*
 * �ļ��ĺϲ�	
 */
	public void merge(String destPath) throws IOException {
	//�����
	OutputStream os = new BufferedOutputStream(new FileOutputStream(destPath,true));
	Vector<InputStream> vi =new Vector<InputStream>();
	SequenceInputStream sis =null;
	
	//������
	for (int i = 0; i < destPaths.size(); i++) {
		vi.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));	
	}
	sis = new SequenceInputStream(vi.elements());
		//����
		//3���������ֶζ�ȡ��
	byte[] flush = new byte[1024*1];//��������
    int len =-1;//���ܳ���
    while ((len=sis.read(flush))!=-1) {
	os.write(flush, 0,len);//3���������ֶ�д����
				}
	os.flush();
	sis.close();
	os.close();
	}
	
public static void main(String[] args) throws IOException {
	 SplitFile sf = new SplitFile("src/com/sxt/io/SplitFile.java","dest",1024);
	 sf.split();
	 sf.merge("aaa.java");
}	
}
