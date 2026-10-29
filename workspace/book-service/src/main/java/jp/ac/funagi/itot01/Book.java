package jp.ac.funagi.itot01;

public record Book(
		long id, //書籍ID
		String title, //書籍タイトル
		String genre, //書籍ジャンル
		String author, //著者名
		int price, //価格
		boolean stock //在庫有無 
		) {}
