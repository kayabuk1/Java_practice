package chapter19_1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample3 {

	public static void main(String[] args) {
		
		ExecutorService pool
		= Executors.newFixedThreadPool(5);
		
		for (int i = 0 ; i < 6; i++) {
			CompletableFuture
			.supplyAsync(()->mailService(), pool)
			.thenAccept((message)->sendReport(message));
		}
		
		Tools.print("メール送信依頼した");
		pool.shutdown();
	}

	public static String mailService() {
		Tools.sleep(1000);
		return "送信：〇件、アドレス不正：〇件";
	}
	
	public static void sendReport(String message) {
		Tools.print(message);
	}
}

//◆実行結果
//3:21:51.3216(main)メール送信依頼した
//3:21:52.2934(pool-1-thread-1)送信：〇件、アドレス不正：〇件
//
//◆繰り返し処理版 ※通常mailService()のようなメソッドは一件ずつ送ることが多いとのこと。
//3:41:26.9738(main)メール送信依頼した
//3:41:27.9403(pool-1-thread-1)送信：〇件、アドレス不正：〇件
//3:41:27.9403(pool-1-thread-4)送信：〇件、アドレス不正：〇件
//3:41:27.9403(pool-1-thread-2)送信：〇件、アドレス不正：〇件
//3:41:27.9403(pool-1-thread-3)送信：〇件、アドレス不正：〇件
//3:41:27.9403(pool-1-thread-5)送信：〇件、アドレス不正：〇件
//3:41:28.9532(pool-1-thread-1)送信：〇件、アドレス不正：〇件