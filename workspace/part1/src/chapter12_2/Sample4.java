package chapter12_2;

import java.util.HashMap;

public class Sample4 {

	public static void main(String[] args) {
		
		var map = new HashMap<Integer, String>();
		map.put(205, "田中修");
		map.put(100, "木村正一");
		map.put(300, "佐藤修");
//		通常はmapも順序は保持されない。
//		順番を反映させたい場合はLinkedHashMap<K, V>
		System.out.println(map.remove(300));
		System.out.println(map.remove(150));
		
		map.forEach(
				(k,v)->System.out.println(k+" "+v));
	}
}
