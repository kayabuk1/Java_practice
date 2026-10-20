package chapter18_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Sample3 {

	public static void main(String[] args) {
		
		var list = new ArrayList<Measurement>();
		var path = Path.of("Sample.txt");
		try (var in = Files.newBufferedReader(path))
		{
			String line;
			while((line=in.readLine()) != null)
			{
				String[] items = line.split("\\s*,\\s*");
//				\\s* ➔ 「0個以上の空白文字」という意味。
//				\\s*,\\s* ➔ 「カンマの前後にスペースがあっても無くても、
//				カンマを基準に分割する」の意味。
//				◆「splitメソッドの説明」
//				String[] java.lang.String.split(
//				String regex
//				)
//				split
//				public String[] split(String regex)
//				この文字列を、指定された正規表現に一致する位置で分割します。
				
				list.add(new Measurement(items));
//				Measurementのデフォルトコンストラクタは4つのフィールド変数を受け取る
//				形で内部で自動生成されている。なので、splitで分割した文字列を受け取って、
//				レコードインスタンスを生成するように事前にオーバロードしておく。
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		list.forEach(System.out::println);
	}

}
//◆Mesurementレコードの構造
//package chapter18_1;
//
//public record Measurement(
//		int id, String name, double weight, double height ) 
//{
//	public Measurement(String[] items) {
//		this(
//				Integer.valueOf(items[0]),
//				items[1],
//				Double.valueOf(items[2]),
//				Double.valueOf(items[3])
//				);
//	}
//}



//
//Exception in thread "main" java.lang.NumberFormatException: For input string: "105,斎藤一郎,65.1,171.2"
//	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:67)
//	at java.base/java.lang.Integer.parseInt(Integer.java:662)
//	at java.base/java.lang.Integer.valueOf(Integer.java:989)
//	at chapter18_1.Measurement.<init>(Measurement.java:8)
//	at chapter18_1.Sample3.main(Sample3.java:21)