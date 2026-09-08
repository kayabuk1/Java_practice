package chapter3_4;

import java.util.ArrayList;

public class Sample4 {

	public static void main(String[] args) {
		var list = new ArrayList<Integer>();
		
		list.add(25);
		list.add(10);
		list.add(15);
		
		for(int n: list) {
			System.out.println(n);
		}

	}

}
