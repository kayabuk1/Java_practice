package chapter9_1;

import java.time.LocalDate;

public class Sample4 {

	public static void main(String[] args) {
		
		Member member1 = 
				new GeneralMember(200, "木村一郎");
		
		Member member2 =
				new StudentMember(
						100, "田中宏", LocalDate.of(2026, 3, 31));
		
		Member member3 =
				new SeniorMember(
						200, "鈴木浩二", LocalDate.of(1960, 3, 31));
		
		String msg = switch (member2) {
		case GeneralMember gem ->"一般会員";
		case StudentMember stm ->"学生会員";
		case SeniorMember sem ->"シニア会員";
		default ->"会員ではありません";
		
		};
		System.out.println(msg);
	}

}
