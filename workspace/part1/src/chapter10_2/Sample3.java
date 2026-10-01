package chapter10_2;

public class Sample3 {

	public static void main(String[] args) {
		
		Tax tax = new Tax(100, "田中宏", 150);
		int zei = tax.zeigaku(new Rate3());
		System.out.println(tax.getName()+"\t"+zei+" 税");
	}

}
