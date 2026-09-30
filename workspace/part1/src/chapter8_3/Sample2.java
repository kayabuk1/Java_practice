package chapter8_3;
//アップキャストの働き
import java.time.LocalDate;

import chapter8_1.GeneralMember;
public class Sample2 {

	public static void main(String[] args) {
		GeneralMember gem	//👈ｻﾌﾞｸﾗｽをｽｰﾊﾟｰｸﾗｽに代入が出来る。
			= new StudentMember(	//自動的な型変換ｷｬｽﾄが行われている。
					100,"田中宏", LocalDate.of(2026, 3, 31));
		
		System.out.println("ID = " + gem.getId());
		System.out.println("ID = " + gem.getName());
		System.out.println("ID = " + gem.kai_hi());
//		↑ｵｰﾊﾞｰﾗｲﾄﾞしたﾒｿｯﾄﾞはアップキャストしてもcall可能。
//		ダイナミックバインディングと呼ばれる。
		
//		System.out.println("ID = " + gem.isExpired());
//		System.out.println("ID = " + gem.getExpDate());
//		👆しかしｻﾌﾞｸﾗｽStudentMemberのﾒｯｿﾄﾞにｱｸｾｽ出来ない。
//		■これはｺﾝﾊﾟｲﾗが中身でなく、型のみ見てcall可能ﾒｿｯﾄﾞを判断する為
		// (StudentMember) にキャストしてから呼び出す
//		↓こう書くとアクセス出来るとのこと
		if (gem instanceof StudentMember) {
		    StudentMember st = (StudentMember) gem; // ダウンキャスト
		    System.out.println(
		    		"有効期限切れ？: " + st.isExpired()); // ⭕ アクセス可能！
		}
		// または1行で書く場合
		System.out.println(
				"有効期限切れ？: " + ((StudentMember) gem).isExpired());
	}

}
