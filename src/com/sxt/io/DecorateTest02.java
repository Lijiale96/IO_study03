package com.sxt.io;

/*
 * ģ�⿧��
 * 1�������������Ҫװ�εĳ�����󣨽ӿڻ�����ࣩ
 * 2�������������Ҫװ�εĶ���
 * 3������װ���ࣺ�����˶Գ�������������Լ�װ���Ź��еķ���
 * 4������װ���ࣺ��װ�εĶ���
 */
public class DecorateTest02 {

	public static void main(String[] args) {
	  Drink coffee =new Coffee();
	  Drink sugar = new Sugar(coffee);//װ��
	  System.out.println(sugar.info()+"-->"+sugar.cost());
	  Drink Milk = new Milk(coffee);//װ��
	  System.out.println(Milk.info()+"-->"+Milk.cost());
	  
	  
	  Milk = new Milk(sugar);//װ��
	  System.out.println(Milk.info()+"-->"+Milk.cost());
	}
}
//�������
interface Drink{
	double cost();//����
	String info();//˵��
	
}
//�������
class Coffee implements Drink{
	private String name ="ԭζ����";

	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return 10;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return name;
	}
	
}

//����װ����
class Decorate implements Drink{

	//�Գ������������
	private Drink drink;
	public Decorate(Drink drink) {
		this.drink=drink;
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return this.drink.cost();
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return this.drink.info();
	}
}

//����װ����

class Milk extends Decorate{
	
	public Milk(Drink drink) {
		super(drink);
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*4;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"������ţ��";
	}
}

class Sugar extends Decorate{
	public Sugar(Drink drink) {
		super(drink);
		// TODO Auto-generated constructor stub
	}
	@Override
	public double cost() {
		// TODO Auto-generated method stub
		return super.cost()*2;
	}

	@Override
	public String info() {
		// TODO Auto-generated method stub
		return super.info()+"����������";
	}
}