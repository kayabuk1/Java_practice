package chapter18_1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sample2 {

	public static void main(String[] args) {

		var path 
		= Path.of("sample_ms932.txt");
		
		var cs
		= Charset.forName("MS932");
//		forName
//		public static Charset forName
//		(String charsetName)
//		指定された文字セットのCharsetオブジェクトを返します。
		
		try(var in = Files.newBufferedReader(path, cs))
		{
//			●引数１つPath pathの
//			newBufferedReader
//			public static BufferedReader newBufferedReader
//			(Path path) throws IOException
//			ファイルを読込み用に開き、効率的な方法で
//			ファイルからテキストを読み込むBufferedReaderを
//			返します。 ファイルから取得したバイトは、
//			UTF-8文字セットを使用して文字にデコードされます。
//			
//			●引数2つPath path,Charset csの
//			newBufferedReader
//			public static BufferedReader 
//			newBufferedReader(Path path, Charset cs)
//					throws IOException
//			ファイルを読取り用に開き、そのファイルから
//			効果的な方法でテキストを読み取るために使用できる
//			BufferedReaderを返します。 
//			ファイルから取得したバイトは、指定された文字セットを
//			使用して文字にデコードされます。
//			読取りはファイルの最初から始まります。
			
			String line;
			while((line=in.readLine())!=null)
			{
				System.out.println(line);
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
		
}
