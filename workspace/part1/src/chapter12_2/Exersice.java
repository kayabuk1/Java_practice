package chapter12_2;

import java.util.HashMap;

public class Exersice {

	public static void main(String[] args) {
		
		var map = new HashMap<String, User>();
		
		map.put(
				new User("ab123", "田中宏").id(),new User("ab123", "田中宏"));
		map.put(
				new User("ab224", "佐藤修").id(),new User("ab224", "佐藤修"));
		map.put(
				new User("ac331", "木村正一").id(),new User("ac331", "木村正一"));
//		↑ここのすっきりとした書き方はどうしたら良いでしょうか？
		
		map.forEach((id, user)->System.out.println(id+user));
		System.out.println(map.values());
		
//		map.forEach();
//		↑の書き方でvaluesだけ取り出す方法が思いつかない。
		// ラムダ式で書く場合
		map.values().forEach(u -> System.out.println(u));
		// メソッド参照でさらに短く書く場合
		map.values().forEach(System.out::println);
//		Collection型で返ってくる。Collectionは
//		List、Set、Mapの親なのでforEachも拡張for文も使える。
		
//		Collection<User> u = map.values();
//		↑の文が省略されているということらしい。
//		Set<String> str = map.keySet();
//		keyはこうなるらしい。なぜデータ型が異なるのだろうか？
		for(User u : map.values()) {
			System.out.println(u);
		}
		System.out.println();
		System.out.println(map.get("ab224"));
		
		
		System.out.println(map.containsKey("ab224"));
		System.out.println(map.containsValue(new User("ab224", null)));
//		レコードでhashCode,equalsをオーバライドしているので true が返ってくる。
		System.out.println(map.keySet());
//		[ab123, ab224, ac331]
	}
	
}
//ab123User[id=ab123, name=田中宏]
//ab224User[id=ab224, name=佐藤修]
//ac331User[id=ac331, name=木村正一]
//[User[id=ab123, name=田中宏], User[id=ab224, name=佐藤修], User[id=ac331, name=木村正一]]
//User[id=ab123, name=田中宏]
//User[id=ab224, name=佐藤修]
//User[id=ac331, name=木村正一]
//
//User[id=ab224, name=佐藤修]