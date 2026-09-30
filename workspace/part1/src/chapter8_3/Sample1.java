package chapter8_3;

import java.time.LocalDate;

public class Sample1 {

	public static void main(String[] args) {
		var expDate = LocalDate.of(2026, 3, 31);
//		↑varは型推論。宣言と同時に初期化するなら？型を明示しないvarで
//		も良いとのこと。
		var st = new StudentMember(100, "田中宏" ,
				expDate);
		System.out.println("id"+ st.getId());
		System.out.println("name"+ st.getName());
		System.out.println("会費"+ st.kai_hi());
//		↑3つのメソッドはStudentクラスフィールドには記述されていない
//		Generalクラスのメソッドを自分のかの様に呼び出せる。
		
		System.out.println("期限日か？"+ st.isExpired());
		System.out.println("期限日" +st.getExpDate());
	}

}
