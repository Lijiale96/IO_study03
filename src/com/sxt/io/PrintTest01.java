package com.sxt.io;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/*
 * ��ӡ��  PrintStream
 * 
 * 
 * 
 */

public class PrintTest01 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
   //��ӡ��System.out
	PrintStream ps =System.out;
	ps.println("��ӡ��");
	ps.println(true);
	
	
	ps =new PrintStream(new BufferedOutputStream(new FileOutputStream("print.txt")),true);
	ps.println("��ӡ��");
	ps.println(true);
	ps.close();
	
	//�ض��������
	System.setOut(ps);
	System.out.println("change");
	//�ض���ؿ���̨
	System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
	System.out.println("i am backing...");
	}

	
	
}
