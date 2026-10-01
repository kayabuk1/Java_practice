package chapter10_2;

public class Rate3 implements RateIntf {

	@Override
	public double taxRate(double shotoku) {
		return shotoku < 160 ? 0.001875*shotoku : 0.3 ; 
	}

}
