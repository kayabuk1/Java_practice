package chapter14_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sample1 {

	public static void main(String[] args) //throws IOException
//	try か throws を付けないとエラーになる。
//	ソース→囲む→try-catchを選べばOK
	{
		
		try {
			Path p = Path.of("fruit.txt");
			var list = Files.readAllLines(p);
//			※ファイルを読み込む処理をする（ｽﾄﾘｰﾑ?）時に try-cathc を外すと
//			エラーがでる。
//			Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
//			処理されない例外の型 IOException
//			処理されない例外の型 IOException
//			at chapter14_1.Sample1.main(Sample1.java:12)

			
			list.forEach(System.out::println);
//			Path p2 = Path.of("fruit");
			Path p2 = Path.of("fruittxt");
			var list2 = Files.readAllLines(p2);
//			ここまで書かないと例外にならない。
		}
		catch(NullPointerException e){
			System.err.println("NullPointreException");
//			syseで変換候補が出る。
//			外部変数 .out が .err になっている。
//			⇒これはどんな違いがある？
//			⇒Linuxの標準入出力、標準エラー出力みたいなもの？
		}catch(IOException e){
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			System.err.println("IOException");
			System.out.println(e);
			e.printStackTrace();
//			apple
//			banana
//			grape
//			fruittxt
//			java.nio.file.NoSuchFileException: fruittxt
//			java.nio.file.NoSuchFileException: fruittxt
//			IOException
//			java.nio.file.NoSuchFileException: fruittxt
			
//				↓ ★【一番上】実際に例外が発生した最深部
//				OSレベルで「ファイルが存在しない」と判明
//				at java.base/sun.nio.fs.WindowsException.translateToIOException(WindowsException.java:85)
//				at java.base/sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:103)
//				at java.base/sun.nio.fs.WindowsException.rethrowAsIOException(WindowsException.java:108)
//				at java.base/sun.nio.fs.WindowsFileSystemProvider.newByteChannel(WindowsFileSystemProvider.java:234)
//				at java.base/java.nio.file.Files.newByteChannel(Files.java:380)
//				at java.base/java.nio.file.Files.newByteChannel(Files.java:432)
//				at java.base/java.nio.file.spi.FileSystemProvider.newInputStream(FileSystemProvider.java:420)
//				at java.base/java.nio.file.Files.newInputStream(Files.java:160)
//				at java.base/java.nio.file.Files.newBufferedReader(Files.java:2910)
//				at java.base/java.nio.file.Files.readAllLines(Files.java:3405)
//				at java.base/java.nio.file.Files.readAllLines(Files.java:3446)
//				at chapter14_1.Sample1.main(Sample1.java:28)
			//↑一番下が呼び出し元。
		}
	}

}
