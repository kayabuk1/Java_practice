package chapter12_2;

public record Meibo(int number, String name) 
	implements Comparable<Meibo>{
//	↑Comparableを実装したので、定義されている抽象メソッドをオーバライドする
//	必要がある。

	@Override
	public int compareTo(Meibo o) {
		return Integer.compare(this.number, o.number);
	}
}
