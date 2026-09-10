package chapter6_2;

public class Rectangle {
	private double bottom;
	private double height;
	
	public Rectangle(double bt, double ht) {
		this.bottom = bt;
		this.height = ht;
	}
	public static double calcRectArea(double bt,double ht)
	{	
//		あまりこういう書き方は設計上しないとのこと。四角形オブジェクトでなくて、
//		計算ツールクラスみたいなものを作ってそこに所属させるのが良いとのこと。
		double area = bt*ht;
		return area;
	}
	public double calcRectArea(){
		double area = calcRectArea(this.bottom, this.height);
		return area;
	}
}
//別ファイルで呼び出した時
//Calc_Rectangle rc = new Calc_Rectangle(10.0, 5.0);
//System.out.println("面積=%.1f".formatted(rc.calcRecArea()));
//面積=50.0