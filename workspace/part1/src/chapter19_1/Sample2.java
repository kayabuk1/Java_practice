package chapter19_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample2 {

	public static void main(String[] args) {
		
		ExecutorService pool
		= Executors.newFixedThreadPool(3);
		
		pool.submit(()->doTask(1));
		pool.submit(()->doTask(2));
		pool.submit(()->doTask(3));
		pool.submit(()->doTask(4));
		
		pool.shutdown();
	}
	
	public static void doTask(int n) {
		Tools.sleep(1000);
		Tools.print("task-" + n);
	}
}

////実行結果
//2:47:36.9546(pool-1-thread-3)task-3
//2:47:36.9546(pool-1-thread-2)task-2
//2:47:36.9546(pool-1-thread-1)task-1
//2:47:37.9758(pool-1-thread-2)task-4

