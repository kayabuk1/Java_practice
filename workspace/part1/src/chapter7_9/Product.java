package chapter7_9;

public class Product {
	private int number;
	private int price;
	private String name;
	
	public Product(int number, int price, String name){
		this.number = number;
		this.price = price;
		this.name = name;
	}
	
//	↓セッターを削除
	public int getNumber() {
		return number;
	}
	public int getPrice() {
		return price;
	}
	public String getName() {
		return name;
	}
}
