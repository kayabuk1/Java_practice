package chapter17_1;
//日付と時刻「3つの型」×「3つの作成方法」

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Sample1 {

	public static void main(String[] args) {
		
//それぞれのメソッドの戻り値の型を意識することが大事とのこと。
//		全てクラスメソッド（staticなメソッド）自分と同じ型を作って返すメソッド
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println();
		
		System.out.println(LocalDate.of(2025, 1, 13));
		System.out.println(LocalTime.of(15, 8, 32));
		System.out.println(LocalDateTime.of(2025, 1, 13, 15, 8, 32));
		System.out.println();
		
//		parse=パース＝解析＝文字列時刻表現から時刻を解析して日時オブジェクト作成
		System.out.println(LocalDate.parse("2025-01-13"));
		System.out.println(LocalTime.parse("15:08:32"));
		System.out.println(LocalDateTime.parse("2025-01-13T15:08:32"));
//		T は、ISO-8601規格で「ここから時刻（Time）が始まる」を示す区切り文字
	}

}
//結果
//2026-10-13
//11:13:30.196563900
//2026-10-13T11:13:30.196563900
//
//2025-01-13
//15:08:32
//2025-01-13T15:08:32
//
//2025-01-13
//15:08:32
//2025-01-13T15:08:32