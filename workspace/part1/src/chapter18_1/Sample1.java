package chapter18_1;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Sample1
{

	public static void main(String[] args)
	{
		
		var path
		= Path.of("sample.txt");
		
//		上は同じことをラッパーで書くと
		try(var in 
				= 
//				new BufferedReader(
						new FileReader("sample.txt")
//						)
				)
				{
//		try(var in = Files.newBufferedReader(path))
//		newBufferedというように newが同じ単語になぜ？
//		Java の ファクトリメソッド（生成用メソッド）における
//			命名慣例 によるものです。
//		 「新しいインスタンス（オブジェクト）を作って返す」という
//			意味の明示： Java の java.nio.file.Files クラス
//			では、呼び出すたびに新しいストリームやリーダー
//			オブジェクトを生成して返すメソッドに 
//			new... というプレフィックス（接頭辞）を付ける
//			ルールになっています。
//		{
//			String line;
//			while((line=in.readLine())!=null)
			int c;
			while((c=in.read())!=-1)
			{
//				System.out.println(line);
//				System.out.println((char)c);
				System.out.print((char)c);
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
//49
//48
//53
//44
//25998
//34276
//19968
//37070
//44
//54
//53
//46
//49
//44
//49
//55
//49
//46
//50
//13
//10
//49
//50
//48
//44
//26862
//19979
//33457
//44
//52
//56
//46
//48
//44
//49
//54
//54
//46
//49
//13
//10
//49
//49
//48
//44
//30000
//20013
//23439
//44
//54
//56
//46
//51
//44
//49
//55
//53
//46
//53
//13
//10

//1
//0
//5
//,
//斎
//藤
//一
//郎
//,
//6
//5
//.
//1
//,
//1
//7
//1
//.
//2
//
//
//
//
//1
//2
//0
//,
//森
//下
//花
//,
//4
//8
//.
//0
//,
//1
//6
//6
//.
//1
//
//
//
//
//1
//1
//0
//,
//田
//中
//宏
//,
//6
//8
//.
//3
//,
//1
//7
//5
//.
//5
//
//
//

