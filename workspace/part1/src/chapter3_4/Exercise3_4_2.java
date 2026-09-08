package chapter3_4;
import java.util.ArrayList;

import chapter3_2.Product;
public class Exercise3_4_2 {

	public static void main(String[] args) {
		var list = new ArrayList<Product>();
		
		list.add(new Product("MT890","ステンレスネジﾞ",280,false));
		list.add(new Product("MT810","タッピングネジ",160,true));
		list.add(new Product("MT900","スクリューネジ",330,true));
		
		for(Product p: list) {
			System.out.print(p.name()+"\t\t");
			System.out.print(p.price()+"\n");
		}
		
		

	}

}
