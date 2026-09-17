package chapter7_9;

public final class Stock {
	private final Product product;
	private final int number;
	
public Stock(Product product, int number) {
//	this.product = product;
	this.product 
	= new Product( 
			product.getNumber(),product.getPrice(), product.getName());
	this.number = number;
}

public Product getProduct() {
	return new Product( 
			product.getNumber(),product.getPrice(), product.getName());
}
public int getNumber() {
	return number;
}
	public static void main (String[] args) {
		Product pd = new Product(100, 5000, "スパナ");
		Stock st = new Stock(pd, 30);
	    System.out.println("=== 初期状態 ===");
	    System.out.println("Stockの品名: " + st.getProduct().getName()); 
	    System.out.println("Stockの在庫数: " + st.getNumber());   
	    System.out.println(st);
	    
//	    st.number = 50; 
//	    st.product = null;
//	    Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
//	    	final フィールド Stock.number には代入できません
//	    	final フィールド Stock.product には代入できません
//	    st.getNumber().setNumber(999);
		System.out.println(pd);
	    pd = new Product(999, 9999, "壊された");
	    System.out.println("pd 変更後の Stock の品名: " 
	    + st.getProduct().getName()); 
	    Product retrievedProduct = st.getProduct();
	    boolean isSameAddress = (pd == retrievedProduct);
	    System.out.println(st);
	    System.out.println(
	    		"元の pd と Stock 内の Product は同じ住所か？: " 
	    + isSameAddress); 
	    System.out.println(pd);
	}
}
//=== 初期状態 ===
//Stockの品名: スパナ
//Stockの在庫数: 30
//chapter7_9.Stock@2f2c9b19
//chapter7_9.Product@2f2c9b19
//pd 変更後の Stock の品名: スパナ
//chapter7_9.Stock@2f2c9b19
//元の pd と Stock 内の Product は同じ住所か？: false
//chapter7_9.Product@1c20c684
