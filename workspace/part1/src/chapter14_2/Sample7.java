package chapter14_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Sample7 {

	public static void main(String[] args) //throws IOException
	{
		
		try {
			Path p = Path.of("fruit");
			var list = Files.readAllLines(p);

			
//			list.forEach(System.out::println);
//			Path p2 = Path.of("fruittxt");
//			var list2 = Files.readAllLines(p2);
		}
		catch(NoSuchFileException e){
			System.err.println(e+"\nファイルなし");
//			NoSuchFileException の到達不可能な catch ブロック。
//			すでに IOException の catch ブロックによって処理されています
//			親を先に書いてしまうとエラーになる。
		}
		catch(IOException e){
			System.out.println(e + "\nファイルが読み込めない");
			e.getStackTrace();
		}

	}

}
