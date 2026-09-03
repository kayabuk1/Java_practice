package chapter2_9;
import jp.kwebs.lib.Input;
public class Sample1 {

	public static void main(String[] args) {
		String name = Input.getString("名前");
//		↑Input.まで入力→補完するとgetStringが
//		取る引数によって複数種表示される。
//		今回は文字列が指定されているのでそれを使う
		System.out.println("長さ" + name.length());
		System.out.println("先頭文字" + name.charAt(0));

	}

}
