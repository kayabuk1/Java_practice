package jp.ac.funagi.itot01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookRepository {
	
//	DBサーバへの接続情報を定義
	private final String url =
			"jdbc:oracle:thin:@//192.168.11.6:1521/freepdb1";
	private final String user = "iot10";
	private final String password = "iot10";
	
	private Book findById(long id)
	{
		Book book = null;
		String sql = "SELECT * FROM books WHERE id = ?";
		
		try 
		(Connection con
				= DriverManager.getConnection(url, user, password);
		PreparedStatement ps = con.prepareStatement(sql))
		{
			ps.setLong(1, id);
			
			try (ResultSet rs = ps.executeQuery())
			{
				if (rs.next()) book = mapRowToBook(rs);
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return book;
	}
	
	private Book mapRowToBook(ResultSet rs)
	throws SQLException
	{
		return new Book(
				rs.getLong("id"),
	            rs.getString("title"),
	            rs.getString("genre"),
	            rs.getString("author"),
	            rs.getInt("price"),
	            rs.getBoolean("stock")
				);
	}
	
	
	public static void main(String[] args) {
		BookRepository repository = new BookRepository();
		Book book = repository.findById(1);
		System.out.println("DBから取得した書籍情報："+book);
		
	}
}


//package jp.ac.funagi.itot01;
//
//public record Book(
//		long id, //書籍ID
//		String title, //書籍タイトル
//		String genre, //書籍ジャンル
//		String author, //著者名
//		int price, //価格
//		boolean stock //在庫有無 
//		) {}













