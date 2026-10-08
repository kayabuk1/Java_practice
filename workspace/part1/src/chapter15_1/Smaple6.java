package chapter15_1;

import jp.kwebs.lib.Input;

public class Smaple6 {

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
