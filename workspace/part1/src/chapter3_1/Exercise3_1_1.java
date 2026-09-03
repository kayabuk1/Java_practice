package chapter3_1;

public class Exercise3_1_1 {

	public static void main(String[] args) {
		double [] data = new double [0];
		data = new double[] {0.3, 1.05, 2.2};
		double sum = 0.0;
		for (int i=0;i<data.length;i++) {
			sum += data[i];			
		}
		System.out.println("合計=%.2f".formatted(sum)+"\n" 
				+"平均＝%.2f".formatted(sum/data.length));
		/*実行結果：
合計=[D@279f2327
平均＝1.0
合計=3.0
平均＝1.0
合計=3.55
平均＝1.18

		 */
		

	}

}
