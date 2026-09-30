package exercise;

public class Root {

	
public static void main(String[] args) {
//	super();が省略されてObjectクラスのｺﾝｽﾄﾗｸﾀが呼ばれている。
	
//	↓Objectクラスのｺﾝｽﾄﾗｸﾀ
//	public Object() {
	    // 中身は実質「空」
//	}
	
	Root r = new Bar();
//	Root r = new Foo();
//	Root r = new Bas();
	
	String msg = switch (r) {
	case Foo foo ->"Foo型です";
	case Bar bar ->"Bar型です";
	case Bas bas ->"Bas型で";
	default -> "その他型です";
	};
	System.out.println(msg);
}
}
