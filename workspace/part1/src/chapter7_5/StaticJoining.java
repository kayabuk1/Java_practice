package chapter7_5;

import chapter7_2.Joining;

public class StaticJoining {
	private static String csv;
	private static String delimiter;
	
	public static void inti (String _csv, String _delimiter)
	{
		csv = _csv;
		delimiter = _delimiter;
	}

	public static  void add(String s) {
		csv += csv.isEmpty() ? s : delimiter + s;
	}
	public static String getCsv(){
		return csv;
	}
	public static void main(String[] arg) {
		Joining j = new Joining("", ",");
		j.add("apple");
		j.add("apple");
		j.add("apple");
		System.out.println(j.getCsv());
	}
	
	
}
