package chapter11_2;

import java.util.List;

public class Sample1 {

	public static void main(String[] args)
	{
		testApple(new Select_1());
//		◆new Select_1の実装内容
//		public class Select_1 implements Predicate {
//			@Override
//			public boolean test(Apple a) {
//				return a.wight() >= 300;
//				※復習：レコードのゲッターは、フィールド名に()つけるだけ。
//			}
//		}
//		◆testApple(new Select_1());ラムダ式で置き換えると
//		①まず匿名クラス（無名クラス）で書いてみる。
		testApple(new Predicate() {
			@Override
			public boolean test(Apple a) {
				return a.wight()>300;
			}
		});
//		先生曰く、分解して書くと↓の様とのこと。
//		通常Predicateは ｲﾝﾀｰﾌｪｰｽ なので、ｺﾝｽﾄﾗｸﾀが無い。
//		なので、 Predicate p = new Predicate();
//		と書くとコンパイルエラーになってしまう。
//		↓の様に{}クラス定義内容を付け足して抽象メソッドをｵｰﾊﾞｰﾗｲﾄﾞすれば、
//		エラーにならない。
//		ラムダ式登場前（ver8まで）はこの匿名クラスを使っていたとのこと。
//		⚠注意：ラムダ式＝匿名クラスではないとのこと。
//					複数ﾒｿｯﾄﾞ記述する匿名クラスはラムダ式で置換することはできないとのこと。
//		Predicate p = new Predicate() {
//			@Override
//			public boolean test(Apple a) {
//				return a.wight()>300;
//			}
//		};
//		testApple(p);
//		②次に書かなくてもコンパイラが分かるものを削る。
		
		int min = 30;
		testApple
		(
//			new Predicate() ←引数の型は
//				testAppleメソッドでPredicateと定義されているので不要 
//			{ 
//				@Override
//				public boolean test(Apple　←親ｲﾝﾀｰﾌｪｰｽ型で引数はApple型と定義されているので不要。
				
//				↑Predictｲﾝﾀｰﾌｪｰｽ実装クラスから生成ｲﾝｽﾀﾝｽを丸ごと渡すので、
//				次は抽象メソッドの定義が書かれていなければならない。
//				そして関数型インターフェース（testという抽象メソッドが1つだけ）
//				なので、書かずともどのメソッドか分かる。
				
					a -> //← ->アロー演算子は書き足す必要がある。
					
//				)　←引数が1つの時は()は不要。 
//			  {
//				return
//				↑処理が a.wight() > 300 という1つの式
//					（判定結果を返すだけ）の場合、{ return ...; } と
//					書かなくても「この式の計算結果（true または false）を
//					そのまま返すんだな」と分かる。
//					そのため、{} と return と ; をセットで全部削れる。
					
//						a.wight()>300
//						a.color().equals("green")
						{int max = 150;
						max+=50;
						max = 200;
//						min = 100;
//						ラムダ式の 「中で作った変数」なら自由に変更OK
//						外で作った変数を中で書き換えるのはNG
						return a.color().equals("red")
						&& a.wight()>Predicate.num+max;}
//						↑中の具体的な処理内容だけ残る。
//						;
//			  }
//		    }
		);
	}
//	◆↓Appleレコードの定義
//	public record Apple(double wight, String color) {}
	
	public static void testApple(Predicate p) 
	{
		var list = getAppleList();
		for (Apple apple : list)
		{
			if(p.test(apple)) 
			{
//			↑Predicate型のｲﾝｽﾀﾝｽはApple型をチェックする
//				メソッドを持っている。のでtestAppleで引数で受け取って、
//				中でp.test(apple)でApple型を渡している。
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
