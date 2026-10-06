package chapter12_1;
//コレクションフレームワーク：List：forEachメソッド

import java.util.List;

import chapter11_2.Apple;

public class ForEachExample {

	public static void main(String[] args) {
		var list = getAppleList();
		list.forEach(t -> System.out.println(t));
//		ラムダ式の t -> は、「これから1つずつ送られてくる要素を、
//		この処理の中では t という名前で扱います」という仮引数の宣言
		// ① 従来の拡張 for 文の
//		for (Apple t : list) {
//		    System.out.println(t); // ← この t と同じ！
	}
	
	public static List<Apple> getAppleList() {
		var list = List.of(
				new Apple(320, "red"),
				new Apple(350, "green"),
				new Apple(250, "red")
				);
		return list;
				
		
	}

}
/*■forEachメソッド定義
void java.lang.Iterable.forEach(
Consumer<? super Apple> action
)


forEach
default void forEach(Consumer<? super T> action)
Iterableの各要素に対して指定されたアクションを、すべての要素が処理されるか、アクションが例外をスローするまで実行します。 反復の順序でアクションが実行されます(その順序が指定されている場合)。 アクションによってスローされた例外は、呼出し側に中継されます。
このメソッドの動作は、オーバーライドするクラスが同時変更ポリシーを指定していないかぎり、要素の基礎となるソースを変更する副作用をアクションが実行する場合には指定されません。

実装要件:
デフォルト実装の動作は次のようになります。


     for (T t : this)
         action.accept(t);
 
パラメータ:
action - 各要素に対して実行されるアクション
スロー:
NullPointerException - 指定されたアクションがnullである場合
導入されたバージョン:
1.8
*/