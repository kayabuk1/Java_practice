package chapter7_2;

import chapter7_4.Function;
import chapter7_4.NoConstructor;
import chapter7_4.NoField;

public class Sample1 {

	public static void main(String[] args) {
		Joining j = new Joining("", ",");
		Joining k = new Joining("-");
		
		j.add("apple");
		j.add("banana");
		j.add("peach");
		System.out.println(j.getCsv());
		
		k.add("apple");
		k.add("apple");
		k.add("apple");
		System.out.println(k.getCsv());
		
		Joining l = new Joining();
//		l.delimter = ","はする必要ないし、privateの為
//		出来ない。privateでもコンストラクト時にだけは、
//		フィールド変数にアクセス出来るの不思議だなと。
//		→private アクセス修飾子の本当のルールは、
//		「そのクラスの { } の内側に書いてあるコードから
//		なら、いつでも自由に見たり書き換えたりできる」
//		というもの
		l.add("apple");
		l.add("banana");
		l.add("peach");
		System.out.println(l.getCsv());
		
//		■↓デフォルトコンストラクタ
		NoField nf = new NoField();
		nf.print();
//		↓コンストラクタを使わないフィールド変数の初期化
		NoConstructor nc = new NoConstructor();
		System.out.println(nc.getNumber());
		System.out.println(nc.getStr());
//		■↓もし１つでもコンストラクタを作ると、
//		ﾃﾞﾌｫﾙﾄｺﾝｽﾄﾗｸﾀは作られない。
//		Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
//		コンストラクター NoConstructor() は未定義です
//		at chapter7_2.Sample1.main(Sample1.java:38)
//		public NoConstructor() {} クラスに空のｺﾝｽﾄﾗｸﾀを作ればOK
		
//		■↓練習問題7-2-2
		Function fn1 = new Function(0,1);
		Function fn2 = new Function(2);
		Function fn3 = new Function();
		fn1.result();
		fn2.result();
		fn3.result();
}

}
