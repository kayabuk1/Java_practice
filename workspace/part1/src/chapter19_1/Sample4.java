package chapter19_1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample4 {

	public static void main(String[] args) {
		
		ExecutorService pool
		= Executors.newFixedThreadPool(3);
		
		for (int i = 0; i < 4; i++) {
			CompletableFuture
			.supplyAsync(()->mailService(), pool)
//			.exceptionally(Throwable ->{
//				Tools.print("エラー発生"+ Throwable);
//				return "エラーの為送信出来ず";
//			})
			.thenAccept(
					(message)->sendReport(message));
		}
		
		Tools.print("メール送信依頼した");
		pool.shutdown();
	}
	
	
	public static String mailService() {
		Tools.sleep(1000);
		int n = 10/0;
		return "送信：〇件、アドレス不正：〇件";
	}
	
	public static void sendReport(String message) {
		Tools.print(message);
	}
}
//exceptionallyをコメントアウトすると
//4:1:30.4333(main)メール送信依頼した

//
//3:59:31.1172(main)メール送信依頼した
//3:59:32.0843(pool-1-thread-2)エラー発生java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
//3:59:32.0843(pool-1-thread-1)エラー発生java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
//3:59:32.0843(pool-1-thread-2)エラーの為送信出来ず
//3:59:32.0843(pool-1-thread-1)エラーの為送信出来ず
//3:59:32.0843(pool-1-thread-3)エラー発生java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
//3:59:32.0843(pool-1-thread-3)エラーの為送信出来ず
//3:59:33.0932(pool-1-thread-2)エラー発生java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
//3:59:33.0944(pool-1-thread-2)エラーの為送信出来ず
//3:59:33.0932(pool-1-thread-1)エラー発生java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
//3:59:33.0944(pool-1-thread-1)エラーの為送信出来ず









