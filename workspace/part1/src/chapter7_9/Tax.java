package chapter7_9;
//イミュータブルなクラス
//・セッターを削除
//・フィールド変数にfinal修飾子を追加
//・クラス宣言にもfinal

import java.util.Objects;

public final class Tax {
	private final int number;
	private final String name;
	private final int shotoku;
	private final int koujo;

	public Tax
	(int number, String name, int shotoku, int koujo)
	{
		this.number = number;
		this.name = name;
		this.shotoku = shotoku;
		this.koujo = koujo;
	}
	public int zeigaku() {
//		this.number = 10;←これをするとエラーになる。
//		ｺﾝｽﾄﾗｸﾀの中でのみかつ１度のみ初期値がセットできる。
		return (int)((this.shotoku - this.koujo)*0.1);
	}

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
	
//	public void setNumber(int number) {
//		this.number = number;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public void setShotoku(int shotoku) {
//		this.shotoku = shotoku;
//	}
//	public void setKoujo(int koujo) {
//		this.koujo = koujo;
//	}
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
