package chapter14_1;

import jp.kwebs.lib.Input;

public class Sample4 {

	public static void main(String[] args) {

		String str = Input.getString();
		
		try {
			analyse(str);
			System.out.println("Ok: "+str);
		} 
		catch (IllegalCharException e) {
			System.out.println(e);
		}
	}
	public static void analyse(String str) {
		if(str.contains("@")){
			throw new IllegalCharException("@はNG");
		}
		
	}

}

//package chapter14_1;
//
//public class IllegalCharException 
//extends RuntimeException {
//	private static final long serialVersionUID = 1L;
//
//	public IllegalCharException(String msg) {
//		super(msg);
//	}
//	public void IllegalcharException() {}
//}
