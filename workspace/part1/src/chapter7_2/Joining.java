package chapter7_2;

public class Joining {
	private String csv;
	private String delimiter;
	
	public Joining(String csv, String delimiter) {
//		super();
		this.csv = csv;
		this.delimiter = delimiter;
	}
	public Joining(String delimiter) {
//		super();
//		this.csv = "";
//		this.delimiter = delimiter;
//		↓this();を使った書き換え。
		this("", delimiter);
	}
	public Joining() {
//		super();
//		this.csv = "";
//		this.delimiter = ",";
		this("", ",");
	}
	
	public void add(String s) {
		csv += csv.isEmpty() ? s : delimiter + s;
//		this.csv += this.csv.isEmpty() ? s :delimiter + s;と書いても同じ。
//		明示的にフィールド変数(インスタンス変数)に代入していると
//		書きたい場合はきちんとthis.を書く。
//		isEmpty()はStringクラスのメソッド。文字列長が０の時にtrue返す。
//		sが空の場合は、引数で貰ったものをそのまま代入する。
//		空でない時は、delimiterと合わせて代入する。
	}
	public String getCsv(){
		return csv;
	}
}
