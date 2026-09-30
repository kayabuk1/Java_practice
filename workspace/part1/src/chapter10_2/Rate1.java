package chapter10_2;

public class Rate1 implements RateIntf {

	@Override
	public double taxRate(double gaku) {
		return gaku > 100 ? 0.1 : 0.05;
	}

}
