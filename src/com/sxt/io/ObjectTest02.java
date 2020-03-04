package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/*
 * ��������
 * 1��д�����ȡ
 * 2����ȡ��˳����д������һ��
 * 3���������еĶ��󶼿������л�  Serializable
 * 
 * ObjectOutputStream
 * ObjectInputStream
 * 
 */

public class ObjectTest02 {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		//д��-->���л�
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("obj.ser")));
		//������������+����
		oos.writeUTF("���������");
		oos.writeBoolean(false);
		oos.writeInt(18);
		oos.writeChar('a');
		//����
		oos.writeObject("˭������ζ");
		oos.writeObject(new Date());
		Employee emp = new Employee("����",400);
		oos.writeObject(emp);
		
		oos.flush();
		oos.close();
		
		//System.out.println(datas.length);
		//��ȡ -->�����л�
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream("obj.ser")));
		//˳����д��һ��
		String msg =ois.readUTF();
		boolean flag = ois.readBoolean();
		int age =ois.readInt();
		char ch =ois.readChar();
		
		System.out.println(msg);
		System.out.println(age);
		System.out.println(flag);
		System.out.println(ch);
		
		
		//��������ݻ�ԭ
		Object str =ois.readObject();
		Object date = ois.readObject();
		Object employee = ois.readObject();
		
		if (str instanceof String) {
			String strObj = (String) str;
			System.out.println(strObj);
		}
		if (date instanceof Date) {
			Date dateObj = (Date) date;
			System.out.println(dateObj);
		}
		if (employee instanceof Employee) {
			Employee empObj = (Employee)employee;
			System.out.println(empObj.getName()+"-->"+empObj.getSalary());
		}
		ois.close();
	}

}
