package chapter3_5;

import java.util.List;

import chapter3_2.Population;

public class Sample5 {

	public static void main(String[] args) {
		var list = List.of(
				new Population("北海道", 5250, -6.8),
				new Population("東京都", 13921, 7.1),
				new Population("大阪府", 8809, -0.4),
				new Population("福岡県", 5104, -0.7),
				new Population("沖縄県", 1453, 3.9)
				);
		for (Population p: list) {
			System.out.println(p);
		}
/*
 * Population[prefecuture=北海道, population=5250, rate=-6.8]
Population[prefecuture=東京都, population=13921, rate=7.1]
Population[prefecuture=大阪府, population=8809, rate=-0.4]
Population[prefecuture=福岡県, population=5104, rate=-0.7]
Population[prefecuture=沖縄県, population=1453, rate=3.9]
 */
	}

}
