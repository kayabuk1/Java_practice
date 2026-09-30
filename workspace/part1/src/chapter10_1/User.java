package chapter10_1;

public class User {
	private int id;
	private String name;
	private String mail;
	private int role;
	
	public User(int id, String name, String mail, int role) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.role = role;
	}
	public void login() {
//		ダミーメソッド
		System.out.println("ログインしました。");
		
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMail() {
		return mail;
	}
	public int getRole() {
		return role;
	}
	
}
