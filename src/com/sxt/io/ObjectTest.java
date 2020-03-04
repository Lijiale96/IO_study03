package com.sxt.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

public class ObjectTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		//д��-->���л�
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(baos));
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
		byte[] datas =baos.toByteArray();
		System.out.println(datas.length);
		//��ȡ -->�����л�
		ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
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
		
	}

}
//javabean  ��װ����
class Employee implements java.io.Serializable{
	private transient String name;  //�����ݲ���Ҫ���л�
	private double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public Employee(String name, double salary) {
		//super();
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
}
