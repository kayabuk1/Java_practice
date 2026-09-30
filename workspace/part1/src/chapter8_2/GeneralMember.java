package chapter8_2;

public class GeneralMember {
	private long id;
	private String name;
	private Lesson lesson;
	
	public GeneralMember(
			long id, String name, Lesson lesson) {
		super();
		this.id = id;
		this.name = name;
		this.lesson = lesson;
	}
	public int kai_hi() {
		return 1000;
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
//	↓ソース→委譲メソッド生成での自動生成
	public int ryokin() {
		return lesson.ryokin();
	}
	public String getLessonId() {
		return lesson.getLessonId();
	}
	public String getLessonName() {
		return lesson.getLessonName();
	}
	
	public static void main(String[] args) {
		Lesson lesson1 = new Lesson("G101", "ゴルフ");
		GeneralMember gm1 = new GeneralMember(100, "田中宏", lesson1);
		System.out.println("""
				会員氏名 ＝%5s
				受講しているレッスン ＝%5s
				レッスン料金 =%5d
				""".formatted(
						gm1.getName(), gm1.getLessonName(),gm1.ryokin()
						)
				);
	}
}