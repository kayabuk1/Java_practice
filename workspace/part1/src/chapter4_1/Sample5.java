package chapter4_1;

public class Sample5 {
//	オーバロード

	public static void main(String[] args) {
		double ans1 = menseki(5.5);
			//// 👈 引数が1つなので、円の面積を呼ぶ
		double ans2 = menseki(12, 2.5);
			//// 👈 引数が2つなので、四角形の面積を呼ぶ
		
		System.out.printf("円の面積 = %.2f%n", ans1);
		System.out.println(
				"四角形の面積 = %.2f".formatted(ans2));
//		System.out.printl↓ここでCtrl+space押すと今まで使っていた
//		メソッドもオーバーロードされていたことが分かる。
//		OSによる改行コードの違いをJavaが裏で吸収してくれる
//		Windows で動いていれば、自動的に \r\n (CRLF) に翻訳
//		MacやLinux で動いていれば、自動的に \n (LF) に翻訳
	}
		public static double menseki(double hankei) {
			double s = Math.pow(hankei, 2)*Math.PI;
			return s;
		}
		public static double menseki
		(double height,double width) {
			double s = height*width;
			return s;
		}

	}
