package chapter10_1;

import java.time.LocalDate;
import java.util.List;

public class Sample3 {

	public static void main(String[] args) {
		
		var list = List.of
//				List<Attendable> list = List.of
//				の様に型を明示した方が好ましいとのこと。
				(
						new Student
						(10, "田中宏", "tanka@mail.jp", 
								2, LocalDate.of(2000, 1, 1)),
						new AuditingStudent
						(20, "木村", "kimura@mail.jp", 3, 112),
						new Student
						(12, "森下樹", "morishita@mail.jp", 2,
								LocalDate.of(2004, 7, 1))
				);
		
		for (Attendable att :list) {
			att.readAttendance();
			att.writeAttendance();
		}
		
		System.out.println();
		
		for (User usr : list) {
			System.out.println(
					usr.getName()
					+usr.getMail()
					+usr.getRole()
					+usr.getClass().getSimpleName());
		}
	}

}
//出席情報読み込み完了
//出席報告完了
//聴講科目出席情報読み込み完了
//聴講科目出席報告完了
//出席情報読み込み完了
//出席報告完了
//
//田中宏tanka@mail.jp2Student
//木村kimura@mail.jp3AuditingStudent
//森下樹morishita@mail.jp2Student