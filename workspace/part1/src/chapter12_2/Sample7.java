package chapter12_2;

import java.util.LinkedHashMap;

public class Sample7 {

	public static void main(String[] args) {
		
		var map 
			= new LinkedHashMap<Integer, String>();
		map.put(205, "田中修");
		map.put(100, "木村正一");
		map.put(300, "佐藤修");
		
		System.out.println(map.get(100));
		System.out.println(map.get(150));
		
		map.forEach(
				(k,v)->System.out.println(k+" "+v));
//		map.forEach(System.out::println);
//		↑これだとエラー。
//		この行に複数マーカーがあります
//		- 型 PrintStream は、ここで適用可能な println (Integer, String) を定義していませ
//	ん- 型 HashMap<Integer,String> のメソッド forEach(BiConsumer<? super 
//	Integer,? super String>) は引数 (System.out::println) に適用できません
	}

}
//null
//null
//205 田中修