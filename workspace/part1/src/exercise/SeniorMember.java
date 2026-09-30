package exercise;

import java.time.LocalDate;

public class SeniorMember extends Member {
	
	private LocalDate birthday;

	public SeniorMember(
			long id, String name, LocalDate birthday) {
		super(id, name);
		this.birthday = birthday;
	}
	
	@Override
	public int kai_hi() {
		return (int)(super.kai_hi()*0.6);
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
}
