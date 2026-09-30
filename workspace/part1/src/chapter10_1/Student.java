package chapter10_1;

import java.time.LocalDate;

//インターフェースの実装

public class Student extends User 
	implements Attendable, Versionable{

	private LocalDate expDate;

	public Student
	(int id, String name, String mail, int role,
			LocalDate expDate) 
	{
		super(id, name, mail, role);
		this.expDate = expDate;
	}
	
	public boolean isExpired() {
		LocalDate today = LocalDate.now();
		return today.isAfter(expDate);
	}
	public LocalDate getExpDate() {
		return expDate;
	}
	
	@Override
	public String Version() {
		String msg = "Student ver 1.0";
		return msg;
	}

	@Override
	public void writeAttendance() {
		System.out.println("出席報告完了");

	}
	@Override
	public void readAttendance() {
		System.out.println("出席情報読み込み完了");
//		実装したインターフェースの抽象メソッドをオーバライドしないと
//		エラーになる。
//		型 Student は継承された抽象メソッド 
//		Attendable.readAttendance() を実装する必要があります
	}

}
