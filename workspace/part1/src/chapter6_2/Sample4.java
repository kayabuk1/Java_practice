package chapter6_2;

import chapter6.Tax;

public class Sample4 {
//equals(),hashCode()を使ってみる。
	public static void main(String[] args) {
		Tax t1 = new Tax(100, "田中宏", 300000, 100000);
		Tax t2 = new Tax(100, "田中", 300000, 120000);
		
		if(t1.equals(t2)) {
			System.out.println("等しい");
			System.out.println("t1==t2は"+(t1==t2));
			System.out.println(System.identityHashCode(t1));
			System.out.println(System.identityHashCode(t2));
			System.out.println(
					System.identityHashCode(t1)==System.identityHashCode(t1));
		}
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
	}
}
/*実行結果
 * 等しい
t1==t2はfalse
791452441
834600351
true
131
131
 * Java、Object クラスの仕様「equals() と hashCode() のルール、
 *  equals() で true（等しい）と判定される2つのオブジェクトは、
 *  必ず同じ hashCode()（整数値）を返さなければならない
 */