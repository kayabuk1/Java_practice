package chapter12_2;

import java.util.HashSet;

public class Sample1 {

	public static void main(String[] args) {
		
		var set = new HashSet<Meibo>();
		set.add(new Meibo(100,"田中宏"));
		set.add(new Meibo(200,"木村誠一"));
		set.add(new Meibo(100,"田中宏"));
		set.add(new Meibo(３００,"佐藤修"));
//		Meiboレコードオブジェクトのequalsメソッドによって、
//		同じものと判定されると、setには追加されない。
		
		set.forEach(System.out::println);

	}

}
//■実行結果
//Meibo[number=300, name=佐藤修]
//Meibo[number=200, name=木村誠一]
//Meibo[number=100, name=田中宏]