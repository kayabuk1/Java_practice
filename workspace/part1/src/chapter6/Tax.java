package chapter6;
//オブジェクト指向：
//Taxオブジェクトを定義し、メソッドを定義する。
//　mainメソッドが無いのでこのプログラムだけでは実行できない。

import java.util.Objects;

public class Tax  extends Object{
//	↓ここがフィールドというもの。フィールドって？
	private int number;
	private String name;
	private int shotoku;
	private int koujo;
	
//	↓ソース→フィールドを利用して～コンストラクタを生成→super()呼出省略✅
	public Tax
	(int number, String name, int shotoku, int koujo)
	{
		this.number = number;
		this.name = name;
		this.shotoku = shotoku;
		this.koujo = koujo;
	}
	public int zeigaku() {
//		税額を計算して int にキャストして返す。
		return (int)((this.shotoku - this.koujo)*0.1);
//		↑this.を付けたほうがどのshotokuを使っているかが解ってより良い。
	}
//2026年9月10日追記：ゲッター、セッターの追加
//	※ちなみに必ずゲッター・セッターを作らなくてもよい。
//	機密にしたい内部データはprivateだけよい。
	public int getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public int getShotoku() {
		return shotoku;
	}
	public int getKoujo() {
		return koujo;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setShotoku(int shotoku) {
		this.shotoku = shotoku;
	}
	public void setKoujo(int koujo) {
		this.koujo = koujo;
	}
//	toString()の追加
	@Override
	public String toString() {
		return "Tax ["
				+ "number=" + number + ", name=" + name + ","
						+ " shotoku=" + shotoku + ", koujo=" + koujo + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(number));
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
//			↑this.が省略されている。
			return false;
		Tax other = (Tax) obj;
//		引数で渡されたobjをTaxクラスにキャストしてotherに代入
//		※引数として受け取った時はObject型なので、Taxクラスの
//		フィールドにアクセスできない。
		return number == other.number;
//		this.numberの省略形　比較結果をbooleanで返す。
	}
	
}
