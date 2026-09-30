package chapter8_3;
//サブクラスをスーパクラス型で処理をする
import java.time.LocalDate;
import java.util.List;

import chapter8_1.GeneralMember;

public class Sample3 {

	public static void main(String[] args) {
//		↓
		List<GeneralMember> list 	//共通する親クラスで扱えば計算が楽に
			= List.of(
				new GeneralMember(200, "木村一郎"),
				new StudentMember(100, "田中宏", LocalDate.of(2026, 3, 31)),
				new SeniorMember(200, "鈴木浩二", LocalDate.of(1960, 3, 31))
//				↑kai_hiﾒｿｯﾄﾞの各クラスでのｵｰﾊﾞｰﾗｲﾄﾞが必要なことに注意。
				);
		
		int total = 0;
		for (GeneralMember gem : list) {
			total += gem.kai_hi();
		}
		
		System.out.println("合計＝" + total);
	}
}
