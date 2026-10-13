package chapter15_1;

enum Genre {
	LITERATURE,
	SCIENCE,
	CULTURE
}
//Javaには 「1つの .java ファイルの中に、public なトップレベル型
//（クラス・enum・recordなど）は1つしか書けない」 というルールがある。
//Javaのコンパイラとファイル構造には、以下の2つの原則があります。
//public な型は1ファイルに1つだけ
//public な型の名前は、ファイル名（.java）と完全に一致しなければならない。
//そのため、enumには修飾子を何も付けられない。

public record Book(
		Genre genre, String title, String author)
{
	public static void main(String[] args) {
		Book book 
		= new Book(
				Genre.CULTURE, 
				"日本の祭り", 
				"斎藤孝雄");
		System.out.println(book);	
	}	
	
//	■レコード型定義時にJavaが裏で全自動生成してくれるもの
//	●private final なフィールド（カプセル化）
//	private final Genre genre;
//	private final String title;
//	private final String author; 
//	(※一度作ったら値を変更できない「不変（Immutable）」なオブジェクトになる)
//	※インスタンス定数。インスタンスごとに決まり、後から変更できない値になる。
//	●全フィールドを受け取るコンストラクタ
//	new Book(genre, title, author) で初期化できるようにしてくれる。
//	●アクセサー（ゲッター）メソッド
//	book.genre(), book.title(),book.author() 
//	(※通常のクラスと違い、get が付かない名前（book.genre()）になる)
//	●toString() メソッド
//	System.out.println(book); と書いたときに、
//	Book[genre=CULTURE, title=日本の祭り, author=斎藤孝雄] 
//	と綺麗に出力されるのは、この自動生成された toString() のおかげ。
//	※toString メソッドは、オブジェクトや数値を文字列（String型）に変換して
//	取得するためのメソッド。
//	●equals() と hashCode() メソッド
//	全フィールドの値が同じなら「同じ本」と判定してくれます。
//	※通常はアドレスまで同じでないと同じ判定にならない。

//	 enum型の2つの違いと使い分け
//	 ●Genre.CULTURE(クラス定数を直接渡す)
//	 直接参照（コンパイル時チェック)
//	スペルミスがあればコンパイルエラーで事前に弾いてくれるため、安全で処理も最速。
//	 プログラムのコード内で直接指定する場合（普段はこちらを使います）。
//	 ●Genre.valueOf("CULTURE")(文字列から変換する)
//	 動的変換（実行時チェック）文字列をもとにenumを探す。
//	存在しない文字列（例: "CULTUR"）を渡すと、実行時に
//	IllegalArgumentException でプログラムが停止する。
//	 キーボード入力、ファイル、画面フォーム、データベースなど
//	外部から「文字列」として受け取ったデータをenumに変換したい場合。

}
