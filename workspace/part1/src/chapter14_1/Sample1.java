package chapter14_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sample1 {

	public static void main(String[] args) {
		
		try {
			Path p = Path.of("fruit.txt");
			var list = Files.readAllLines(p);
			list.forEach(System.out::println);
			Path p2 = Path.of("fruit");
			var list2 = Files.readAllLines(p2);
//			ここまで書かないと例外にならない。
		}
		catch(IOException e){
			System.err.println("ファイルを読みだせません");
//			syseで変換候補が出る。
//			外部変数 .out が .err になっている。
//			⇒これはどんな違いがある？
//			⇒Linuxの標準入出力、標準エラー出力みたいなもの？
			
		}
	}

}
