package exercise;

public class GeneralMember extends Member {

	public GeneralMember(long id, String name) {
		super(id, name);
	}

	@Override
	public int kai_hi() {
		return (int) (super.kai_hi() * 1.0);
	}

}
