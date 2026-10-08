package chapter15_1;
//列挙定数の使い方：同値判定

public class Sample5 {

	public static void main(String[] args) {
		
		var a = Size.SMALL;
		System.out.println(a == Size.LARGE);
		System.out.println(a != Size.LARGE);
		System.out.println(a.equals(Size.LARGE));
	}
}
//false
//true
//false
