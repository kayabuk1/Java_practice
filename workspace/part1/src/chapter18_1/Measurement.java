package chapter18_1;

public record Measurement(
		int id, String name, double weight, double height ) 
{
	public Measurement(String[] items) {
		this(
				Integer.valueOf(items[0]),
				items[1],
				Double.valueOf(items[2]),
				Double.valueOf(items[3])
				);
	}
}
