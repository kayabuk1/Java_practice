package chapter6_2;

import chapter6.Tax;

public class Sample3 {

//	toString()の実行
//	toString()の追加別ファイル
//	@Override
//	public String toString() {
//		return "Tax ["
//				+ "number=" + number + ", name=" + name + ","
//						+ " shotoku=" + shotoku + ", koujo=" + koujo + "]";
	public static void main(String[] args) {
		Tax tax = new Tax(100, "田中宏", 300000, 100000);
		System.out.println(tax);
		System.out.println(tax.toString()); //これでも同じ出力結果になる
//実行結果
//		Tax [number=100, name=田中宏, shotoku=300000, koujo=100000]
//		
//		toStringを設定しない場合
//		chapter6.Tax@2ff4acd0
	}

}
