package chapter10_2;
//オブジェクト指向：
//Taxオブジェクトを定義し、メソッドを定義する。
//　mainメソッドが無いのでこのプログラムだけでは実行できない。

public class Tax  extends Object{
	private long number;
	private String name;
	private int shotoku;
	
//	↓ソース→フィールドを利用して～コンストラクタを生成→super()呼出省略✅
	public Tax
	(int number, String name, int shotoku)
	{
		this.number = number;
		this.name = name;
		this.shotoku = shotoku;
	}
	public int zeigaku(RateIntf r) {
		return (int)(shotoku * r.taxRate(shotoku));
	}
	
	public long getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public int getShotoku() {
		return shotoku;
	}
	
//	toString()の追加
	@Override
	public String toString() {
		return "Tax ["
				+ "number=" + number + ","
						+ " name=" + name + ","
						+ " shotoku=" + shotoku
						+"]";
	}
	
	public static void main(String[] args) {
		
					Tax tax = new Tax(100, "田中宏", 150);
					int zei = tax.zeigaku(new Rate1());
					System.out.println(tax.getName()+zei);
		
		
	}
}
