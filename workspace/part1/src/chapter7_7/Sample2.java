package chapter7_7;

import chapter6.Tax;

public class Sample2 {

	public static void main(String[] args) {
		Tax tax = new Tax(100, "田中宏1", 300000, 100000);
//		Tax mytax = tax;
		sub(tax);
//		mytax.setNumber(200);
		System.out.println(tax);
//		System.out.println(mytax);
		
		Tax tax2 = new Tax(100, "田中宏2", 300000, 100000);
//		Tax mytax = tax;
		sub2(tax2);
//		mytax.setNumber(200);
		System.out.println(tax2);
	}
	public static void sub(Tax mytax) {
		mytax.setNumber(200);
		mytax = new Tax(100, "田中宏3", 30000, 100000);
		System.out.println(mytax);
	}
	public static void sub2(Tax mytax) {
		mytax = new Tax(100, "田中宏4", 300000, 100000);
		mytax.setNumber(200);
		System.out.println(mytax);
	}
}
//Tax [number=100, name=田中宏3, shotoku=30000, koujo=100000]
//Tax [number=200, name=田中宏1, shotoku=300000, koujo=100000]
//Tax [number=200, name=田中宏4, shotoku=300000, koujo=100000]
//Tax [number=100, name=田中宏2, shotoku=300000, koujo=100000]

