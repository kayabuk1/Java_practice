package chapter18_1;
//追記モードで出力する：FileWriterをラップする

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import jp.kwebs.lib.Input;

public class Sample7 {
	
	public static void main(String[] args)
	{	
		PrintWriter out = null;
		
		try
//		var out = new PrintWriter(new FileWriter("output.txt", true)))
//		↑閉じるときに書き込まれるのを確かめる為にリソースから外す。
		{	
			out = new PrintWriter(new FileWriter("output.txt", true));
			
			int id;
			while((id=Input.getInt("id"))!=0)
			{
				String name = Input.getString("氏名");
				double weight = Input.getDouble("体重");
				double height = Input.getDouble("身長");
				
				out.printf("%d,%s,%.1f,%.1f%n",
						id, name, weight, height);
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
//		finally {
//			if(out!=null) {
//				out.close();
//			}
//		}
	}
}
//java.io.FileWriter.FileWriter(
//String fileName,
//boolean append
//) throws IOException
//
//
//FileWriter
//public FileWriter(String fileName, boolean append) throws IOException
//FileWriterにファイル名を指定し、default charsetを使用して、書き込まれたデータを追加するかどうかを示すブール値を構成します。
//パラメータ:
//fileName - システムに依存するファイル名の文字列。
//append - booleanがtrueの場合、バイトはファイルの先頭ではなく最後に書き込まれる。
//スロー:
//IOException - 指定されたファイルが存在するが通常ファイルではなくディレクトリである場合、存在せず作成もできない場合、またはなんらかの理由で開くことができない場合