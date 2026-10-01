package chapter11_2;

public class Select_1 implements Predicate {
	@Override
	public boolean test(Apple a) {
		return a.wight() >= 300;
	}
}
