package chapter11_1;

public interface RateIntf {
	public abstract double taxRate(double gaku);
//	public abstract double taxRate2(double gaku);
//	↑このようにメソッドを2つ記述すると、ラムダ式がエラーになる。
}
