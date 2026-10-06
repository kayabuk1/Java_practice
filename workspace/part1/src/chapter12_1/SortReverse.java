package chapter12_1;

import java.util.Arrays;
import java.util.Comparator;

import chapter11_2.Apple;

public class SortReverse {

	public static void main(String[] args) {
		var list
		= Arrays.asList(
				"berry","banana","peach","apple","orange");
	list.sort(Comparator.naturalOrder());
	list.reversed().forEach(System.out::println);
	System.out.println();
	
	list.sort(Comparator.reverseOrder());
	list.forEach(System.out::println);
	System.out.println();
	
	var list2 = Arrays.asList(
			new Apple(320, "red"),
			new Apple(280, "green"),
			new Apple(350, "green"),
			new Apple(330, "red"),
			new Apple(250, "red")
			);				
	
	list2.sort(
			Comparator.comparing(
					Apple::weight).reversed());
	list2.forEach(System.out::println);
	System.out.println();
	
	list2.sort(Comparator.comparing(Apple::weight));
	list2.forEach(System.out::println);
	}
}
