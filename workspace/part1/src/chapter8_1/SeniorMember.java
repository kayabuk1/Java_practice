package chapter8_1;

import java.time.LocalDate;

public class SeniorMember extends GeneralMember {
	private LocalDate birthday;

	public SeniorMember(long id, String name, LocalDate birthday) {
		super(id, name);
		this.birthday = birthday;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}
