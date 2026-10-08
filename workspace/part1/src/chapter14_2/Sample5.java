package chapter14_2;
//チェック例外の投げ方

import jp.kwebs.lib.Input;

public class Sample5 {

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
	public static void analyse(String str)
	throws IllegalCharException
	{
		if(str.contains("@")){
			throw new IllegalCharException("@はNG");
		}
		
	}
}
//package chapter14_2;
//
//public class IllegalCharException 
//extends Exception {
//
//	private static final long serialVersionUID = 1L;
//
//	public IllegalCharException(String msg) {
//		super(msg);
//	}
//	public IllegalCharException() {}
//}
