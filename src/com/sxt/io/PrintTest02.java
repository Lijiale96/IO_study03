package com.sxt.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
 * 打印流  PrintStream
 * 
 * 
 * 
 */

public class PrintTest02 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
   //打印流System.out
	
	
	PrintWriter pw =new PrintWriter(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
	pw.println("打印流");
	pw.println(true);
	pw.close();
	

	}

	
	
}
