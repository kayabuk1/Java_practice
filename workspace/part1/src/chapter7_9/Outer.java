package chapter7_9;

public class Outer {
	private int number;
	public Outer(int number) {
		this.number = number;
	}
	public void print() {
		Inner inner = new Inner();
		System.out.println(inner.msg());
	}
	private class Inner{
		public String msg() {
			return "number is "+ number;
		}
	}
	public static void main(String[] args) {
		Outer outer = new Outer(102);
		outer.print();
//		number is 102
		outer.new Inner();
//		Inner in = new Outer.Inner();←これはだめ。
//		Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
//			アクセス可能な型 Outer のエンクロージング・インスタンスがありません。型 Outer のエンクロージング・インスタンスで割り振りを限定する必要があります (たとえば x.new A() で、x は Outer のインスタンス)。
//
//			at chapter7_9.Outer.main(Outer.java:21)
	}
}
