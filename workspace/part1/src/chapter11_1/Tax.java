package chapter11_1;
//ラムダ式

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
//		◆引数が、インターフェース型
//		◆かつ　関数インターフェース型（メソッドが1つだけ）
//		でないとラムダ式が使えないことに注意。
		
		Tax tax1 = new Tax(100, "田中宏", 150);
		
//		int zei1 = tax1.zeigaku(new Rate1());
//		👆を書き換えてラムダ式にする。
//		↓参考：Rate1.taxRateメソッドの記述
//			public double taxRate(double shotoku) {
//			return shotoku > 100 ? 0.1 : 0.05;
		int zei1 = tax1.zeigaku(
				shotoku -> shotoku>100 ? 0.1 : 0.05);
//		実はラムダ式を実行するときに一時的な無名クラスを作って
//		その無名クラスからインスタンスを生成するということまで、
//		この一文で一気に行ってしまっているとのこと。
		System.out.println(tax1.getName()+"\t"+zei1+" 税1");

		Tax tax2 = new Tax(100, "田中宏", 150);
//		int zei2 = tax2.zeigaku(new Rate2());
		
		RateIntf rate = gaku -> gaku>80 ? 0.12 : 0.4;
		int zei2 = tax2.zeigaku(rate);
//		↑の様に書いても同じ結果になる。
//		左辺の RateIntf rate に代入されているのは、
//		double の値ではなく 「RateIntf を実装した匿名オブジェクト
		// 👇 ラムダ式を使わない従来の書き方
//		RateIntf rate = new RateIntf() {
//		    @Override
//		    public double taxRate(double gaku) {
//		        return gaku > 80 ? 0.12 : 0.4; // ← doubleを返すのはメソッドの中身！
//		    }
//		};
		
//		int zei2 = tax2.zeigaku(
//				(double shotku) 
//					-> {return shotku > 80 ? 0.12 : 0.4;});
		System.out.println(tax2.getName()+"\t"+zei2+" 代入ラムダ税2");
		
//		◆↓メソッドの戻り値にラムダ式を使うパターンここから
		Tax tax3 = new Tax(100, "田中宏", 150);
		int zei3 = tax3.zeigaku(getRate(3));
		
		System.out.println(tax3.getName()+"\t"+zei3+" switch税3");
//		引数にインターフェースとして定義されているRateIntf型が
//		指定されていて、それを実装したクラスが実際になくても、
//		ラムダ式の記述で無名のクラスがインターフェースを実装して
//		処理を行って戻り値を返していることになる
	}
	
//		◆↓メソッドの戻り値にラムダ式を使うパターンgetRate()本体
	static RateIntf getRate(int num) {
		RateIntf result = null;
		
//		switch分でrate1-3いずれかｲﾝｽﾀﾝｽを
//		ラムダ式で生成してresultに代入
		result = switch(num) {
		case 1 -> shotoku -> shotoku > 100 ? 0.1 :0.05;
		case 2 -> shotoku -> shotoku > 80 ? 0.12 :0.04;
		case 3 -> shotoku -> shotoku <160 ? 0.001875*shotoku : 0.3;
		default ->  shotoku -> shotoku*0.1;
		};
		return result;
	}

}















