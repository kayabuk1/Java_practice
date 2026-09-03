package chapter2_9;
import jp.kwebs.lib.Input;
public class Exercise2_9_1 {

	public static void main(String[] args) {
		String str = Input.getString("変数 str =");
		System.out.println(
				str.equals("abc")+"\n"
				+ str.length()+"\n"
				+str.replace("a", "xxx")
				);

	}

}
