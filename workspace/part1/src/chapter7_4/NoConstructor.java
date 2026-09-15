package chapter7_4;

public class NoConstructor {
	private int number;
	private String str="***";
	public int getNumber() {
		return number;
	}
	public String getStr() {
		return str;
	}
public NoConstructor(int number, String str) {
	this.number = number;
	this.str = str;
}
public NoConstructor() {}
}
