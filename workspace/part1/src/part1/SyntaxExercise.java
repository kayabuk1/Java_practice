package part1;

public class SyntaxExercise {

	public static void main(String[] args) {
		System.out.println("=== 課題1 ===");
        runTask1();

        System.out.println("\n=== 課題2 ===");
        runTask2();

        System.out.println("\n=== 課題3 ===");
        runTask3();

        System.out.println("\n=== 課題4 ===");
        double bmi = calculateBMI(175.0, 68.5);
        printJudge("Alice", bmi);

	}
	 // 課題1用メソッド
    public static void runTask1() {
        // ここに課題1の処理を記述します
    	String goodsName = "Java入門テキスト";
    	int price = 2800;
    	double discountRate  = 0.15;
    	double discountPrice = price*(1 - discountRate);
    	int payment = (int)discountPrice;
    	System.out.printf(
    			"商品名： %s\n"
    			+ "定価： %d\n"
    			+ "割引後価格： %d円（割引率：%.1f％）"
    			, goodsName, price, payment, discountRate*100
    			);
    }

    // 課題2用メソッド
    public static void runTask2() {
        // ここに課題2の処理を記述します
    	int score = 85;
    	double attendance = 0.92;
    	String result = score>=70 && attendance>=0.8 ? "合格":"不合格";
    	char rank = ' ';
    	if(score>=90) {
    		rank = 'A';
    	}else if(score>=80) {
    		rank = 'B';
    	}else if(score>=70) {
    		rank = 'C';
    	}else {
    		rank = 'F';
    	}
    	String scoreEvaluating = "";
    	switch (rank) {
		case 'A': {
			scoreEvaluating = "素晴らしい成績です！";
			break;
		}case 'B': {
			scoreEvaluating = "良好な成績です。";
			break;
		}case 'C': {
			scoreEvaluating = "合格ラインです。";
			break;
		}case 'F': {
			scoreEvaluating = "再試験が必要です。";
			break;
		}}
    	System.out.printf(
    			"判定：%s\n"
    			+ "ランク：%c\n"
    			+ "メッセージ：%s", 
    			result, rank, scoreEvaluating);
    }

    // 課題3用メソッド
    public static void runTask3() {
        // ここに課題3の処理を記述します
    	int[] numbers = {12, 45, 67, 23, 89};
    	int amount = 0;
//    	int maxValue = 0;値がマイナスの可能性もあるので０より、
//    	numbersの最初の要素,numbers[0]で初期化するのが確実。
    	int maxValue = numbers[0];
    	for(int i=0; i < numbers.length; i++) {
    		amount += numbers[i];
    		if(numbers[i]>maxValue) {
    			maxValue = numbers[i];
    		}   		
    	}
    	int[] target = numbers;
    	target[1] = 999;
    	String result = "合計値：%d\n"
    			+ "最大値：%d\n"
    			+ "numbers[1]の値：%d\n\n";
    	System.out.printf(
    			result, amount, maxValue, numbers[1]);
    	System.out.println(
    			"合計値："+amount+'\n'
    			+"最大値："+maxValue+'\n'
    			+"numbers[1]の値："+numbers[1]+'\n'
    			);
    }
    // 課題4用のメソッド（calculateBMI, printJudge）は別途定義します
    public static double calculateBMI(double heightCm, double weightKg)
    {	double heightM = heightCm/100;
    	double bmi = weightKg /(heightM*heightM);
    	return bmi;
    }
    public static void printJudge(String name, double bmi) {
    	String bmiJudge = null; 
    	if(bmi < 18.5) {
    	 bmiJudge = "低体重";
    	}else if(bmi < 25.0) {
    		bmiJudge = "普通体重";
    	}else {
    		bmiJudge = "肥満";
    	}
    	System.out.printf("%s\sさんのBMI：%.1f（%s）",name, bmi, bmiJudge );
    }
}
