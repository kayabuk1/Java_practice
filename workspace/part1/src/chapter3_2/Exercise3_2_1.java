package chapter3_2;
/*
 * public record Product
(String code, String name, int price, boolean shortage) {	
}
 * */
public class Exercise3_2_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		Product product1 = new Product("MT890", "ｽﾃﾝﾚｽﾈｼﾞ", 280, false);
//		System.out.println(
//				"商品コード\t=　%s".formatted(product1.code())+"\n"
//				+"商品名\t\t=　%s".formatted(product1.name())+"\n"
//				+"価格\t\t\t=　%d".formatted(product1.price())+"\n"
//				+"欠品\t\t\t=　%B".formatted(product1.shortage())
//				);
//		Product [] products = new Product [2];
//		Product product2 = new Product("74HC02", "ﾃﾞｼﾞﾀﾙIC", 120, true);
//		products[0] = product1;
//		products[1]=product2;
		
		Product[] products = {
			    new Product("MT890", "ｽﾃﾝﾚｽﾈｼﾞ", 280, false),
			    new Product("74HC02", "ﾃﾞｼﾞﾀﾙIC", 120, true),
			    new Product("RES10k", "抵抗器 10kΩ", 10, false)
			    // 3つ目、4つ目も簡単に増やせる。
//			    この書き方なら Product型の配列に
//			    Productレコード型が格納されているイメージそのまま
			};
		
		for (Product p: products) {
			System.out.println(
					"商品コード\t=　%s".formatted(p.code())+"\n"
					+"商品名\t\t=　%s".formatted(p.name())+"\n"
					+"価格\t\t\t=　%d".formatted(p.price())+"\n"
					+"欠品\t\t\t=　%B".formatted(p.shortage())+"\n"
					);
		}
	}

}
