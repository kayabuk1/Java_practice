package chapter14_1;

public class IllegalCharException 
extends RuntimeException {
//	カスタム例外クラスを作る場合は、最低でも Exception
//	クラスを継承するように作る決まりになっている。
	private static final long serialVersionUID = 1L;

	public IllegalCharException(String msg) {
		super(msg);
	}
	public IllegalCharException() {}
}
