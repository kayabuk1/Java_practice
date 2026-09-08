package chapter4_2;
//可変長引数

public class Sample2 {

	public static void main(String[] args) {
		calc(10, 20, 30);
		calc(10, 20, 30, 40);
	}
	public static void calc(int... numbers) {
//		↑の int... という書き方が可変長引数
//		内部的にはint[] numbersと宣言したのと同意で、
//		配列として受け取ることになる。実体はintの配列型。
//		↓なので拡張for分で一つずつ値を受け取ることができる。
//		◆メリット：呼び出し時に配列と意識せずに、上のcalcの様に、
//			普通の数を渡してOKになる。
//		※実はSystem.out.printf(
//		String format,Object... args)と可変長引数になっている。
		for(int n: numbers) {
			System.out.print(n+" ");
		}
		System.out.println();
	}

}
