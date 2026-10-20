package chapter18_1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import jp.kwebs.lib.Input;

public class Sample6 {

	public static void main(String[] args)
	{
		try 
		(var out = new PrintWriter("output.txt"))
		{
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
		}
	}
}
//PrintWriter java.io.PrintWriter.printf(
//String format,
//Object... args
//)
//
//
//printf
//public PrintWriter printf(String format, Object... args)
//指定された書式文字列および引数を使用して、書式付き文字列をこのライターに
//書き込む簡易メソッドです。 自動フラッシュが有効な場合は、このメソッドを呼び出すと
//出力バッファがフラッシュされます。
//out.printf(format, args)形式のこのメソッドの起動は、起動とまったく同じように動作
//
//コピースニペットのコピー
//    out.format(format, args)
//パラメータ:
//format - 「書式文字列の構文」で説明した書式文字列。
//args - 書式文字列の書式指示子により参照される引数。 引数が書式指定子よりも多い場合、余分な引数は無視されます。 引数の数は変数で、0(ゼロ)の場合があります。 引数の最大数は、「Java Virtual Machine仕様」で定義されているJava配列の最大サイズによって制限されます。 引数がnullの場合、動作は変換に応じて異なる。
//戻り値:
//このライター
//スロー:
//IllegalFormatException - 書式文字列が、不正な構文、所定の引数と互換性がない書式指示子、書式文字列に指定された不適切な引数、またはほかの不正な条件を含む場合。 考えられるすべての書式エラーの仕様については、フォーマッタ・クラス仕様の「詳細」セクションを参照。
//NullPointerException - formatがnullの場合
//導入されたバージョン:
//1.5

////PrintWriterの内部イメージ（実際の中身）
//public PrintWriter(String fileName) throws FileNotFoundException {
// // 1. 内部でこっそり「ファイル出力用の職人（FileOutputStreamなど）」を生成
// // 2. それを自分のメイン機能にガッチャンコしている
// this(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName))), true);