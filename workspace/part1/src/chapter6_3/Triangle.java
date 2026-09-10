package chapter6_3;
//練習問題6_3_1

public class Triangle {
	private double sideA;
	private double sideB;
	private double sideC;
	
	public Triangle(double a, double b, double c) {
	       if (!isTriangle(a,b,c)) {
//	            System.out.println("※三角形が成立出来ません");
//	    	   ↑ここでもprint文使うのは冗長。道具は道具に徹する。
//	    	   ↓代わりにエラー文を投げてメインプログラムでｺﾝｿｰﾙ出力する
	    	// 文字出力はせず、例外の中に理由メッセージだけを詰めて投げる
	            throw new IllegalArgumentException(
	                "三角形が成立しない値です(a=%.1f, b=%.1f, c=%.1f)"
	            		.formatted(a, b, c)
	            );
//	            エラーｵﾌﾞｼﾞｪｸﾄの名前が難しいね。暗記は難しい。
//	            どうやったら適切なエラーを選べる？
//	            return; 
	            //(a,b,c)=( 0.0, 0.0, 0.0) returnでは不正ｵﾌﾞｼﾞｪｸﾄの作成を防げない
//	            throw new IllegalArgumentException();
//	            ※三角形が成立出来ません
//	            Exception in thread "main" java.lang.IllegalArgumentException
//	            	at chapter6_3.Triangle.<init>(Triangle.java:12)
//	            	at chapter6_3.Triangle.main(Triangle.java:49)
	        }
		this.sideA = a;
		this.sideB = b;
		this.sideC = c;
	}
	public double calcTriangelSurface() {
		double s = (sideA+sideB+sideC)/2;
		double S = Math.sqrt(s*(s-sideA)*(s-sideB)*(s-sideC));
		return S;
	}
	public double getSideA() {
		return sideA;
	}
	public double getSideB() {
		return sideB;
	}
	public double getSideC() {
		return sideC;
	}
	public void setSideA(double sideA) {
		this.sideA = sideA;
	}
	public void setSideB(double sideB) {
		this.sideB = sideB;
	}
	public void setSideC(double sideC) {
		this.sideC = sideC;
	}
	public static boolean isTriangle(double a, double b, double c) {
		return (b + c > a) &&(c + a > b) &&(a + b > c); 
}
	public boolean isTriangle() {
		return isTriangle(sideA, sideB, sideC);
}
	public static void main(String[] args) {
		try {
		Triangle triangle1 = new Triangle(2.5, 3.0, 5.1);
		System.out.println(triangle1.isTriangle());
		System.out.println(
				"面積=%.2f".formatted(triangle1.calcTriangelSurface()));
		System.out.println(
				"(a,b,c)=(%4.1f,%4.1f,%4.1f)".formatted(
						triangle1.getSideA(),
						triangle1.getSideB(),
						triangle1.getSideC()
						));
	    } catch (IllegalArgumentException e) {
	        System.out.println("作成失敗: " + e.getMessage());
	    }
		try {
		Triangle triangle2 = new Triangle(2.5, 3.0, 6.0);
		System.out.println(triangle2.isTriangle());
		System.out.println(
				"(a,b,c)=(%4.1f,%4.1f,%4.1f)".formatted(
						triangle2.getSideA(),
						triangle2.getSideB(),
						triangle2.getSideC()
						));
	    } catch (IllegalArgumentException e) {
	        System.out.println("作成失敗: " + e.getMessage());
	    }
	}
}
/*実行結果
true
面積=2.61
(a,b,c)=( 2.5, 3.0, 5.1)
作成失敗: 三角形が成立しない値です(a=2.5, b=3.0, c=6.0)
*/