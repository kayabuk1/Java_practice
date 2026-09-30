package chapter8_3;

import java.time.LocalDate;

import chapter8_1.GeneralMember;

public class StudentMember extends GeneralMember {
	private LocalDate expDate;
	
	public StudentMember(long id, String name, LocalDate expDate) {
		super(id, name);
		this.expDate = expDate;
	}
	
	@Override
	public int kai_hi() {
		return (int) ((super.kai_hi())*0.5);
//		return 500;
	}
	public boolean isExpired() {
		LocalDate today = LocalDate.now();
		return today.isAfter(expDate);
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	

}
