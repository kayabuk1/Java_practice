package chapter17_1;
//日時を整形する DateTimeFormatterクラス

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Sample4 {

	public static void main(String[] args) {
		
		var dateFormat
		= DateTimeFormatter.ofPattern(
				"y年MM月dd日eeee");
		var timeFormat
		= DateTimeFormatter.ofPattern(
				"ahh時mm分ss秒");
		
		System.out.println(dateFormat);
		System.out.println(timeFormat);
		
		System.out.println(
				LocalDate.of(2025, 1, 3).format(
						dateFormat)
				);
		System.out.println(
				LocalTime.of(15, 8, 32).format(
						timeFormat)
				);
//		String java.time.LocalDate.format(
//		DateTimeFormatter formatter
//		.formatは引数で DateTimeFormatter型 
//		日時の整形方法が書かれたオブジェクト？
//		を渡すことになっている。
			}

}
//Value(YearOfEra)'年'Value(MonthOfYear)'月'
//Value(DayOfMonth)'日'Text(DayOfWeek)

//Text(AmPmOfDay,SHORT)Value(ClockHourOfAmPm)'時'
//Value(MinuteOfHour)'分'Value(SecondOfMinute)'秒'

//2025年1月13日月曜日
//午後3時8分32秒