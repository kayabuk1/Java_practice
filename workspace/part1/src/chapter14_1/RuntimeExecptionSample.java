package chapter14_1;

import java.util.ArrayList;

//非検査例外（コンパイルは通る）発生テストサンプル

public class RuntimeExecptionSample {

	public static void main(String[] args) {

		try {
			//		◆ArithmeticException※ ０ による徐算など
			int a = 2/0;
		} catch (Exception e) {
			System.err.println("ArithmeticExcepption");
		}
		
		try {
	//		◆NullPointerException ※nullの参照エラー
			String str = null;
			str.equals("abc");
	//		 java.lang.NullPointerException: Cannot invoke "String.equals(Object)" because "str" is null
	//		⚠null ポインター・アクセス: 
	//		変数 str はこのロケーションでは必ず null です
	//		という警告は左に出てくれる。
			
			System.out.println(str);
		} catch (Exception e) {
			System.err.println("NullPointerException");
		}
		
		try {
	//		◆IndexOutOfBoundsException※ﾘｽﾄ範囲外アクセス
			var list = new ArrayList<String>();
			System.out.println(list.get(1));
	//		java.lang.IndexOutOfBoundsException:
	//		Index 1 out of bounds for length 0
	//		※空なのに インデックス１ にアクセスしようとしました。
	} catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException");
	}
try {
	//		◆ArrayIndexOutOfBoundsException※配列範囲外エラー
			int[] nums = new int[5];
			nums[5] = 10;
	//		宣言時は要素数 ５ と宣言するが、アクセスは0~4
	// java.lang.ArrayIndexOutOfBoundsException: 
	//		Index 5 out of bounds for length 5
} catch (ArrayIndexOutOfBoundsException e) {
	System.err.println("ArrayIndexOutOfBoundsException");
}
	
try {
		//◆ClassCastException ※矛盾したダウンキャスト
		NullPointerException ex =
				(NullPointerException) new Exception();
//	class java.lang.Exception cannot be cast to
//	class java.lang.NullPointerException
//	(java.lang.Exception and java.lang.
//	NullPointerException are in module 
//	java.base of loader 'bootstrap')
//	
	} catch (ClassCastException e) {
		System.err.println("ClassCastException");
	}









		
		
	}

}
