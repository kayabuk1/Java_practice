package chapter18_1;

import java.time.LocalDate;

public record Order(
		int id, String item, int amount, LocalDate date)
{

}
