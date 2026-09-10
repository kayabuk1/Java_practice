import java.util.ArrayList;

import chapter6.Tax;

public class Exercise6_2_1 {

	public static void main(String[] args) {
//		Tax tax1 = new Tax(110, "木村一郎", 300000, 90000);
//		Tax tax2 = new Tax(120, "鈴木浩二	", 250000, 120000);
//		Tax tax3 = new Tax(130, "斎藤渉", 400000, 180000);
//		System.out.println(tax1.zeigaku());
//		System.out.println(tax2.zeigaku());
//		System.out.println(tax3.zeigaku());
//		【別解】
		var tax_ls = new ArrayList<Tax>();
		tax_ls.add(new Tax(110, "木村一郎", 300000, 90000));
		tax_ls.add(new Tax(120, "鈴木浩二	", 250000, 120000));
		tax_ls.add(new Tax(130, "斎藤渉", 400000, 180000));
		for (Tax tl: tax_ls) {
			System.out.println(tl.zeigaku());
//			System.out.println(tl);
//			↓◆Taxオブジェクト自体が表示されてしまう？
//			Javaは内部で自動的にそのオブジェクトの toString() メソッドを呼び出して
//			文字列化しようとする。
//			chapter6.Tax@2ff4acd0
//			System.out.println(tl.number);
//			◆↓Taxクラスフィールドでの定義。
//			private int number;
			
//			Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
//				フィールド Tax.number は不可視です
//
//				at Exercise6_2_1.main(Exercise6_2_1.java:22)
		}
	}

}

