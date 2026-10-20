package chapter18_1;

import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise18_3_1 {

	public static void main(String[] args) {
		
		var list = new ArrayList<Order>();
		var path = Path.of("order.txt");
		
		try (var sc = new Scanner(path)) {
			sc.useDelimiter("\\s*,\\s*|\\s+");
//			↑は正規表現()無しでも同じ意味。
//			("\\s*,\\s*"|"\\s+"これは | がエラー
			while(sc.hasNext()) {
				list.add(
						new Order(
								sc.nextInt(),
								sc.next(),
								sc.nextInt(),
								LocalDate.parse(sc.next())
//★ミス：LocalDate型はコンストラクタを持たないので、
//new LocalDate.parse()のように生成出来ない。
//staticが付いたｸﾗｽﾒｿｯﾄﾞなので、関数的に Cls.method()
//と呼び出す。								
								 )
						);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		list.forEach(System.out::println);
	}
}

//package chapter18_1;
//import java.time.LocalDate;
//public record Order(
//		int id, String item, int amount, LocalDate date)
//{
//}


//実行結果
//Order[id=1101, item=山菜弁当, amount=3, date=2023-04-02]
//Order[id=1102, item=幕ノ内弁当, amount=5, date=2023-04-02]
//Order[id=1103, item=焼肉弁当, amount=4, date=2023-04-03]




