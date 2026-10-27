package chapter19_2;

import chapter19_1.Tools;

public class Sample5 {

	public static void main(String[] args) {
		
		var count = new Count();
		for (int i=0; i <5 ; i++) {
			new Thread(()->count.update()).start();
		}
	}

}

class Count{
	private int number = 0;
	
	public 
	synchronized 
	void update() {
		number++;
		Tools.sleep(1);
		Tools.print(number);
	}
}
//実行結果
//9:23:28.3206(Thread-0)1
//9:23:28.3336(Thread-3)2
//9:23:28.3356(Thread-4)3
//9:23:28.3386(Thread-2)4
//9:23:28.3416(Thread-1)5

//synchronizedをコメントアウトした結果。
//9:29:13.7650(Thread-4)5
//9:29:13.7650(Thread-3)5
//9:29:13.7650(Thread-2)5
//9:29:13.7650(Thread-0)5
//9:29:13.7650(Thread-1)5