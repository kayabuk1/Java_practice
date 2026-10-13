package chapter15_1;

import jp.kwebs.lib.Input;

enum Size{
	SMALL,
	MEDIUM,
	LARGE
}
//インクルード部？で定義してもそのファイル内のみで有効な列挙型として
//使うことができる。グローバル変数？
//⇒これはなぜ？
//クラス定義とここの定義はコメントアウトせずにもコンパイルエラーにならないのはなぜ？
//① クラスの外（パッケージ直下）の enum
//正式名：chapter15_1.Size


public class Smaple6 {
	
	private enum Size {
//		クラス定義と同じファイルに列挙型を定義することが出来る。
//		⇒なぜprivate付ける？
// ② クラスの内側の enum
//正式名：chapter15_1.Smaple6.Size
		SMALL,
		MEDIUM,
		LARGE
	}
//	Javaコンパイラから見ると、この2つの Size はまったく別の型として管理されている。
//	① 外側の Size（トップレベル列挙型）： 
//	chapter15_1 パッケージ全体からアクセスできる列挙型
//	（グローバル変数ではなく、パッケージ内で共有される型）。
//	② 内側の Size（ネストした列挙型）： Smaple6 クラスの内部に所属する列挙型。
//	Smaple6 クラスの中で Size と書いた場合、
//	Javaは 「より自分に近い内側の定義（②）」を優先して参照 する。
//	これをシャドーイング（遮蔽） と呼ぶ。
//	外側と内側でスコープ（住む世界）が異なるため、
//	名前が被っても衝突せず、コンパイルエラーにならない。

	public static void main(String[] args) {
		
		String e = Input.getString().toUpperCase();
		Size s = Size.valueOf(e);
//		s = null;
		
		switch(s) {
		case SMALL -> System.out.println(Size.SMALL);
		case MEDIUM -> System.out.println(Size.MEDIUM);
		case LARGE -> System.out.println(Size.LARGE);
		default -> System.out.println("どれでもありません");
//		↑default 入れなくてもコンパイルエラーにはならない。
//		.IllegalArgumentException: No enum 
//		constant chapter15_1.Size.１」
//		deaultを入れても 変な入力するとエラー。なぜだろうか？
		}
	}

}
