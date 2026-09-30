package exercise;

import java.time.LocalDate;
import java.util.List;


public class Member {
	private long id;
	private String name;
	
	public Member(long id, String name) {
//		super();
		this.id = id;
		this.name = name;
	}
	
	public  int kai_hi() {
		int base_price = 1000;
		return base_price;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static void main(String[] args) {
//		↓
		List<Member> list 	//共通する親クラスで扱えば計算が楽に
			= List.of(
				new GeneralMember(200, "木村一郎"),
				new StudentMember(100, "田中宏", LocalDate.of(2026, 3, 31)),
				new SeniorMember(200, "鈴木浩二", LocalDate.of(1960, 3, 31))
//				↑kai_hiﾒｿｯﾄﾞの各クラスでのｵｰﾊﾞｰﾗｲﾄﾞが必要なことに注意。
				);
		
		int total = 0;
		for (Member mem : list) {
			total += mem.kai_hi();
		}
		
		System.out.println("合計＝" + total);
	}
}
