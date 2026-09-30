package chapter9_1;
//抽象クラス、抽象メソッド

import java.time.LocalDate;
import java.util.List;

public abstract class Member 
{
	private long id;
	private String name;
	private int basePrice = 1000;
//	protected static final int BASE_PRICE = 1000; 
//	privateを付けてgetterかfinal定数にしてしまうのが安全。
	
	protected Member(long id, String name) {
//		super();
		this.id = id;
		this.name = name;
	}
	
	protected abstract int kai_hi();
//	抽象メソッド

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
	
	public int getBasePrice() {
		return basePrice;
	}

	public static void main(String[] args)
	{
//		↓
		List<Member> list 	//共通する親クラスで扱えば計算が楽に
			= List.of(
				new GeneralMember(200, "木村一郎"),
				new StudentMember(100, "田中宏", LocalDate.of(2027, 3, 31)),
				new SeniorMember(200, "鈴木浩二", LocalDate.of(1960, 3, 31))
//				↑kai_hiﾒｿｯﾄﾞの各クラスでのｵｰﾊﾞｰﾗｲﾄﾞが必要なことに注意。
				);
		
		int total = 0;
		for (Member mem : list) 
		{
			int fee = mem.kai_hi();
			
			if (mem instanceof SeniorMember senior) { 
				// 判定と同時に senior 変数が使える！
			    System.out.println(
			    		mem.getName() 
			    		+ "様 (" + senior.age() + "歳) : " 
			    		+mem.getClass().getSimpleName()
			    		+ fee + "円");
			}else {
				System.out.println(
					mem.getName()
					+mem.getClass().getSimpleName()
					+fee);
			}
			total += fee;
		}
		System.out.println("合計＝" + total);
	}

}
//木村一郎class chapter9_1.GeneralMember1100
//田中宏class chapter9_1.StudentMember500
//鈴木浩二class chapter9_1.SeniorMember1000
//合計＝2600



