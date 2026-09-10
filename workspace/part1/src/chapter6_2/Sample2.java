package chapter6_2;

import chapter6.Tax;

public class Sample2 {

	public static void main(String[] args) {
		Tax tax = new Tax(100, "田中宏", 300000, 100000);
		System.out.println("控除額＝"+tax.getKoujo());
		tax.setKoujo(120000);
		
		System.out.println("控除額＝"+tax.getKoujo());

	}

}
