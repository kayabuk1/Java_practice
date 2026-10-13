package chapter17_1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Exercise17_3_1 {

	public static void main(String[] args) {

		LocalDateTime birthDayTime
		= LocalDateTime.of(1979, 1, 3, 0, 0);
		LocalDateTime joinDayTime
		= LocalDateTime.of(2002, 4, 1, 0, 0);
		LocalDateTime now
		= LocalDateTime.now();
		
		var age
		= ChronoUnit.YEARS.between(
				birthDayTime, now);
		var yearsOfService
		= (ChronoUnit.YEARS.between(joinDayTime, now)
//				+ChronoUnit.MONTHS.between(joinDayTime, now)
				);
		var monthsOfService
		= ChronoUnit.MONTHS.between(joinDayTime, now);
		
		System.out.println(age);
		System.out.println(yearsOfService);
		System.out.println(monthsOfService);
//		CHronoUnitで●年●月の様に表示する方法は？
		
		LocalDate birthDay
		= LocalDate.of(1979, 1, 3);
		LocalDate joinDay
		= LocalDate.of(2002, 4, 1);
		LocalDate nowDay
		= LocalDate.now();
		
		// LocalDateTime を使いたい場合は toLocalDate() で
//		日付部分だけ取り出して渡す
		var periodFromBirth2 
		= Period.between(
				birthDayTime.toLocalDate(), now.toLocalDate());
		
		System.out.println();
		var periodFromBirth
//		= Period.between(birthDayTime, null);
//		LocalDateTime型は引数に取れない？
		= Period.between(birthDay, nowDay);
		
		var periodOfService2
		= Period.between(joinDay, nowDay);
		
		System.out.println(periodFromBirth.getYears()+"才");
		System.out.printf("勤続%2d年%2dカ月".formatted(
				periodOfService2.getYears(),
				periodOfService2.getMonths()
				));
	}

}
//47
//24
//294

//47才
//勤続24年 6カ月