package chapter14_2;
//例外のマルチキャッチ

import jp.kwebs.lib.Input;

public class Sample6 {

	public static void main(String[] args) {
		
		String str = Input.getString();
		
		try {
			analyse(str);
			System.out.println("Ok: "+str);
		} 
		catch (IllegalCharException 
				| FormatException e) {
			System.out.println(e);
		}
//		catch (FormatException e) {
//			System.out.println(e);
//		}
	}
	public static void analyse(String str)
	throws IllegalCharException, FormatException
	{
		if(str.contains("@")){
			throw new IllegalCharException("@はNG");
		}
		if( ! str.endsWith("/")){
			throw new FormatException("/が末尾無");
		}
		
	}
}
