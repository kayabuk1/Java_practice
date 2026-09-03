package chapter3_3;

import java.util.List;

public class Sample3 {

	public static void main(String[] args) {
		var list = List.of(10, 20, 30);
		for (int/*Integerと書いても正しく動く*/ n: list) {
//			list.add(40);追加はList.ofでは出来ない。
//			Exception in thread "main" java.lang.UnsupportedOperationException
//			at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
//			at java.base/java.util.ImmutableCollections$AbstractImmutableCollection.add(ImmutableCollections.java:147)
//			at chapter3_3.Sample3.main(Sample3.java:10)

			System.out.println(n);
		}
	}

}
