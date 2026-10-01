package chapter11_2;

import java.util.List;
import java.util.function.Predicate;
//↑Javaの標準ライブラリの関数型インターフェースを使ってみる。

public class Sample2 {

	public static void main(String[] args)
	{
		testApple(a -> a.wight() >= 300);
	}
	
	public static void testApple(Predicate<Apple> p) 
	{
//		ｲﾝﾀｰﾌｪｰｽ：Predicate<T>
//		抽象メソッド:boolean test(T t)
//		機能：T型（総称型）を使って何かの条件を判定する。
//		Tには別章で作った Tax型も入れられる。※要ﾒｿｯﾄﾞ書換え
		
		var list = getAppleList();
		for (Apple apple : list)
		{
			if(p.test(apple)) 
//			↑p.testメソッドの引数の型が Apple t に変わっている。	
			{
				System.out.println(apple);
			}
		}
		System.out.println();
	}
	
//	Appleのリストを返すメソッド
	public static List<Apple> getAppleList() 
	{
		var list = List.of(
				new Apple(320, "red"),
				new Apple(280, "green"),
				new Apple(350, "green"),
				new Apple(330, "red"),
				new Apple(250, "red")
				);
		return list;
	}
}
