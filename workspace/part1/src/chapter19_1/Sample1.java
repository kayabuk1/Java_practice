package chapter19_1;

public class Sample1 {

	public static void main(String[] args) {
		
		var thread = new Thread(()->print());
		thread.start();
//		start
//		public void start()
//		実行を開始するようにこのスレッドをスケジュールします。 
//		スレッドは現在のスレッドとは独立して実行されます。
//		スレッドは一度に開始できます。 特に、スレッドは終了後に
//		再起動することはできません。
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO 自動生成された catch ブロック
//			e.printStackTrace();
//		}
		System.out.println("メインスレッド終了");
	}
	public static void print() {
		
		System.out.println("別のスレッドで実行した。");
	}

}
//Threadのecliｐseの説明がよく分からない。
//public Thread(Runnable task)
//新しいプラットフォームThreadを初期化します。 
//このコンストラクタは、Thread (null, task, gname)と同じ効果を持ちます。
//ここで、gnameは新しく生成された名前です。
//自動的に作成される名前は、nを整数とすると"Thread-"+nの形式を取ります。