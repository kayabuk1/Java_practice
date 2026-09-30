package chapter9_1;

import java.time.LocalDate;

public class StudentMember extends Member {

	LocalDate expDate;

	public StudentMember(
			long id, String name, LocalDate expDate) {
		super(id, name);
		this.expDate = expDate;
	}
	
	@Override
	public int kai_hi() {
//	    if (isExpired()) {
//	        return super.getBasePrice();
//	    } else {
//	        return (int)(super.getBasePrice() * 0.5);
//	    }
		return isExpired() ?  
				super.getBasePrice() 
				: (int)(super.getBasePrice() * 0.5);
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
