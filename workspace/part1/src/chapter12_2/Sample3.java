package chapter12_2;

import java.util.TreeSet;

public class Sample3 {

	public static void main(String[] args) {
		
		var set = new TreeSet<Meibo>();
		set.add(new Meibo(100,"田中宏"));
		set.add(new Meibo(300,"木村誠一"));
		set.add(new Meibo(100,"田中宏"));
		set.add(new Meibo(1００,"佐藤修"));
//		Meiboレコードオブジェクトのequalsメソッドによって、
//		同じものと判定されると、setには追加されない。
		
		set.forEach(System.out::println);

	}

}
////■実行結果
//Exception in thread "main" java.lang.ClassCastException: class chapter12_2.Meibo cannot be cast to class java.lang.Comparable (chapter12_2.Meibo is in unnamed module of loader 'app'; java.lang.Comparable is in module java.base of loader 'bootstrap')
//Meibo[number=100, name=田中宏]
//Meibo[number=300, name=木村誠一]

//package chapter12_2;
//
//public record Meibo(int number, String name) 
//	implements Comparable<Meibo>{
////	↑Comparableを実装したので、定義されている抽象メソッドをオーバライドする
////	必要がある。
//
//	@Override
//	public int compareTo(Meibo o) {
//		return Integer.compare(this.number, o.number);
//	}
//}
