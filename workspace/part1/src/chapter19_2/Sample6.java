package chapter19_2;

import java.util.List;

import chapter19_1.Tools;

public class Sample6 
{
	public static void main(String[] args) 
	{
		var room = new CookingRoom();
		var menus 
		= List.of(
				"エビフライ",
				"ヒレカツ",
				"オムレツ",
				"ハヤシライス",
				"カレーライス",
				"ハンバーグ"
				);
			
		for (String m : menus)
		{
			new Thread(
					()->room.cooksJob(m)).start();
			new Thread(()->{
				String dish = room.waitersJob();
				Tools.sleep(500);
				Tools.print(dish);
			}).start();
		}
	}
}
