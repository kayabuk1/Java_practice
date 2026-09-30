package chapter9_1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SeniorMember extends Member {
	
	private LocalDate birthday;

	public SeniorMember(
			long id, String name, LocalDate birthday)
	{
		super(id, name);
		this.birthday = birthday;
	}
	
//	@Override
	public int kai_hi() {
		
		return age()>70 ?
				(int)(super.getBasePrice()*0.3)
				:super.getBasePrice() ;
	}
	public int age() {
		var today = LocalDate.now();
		return (int)(ChronoUnit.YEARS.between(birthday, today));
		
//		LocalDate today = LocalDate.now();
//		Period period = Period.between(birthday, today);
//		System.out.println(period);
//		int age = period.getYears();
//		System.out.println(age);
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}
