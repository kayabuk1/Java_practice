package chapter17_1;

import java.time.Duration;
//最初から最後まで、途切れなく流れる「物理的な絶対的な時間の長さ」そのもの
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
//人間が生活の中で区切る、カレンダー的なまとまった期間。概念的な時間の長さ
import java.time.temporal.ChronoUnit;
//時間の長さを測るための「定規の目盛り」
//それ単体では特定の期間（長さ）を表すのではなく、「どの基準で時間を数えるか？」
//という手段を提供

public class Sample8 {

	public static void main(String[] args) {
		
		LocalDate start
		= LocalDate.of(2023, 1, 13);
		LocalDate end
		= LocalDate.of(2025, 1, 1);
		
		System.out.println(
				ChronoUnit.MONTHS.between(start, end)
				+"ヶ月"
				);
		System.out.println(
				ChronoUnit.DAYS.between(start, end)
				);
//		public long between(Temporal temporal1Inclusive, Temporal temporal2Exclusive)
//		次のインタフェースからコピーされた説明: TemporalUnit
//		2つの時間的オブジェクトの間の時間量を計算します。
		
		var p
		= Period.between(start, end);
		System.out.printf(
				"%d年%d月%d日%n",
				p.getYears(),p.getMonths(),p.getDays());
//		between
//		public static Period between(LocalDate startDateInclusive, LocalDate endDateExclusive)
//		2つの日付間の年数、月数、および日数で構成されるPeriodを取得します。
		
		
//		⇒%nなにだったけ？
//		ChronoUnit, Period, Duration それぞれの違いは？
//		ChronoUnitのMONTHESはクラス定数？なぜ？
//		JavaAPIリファレンスSE8を見ていた汗21のほうが良い？
		
		LocalTime start2
		= LocalTime.of(10, 0, 0);
		LocalTime end2
		= LocalTime.of(18, 33, 45);
		
		var d
		= Duration.between(start2, end2);
		System.out.println(d.toMinutes()+"分間");
		System.out.println(d.toSeconds()+"秒間");
		var c
		= ChronoUnit.SECONDS.between(start2, end2);
		System.out.println(c);
		
//		public static Duration between(Temporal startInclusive, Temporal endExclusive)
//		2つの時間的オブジェクト間のデュレーションを表すDurationを取得します。
//		public long toSeconds()
//		このデュレーションの秒数を取得します。
	}

}
//23ヶ月
//719
//1年11月19日
//513分間
//30825秒間






















