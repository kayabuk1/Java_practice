package chapter15_1;

import java.util.Arrays;

//列挙型

public class Sample1 {

	public static void main(String[] args) {
		Size s  = Size.LARGE;
//		Size.SMALL = Size.LARGE;
//		final フィールド Size.SMALL には代入できません
		
		System.out.println(Size.SMALL.name());
//		列挙型は内部に名前と序数を持っている
//		SMALL
		System.out.println(Size.SMALL.ordinal());
//		0
		
		System.out.println(Size.values());
//		[Lchapter15_1.Size;@2ff4acd0
		for(Size ss: Size.values()) {
			System.out.println(ss.name() + ":" + ss.ordinal()+"\n");
//			SMALL:0
//			MEDIUM:1
//			LARGE:2
		}
		
		Size[] sss = {Size.MEDIUM, Size.LARGE, Size.SMALL};
//		↑列挙Size型配列を作ることも出来る。
		Arrays.sort(sss);
		for(Size s1 : sss) {
			System.out.println(s1.name()+":"+s1.ordinal());
//			列挙型もクラスなので、メソッドを使うことができる。
		}
//		SMALL:0
//		MEDIUM:1
//		LARGE:2
	}

}
//もし enum を使わずに同じことを再現すると
//と、先生が何も水に書いてくれたが、AIの君が
//出してくれたのと変わらずとてもすごい、、、。
//どうしたら、自分もこんな風に、知識がつながって、
//文法や構文やコードがポンポン
//出てきて、組み立てられる様になるのだろうか、、、。
//プログラミングの授業を受けても何となく知っている。
//何となくそんなのあったかなというレベルで、自分では書けない。
//どうしたら良いのだろうか、、、。
//客観的な意見をください。
//public class Size {
//	public static final SMALL;
//	public static final MEDIUM;
//	public static final LARGE;
//	
//	private int ordinal;
//	private String name;
//	
//	private Size() {
//		SMALL = new Size(0, "SMALL");
//		MEDIUM = new Size(1, "MEDIUM");
//		LARGE = new Size(0, "LARGE");
//	}
//	private Size(int ordinal, String name) {
//		this.ordinal = ordinal;
//		this.name = name;
//	}
//}更にゲッターなどが整備されている。














//package chapter15_1;
//public enum Size {SMALL, MEDIUM, LARGE}
//・enum型とクラスとは別の独自の型？が用意してある程なのか。
//・なんだかこれまでのjavaの書き方と比べて違う感じで違和感がある
//・インスタンスが生成できないのはなぜ？
//・変数だけれど列挙「定数」というのも何だか不思議な感じ
//C言語であらかじめ内部的に、0,1,2....というの数字だけの
//配列があってそれに名札を貼っていくイメージと聞いたけれど
//javaのenumの仕組みもそれに近いの？
//変数SMALL=0みたいな処理が内部的に行われている？

//クラス変数なので、Size.LARGEのように、
//列挙名とドットで連結して使わなければならないのは何故だっけ？
//・なぜStatic付いている？
//●上記のコメントや疑問点、どんな仕組みになっているのか
//教えてください。