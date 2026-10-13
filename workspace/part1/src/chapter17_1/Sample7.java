package chapter17_1;
//日時の加算減算

import java.time.LocalDate;
import java.time.LocalTime;

public class Sample7 {

	public static void main(String[] args) {
		
		var day 
		= LocalDate.of(2024, 2, 29);
		var time 
		= LocalTime.of(15, 8, 32);
		
		System.out.println(day.isLeapYear());
		System.out.println(day);
		System.out.println(time);
		System.out.println();
		
		System.out.println(
				day.plusYears(3)
//				指定された年数を加算した、
//				このLocalDateのコピーを返します。
//				=LocalDate型が評価結果に嵌るので、
//				そのまま . でメソッドチェーンが出来る。
//				.plusMonths(-2)
//				.plusDays(6)
				.isLeapYear()
				);
		System.out.println(
				time.plusHours(3)
				.plusMinutes(15)
				);
		
	}

}
