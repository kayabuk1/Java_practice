package chapter12_1;

import java.util.Arrays;
import java.util.Comparator;

import chapter11_2.Apple;

public class SortExample {

	public static void main(String[] args) {
		var list = Arrays.asList(
				new Apple(320, "red"),
				new Apple(280, "green"),
				new Apple(350, "green"),
				new Apple(330, "red"),
				new Apple(250, "red")
				);				
		
		list.sort(Comparator.comparing(Apple::weight));
//		↓通常の書き方
//		list.sort(
//			Comparator.comparing(Apple a -> a.weight);
//		↓標準のstatic comparingDoubleメソッドを使う書き方。
//		list.sort(
//			Comparator.comparingDouble(Apple::weight));
		list.forEach(System.out::println);
	}

}
