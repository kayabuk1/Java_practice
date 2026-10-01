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
//		税率は変わるので、引数で定義した税率を返すメソッドを実装した
//		RateIntｆ型(それを実装したクラスインスタンス)を渡し、変更に対応出来る様にする。
//		Javaではメソッドをそのまま渡せないので、渡すときは、
//		tax.zeigaku(new Rate１（）；)の様にインスタンスを生成しながら渡す。
//		※この時にアップキャストが行われている。
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
	
	public static void main(String[] args) 
	{	
		Tax tax1 = new Tax(100, "田中宏", 150);
		int zei1 = tax1.zeigaku(new Rate1());
		System.out.println(tax1.getName()+"\t"+zei1+" 税1");
		
		Tax tax2 = new Tax(100, "田中宏", 150);
		int zei2 = tax2.zeigaku(new Rate2());
		System.out.println(tax2.getName()+"\t"+zei2+" 税2");
		
		Tax tax3 = new Tax(100, "田中宏", 150);
		int zei3 = tax3.zeigaku(new Rate3());
		System.out.println(tax3.getName()+"\t"+zei3+" 税3");
	}
}
