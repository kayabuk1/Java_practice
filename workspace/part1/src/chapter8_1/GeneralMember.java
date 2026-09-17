package chapter8_1;

public class GeneralMember {
	private long id;
	private String name;
	public GeneralMember(long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
