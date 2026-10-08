package chapter14_1;
//リソース付きtry文を使わない場合。

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sample2 {

	public static void main(String[] args) {
		
		BufferedReader in = null;
		try {
			Path p = Path.of("fruit.txt");
			in = Files.newBufferedReader(p);
//			public static BufferedReader 
//			newBufferedReader(Path path) throws IOException
//			ファイルを読込み用に開き、効率的な方法でファイル
//			からテキストを読み込む BufferedReader 
//			を返します。⇒なので BufferedReader型
//			
			var list = Files.readAllLines(p);
//			↑Sample1とは違うファイルの読み込み方
//			↓で1行ずつファイル内容を読み取っているが、
//			読み込む前にファイル内容をもったオブジェクトを
//			生成してそれを変数に格納している。
			
			System.out.println(in.readLine());
//			in.readLine()で1行だけ読む。
			in = null;
//			in.close();
//			①↑この場所だと「クローズ処理」が行われない可能性
			
		} catch (IOException e) {
			System.err.println(e+"ファイルが読み込めん");
		}finally {
			try {
				if(in != null) {
					in.close();
					System.out.println("ちゃんと閉じました");
				}
//			②↑しかし単純に移しただけではスコープ{}外の為
//			アクセス出来ない。
//			そこでグローバル領域に in変数を事前に作っておく
//			③すると、- 処理されない例外の型 IOException
//			次にIOExceptionが処理されないとエラーが出る。
//			ので in.close();を try-catchで囲む。
			} catch (IOException e) {
				System.err.println("ﾌｧｲﾙｸﾛｰｽﾞ失敗");
//				④NullPointerException: Cannot invoke
//				"java.io.BufferedReader.close()"
//				because "in" is null
//				パスが間違っていると nullＰｏが出る例外が残っていた。
//				if (in != null)を追加してやる必要がある。
//				⑤ここまでやっと例外が発生しなくなる...。
			}
			
		}
	}

}
