package chapter6_2;

import chapter6.Tax;
public class Sample1 {

	public static void main(String[] args) {
		Tax tax = new Tax(100, "田中宏", 300000, 100000);
		System.out.println(tax.zeigaku());

//		■ゲッターメソッドの使用
		System.out.println("納税者番号　 ＝" + tax.getNumber());
		System.out.println("氏名　　　　＝" + tax.getName());
		System.out.println("所得額　　　＝" + tax.getShotoku());
		System.out.println("控除額　　　＝" + tax.getKoujo());
		
		System.out.println("所得税＝" + tax.zeigaku());
		
		
		
		
		
		
//		Rectangle rc = new Rectangle(10.0, 5.0);
//		System.out.println
//		("面積=%.1f".formatted(rc.calcRectArea()));
	}	
}
