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
 * 面向对象思想封装 分割
 * 
 */

public class SplitFile {
     //源头
	private File src;
	//目的地（文件夹）
	private String destDir;
	//所有分割后的文件存储路径
	private List<String> destPaths;
	
	//每块大小
	private int blockSize;
	
	//块数：多少块
	private int size;
	
	public SplitFile(String srcPath,String destDir,int blockSize) {
		this.src = new File(srcPath);
		this.destDir =destDir;
		this.blockSize=blockSize;
		this.destPaths =new ArrayList<String>();
		
		//初始化
		init();
		
	}
	
	private void init() {
		/