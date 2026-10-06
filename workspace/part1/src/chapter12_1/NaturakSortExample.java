package chapter12_1;

import java.util.Arrays;
import java.util.Comparator;

public class NaturakSortExample {

	public static void main(String[] args) {
		var list
			= Arrays.asList(
					"berry","banana","peach","apple","orange");
		list.sort(Comparator.naturalOrder());
//		list.sort((o1, o2) -> o1.compareTo(o2));
//		👆ラムダ式を使って、比較のアルゴリズムを書く、
//		この書き方でも同じ結果になるとのこと。
//		compareToはString型のメソッドで結果をint型で返す？とのこと？
		list.forEach(System.out::println);
//		naturalOrder()は
//		インターフェースのstaticメソッドとのこと。
//		⇒クラスメソッドとはどう違う？どんな目的でインターフェースに
//		外部から関数的に使えるstaticメソッドを実装する？
//		⇒そもそもなぜインターフェースにstaicメソッドを持てる様にしたの？
	}

}
//apple
//banana
//berry
//orange
//peach