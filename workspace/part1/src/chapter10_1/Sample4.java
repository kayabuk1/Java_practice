package chapter10_1;

import java.time.LocalDate;
import java.util.List;

public class Sample4 {

	public static void main(String[] args) {
		
		var list = List.of
				(
						new Student
						(10, "田中宏", "tanka@mail.jp", 
								2, LocalDate.of(2000, 1, 1)),
						new AuditingStudent
						(20, "木村", "kimura@mail.jp", 3, 112),
						new Teacher
						(12, "岡田晃", "okada@mail.jp", 1,
								"https://server.jp/okada/")
				);
		
		for (Versionable ver : list) {
			System.out.println(ver.Version());
		}
		
		System.out.println();
		
		for (User usr : list) {
			System.out.println(
				usr.getName()
				+usr.getMail()
				+usr.getRole()
				+usr.getClass().getSimpleName()
				);
			usr.login();
		}
	}
}
//Student ver 1.0
//Student ver 1.0
//Teacher ver 1.0
//
//田中宏tanka@mail.jp2Student
//ログインしました。
//木村kimura@mail.jp3AuditingStudent
//ログインしました。
//岡田晃okada@mail.jp1Teacher
//ログインしました。
