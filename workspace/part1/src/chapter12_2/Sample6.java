package chapter12_2;

import java.util.TreeMap;

public class Sample6 {

	public static void main(String[] args) {
		
		var map 
			= new TreeMap<Integer, String>();
//		↑Setでは別で独自のレコード型を定義してそれを
//		<>に入れていたので、オーバライドが必要だった。
		
		map.put(205, "田中修");
		map.put(100, "木村正一");
		map.put(300, "佐藤修");
		
		System.out.println(map.get(100));
		System.out.println(map.get(150));
		
		map.forEach(
				(k,v)->System.out.println(k+" "+v));
		map.reversed().forEach(
				(k,v)->System.out.println(k+" "+v));
	}

}
//木村正一
//null
//100 木村正一
//205 田中修
//300 佐藤修
//300 佐藤修
//205 田中修
//100 木村正一