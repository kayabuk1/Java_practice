package chapter9_1;

import java.time.LocalDate;

public class Sample3 {

	public static void main(String[] args) {
		
		Member member1 = 
				new GeneralMember(200, "木村一郎");
		
		Member member2 =
				new StudentMember(
						100, "田中宏", LocalDate.of(2026, 3, 31));
//		アップキャストの際の(Member)は省略されている。
//		逆にダウンキャストは元のクラスが分からないので、
//		キャスト演算子が必要。
//		例：Student stm = (StudentMember)member;
//		⚠ただし、ダウンキャストは危険。
//		ダウンキャスト時に変数memberの中に、何型のインスタンスが
//		入っているかわからない。もし別のデータ型が入っていたら、
//		エラーが発生する原因になる。
		
		Member member3 =
				new SeniorMember(
						200, "鈴木浩二", LocalDate.of(1960, 3, 31));

//		ダウンキャストが危険な例↓
//		StudentMember stm = (StudentMember)member2;
//		StudentMember stm = (StudentMember)member1;
//		↑でも↓でもコンパイル時点ではエラーが出ない。
//		しかし↓は実行時にキャスト失敗してエラーが出る。
		
		if(member2 instanceof StudentMember stm) {
//			なのでif文の中で、instanceof演算子を使って
//			「左辺変数member2の中身は
//			右辺のStudentMember型かそのサブクラスですか？」
//			と聞いてやるのがマスト。
//			instanceof演算子は同じか聞くのではなく、キャストできるか
//			判定しているだけなのに注意。
			
//			一度アップキャストしているのでダウンキャストしないと、
//			StudentMemberクラスのメソッドは使えない。
			System.out.println("期限日＝"+stm.getExpDate());
		}

	}

}
