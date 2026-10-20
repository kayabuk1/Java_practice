package chapter18_1;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Sample5 {

	public static void main(String[] args) {
		
		var list = new ArrayList<Measurement>();
		var path = Path.of("Sample.txt");
		
		try (var sc = new Scanner(path))
		{
			sc.useDelimiter("(\\s*,\\s*)|(\\s+)");
			while(sc.hasNext())
			{
				list.add(
						new Measurement(
									sc.nextInt(),
									sc.next(),
									sc.nextDouble(),
									sc.nextDouble()
								));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		list.forEach(System.out::println);
	}

}
