package chapter14_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Sample3 {

	public static void main(String[] args) //throws IOException
	{		
		Path p = Path.of("__fruit.txt");
		
		try (var in = Files.newBufferedReader(p)) {
			System.out.println(in.readLine());
		} 
		catch (IOException e) {
			System.err.println(e+"ﾌｧｲﾙ読めず");
		}

	}
}
