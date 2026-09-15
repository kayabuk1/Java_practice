package chapter7_5;

public class Sample1 {

	public static void main(String[] args) {
		StaticJoining.inti("", ",");
		StaticJoining.inti("", "-");
		
		StaticJoining.add("apple");
		StaticJoining.add("apple");
		StaticJoining.add("apple");
		System.out.println(StaticJoining.getCsv());

		StaticJoining.add("apple");
		StaticJoining.add("apple");
		StaticJoining.add("apple");
		System.out.println(StaticJoining.getCsv());

	}

}
