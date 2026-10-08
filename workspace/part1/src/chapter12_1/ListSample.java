package chapter12_1;

import java.util.ArrayList;
import java.util.List;

import chapter11_2.Apple;

//List操作練習

public class ListSample {

	public static void main(String[] args) {
//		１．空のリストを作成
		List<Apple> applelist = new ArrayList<Apple>();
		
		applelist.forEach(a -> System.out.println(a));
		
//		リストに要素を追加
		applelist.add(new Apple(320, "red"));
		applelist.add(new Apple(280, "green"));
		applelist.add(new Apple(350, "green"));
		applelist.add(new Apple(330, "red"));
		applelist.add(new Apple(250, "red"));
		
//		applelist.remove(2);
//		350greenを削除※３番目
//		↓実は removeメソッドは引数がObject型のもので、
//		  オーバライドされているとのこと。※removeが２種ある。
//		applelist.remove(Object);

//		greenAppleだけのリストを作る。
		List<Apple> greenAppleList
			= new ArrayList<Apple>();
		
//		applelist.forEach(a -> System.out.println(a));
//		↓getメソッドを使い、通常のfor文で書くと。
//		for (int i=0; i < applelist.size(); i++) {
//			Apple apple = applelist.get(i);
//			if(apple.color().equals("green")) {
//				greenAppleList.add(apple);
//			}
//		}
		// 後ろ（末尾）からループを回すのがコツ
		for (int i = applelist.size() - 1; i >= 0; i--) {
			
		    if (applelist.get(i).color().equals("green")) {
		        // ① appleList.remove(i) で削除して
//		    	「削除されたApple」が返る。
		        // ② 返ってきたAppleをそのまま 
//		    	greenList.add(...) に渡すと削除しながら2つのリストが
//		    	作れる。要素の分離？
		        greenAppleList.add(applelist.remove(i));
		        
		    }
		}
//		greenAppleList.forEach(System.out::println);
		
//		元の林檎リストからgreenappleを削除
		for (Apple ga: greenAppleList) {
			System.out.println(applelist.remove(ga));
//			remove(Object)に渡すのは完全に同じオブジェクトでないと
//			いけないとのことです？
//			Appleはレコードなので、equalsメソッドが自動生成される
//			為、.remove(new Apple(320, "red"))としても、
//			同じインスタンス判定されて消すことが出来るとのこと。
//			↑実行結果としてbooleanを返しているのを忘れずに。
		}
		applelist.forEach(System.out::println);
		// 条件に合うものを「全件」直接消す（一時的なリスト作成も不要！）
//		applelist.remove「If」(a -> a.color().equals("green"));
//		こういうのもあるらしい。
	}
}
//■実行結果
//true
//true
//Apple[weight=320.0, color=red]
//Apple[weight=330.0, color=red]
//Apple[weight=250.0, color=red]



















