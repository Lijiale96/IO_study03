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
		/