package chapter8_3;

import java.time.LocalDate;

import chapter8_1.GeneralMember;

public class SeniorMember extends GeneralMember {
	private LocalDate birthday;

	public SeniorMember(long id, String name, LocalDate birthday) {
		super(id, name);
		this.birthday = birthday;
	}
	
	@Override
	public int kai_hi() {
		return (int)(super.kai_hi()*0.7);
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}
