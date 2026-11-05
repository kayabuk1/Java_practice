package jp.ac.funagi.itot01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

//◆このアノテーションを付けると、
//このクラスのオブジェクトをCDIコンテナの管理対象にするという意味がある。
@ApplicationScoped
public class BookRepository {
	
////◆	DBサーバへの接続情報を定義 ⇒ハードコーデイングされているものを
/// リソースをコンテナから注入してもらう方式に変える。
//	private final String url =
//			"jdbc:oracle:thin:@//192.168.11.6:1521/freepdb1";
//	private final String user = "iot10";
//	private final String password = "iot10";
////src\main\resourcesのapplication.propatiesに↑をコピーして↓に変更。	
	@Inject
	DataSource dataSource;
	
//	◆一件取得するメソッド
	Book findById(long id)
	{
		Book book = null;
		String sql = "SELECT * FROM books WHERE id = ?";
//		■なぜ文字列結合を使わないのか？ books WHERE id" + id;としないのは、
//		SQLインジェクションを防ぐため。
//		id = "1 or 1 = 1"みたいな文字列を埋め込まれてしまうと、
//		常にtrueで全てのidが対象になってしまう。
//		そのため.prepareStatement(sql), .setLong(1, id)を使って埋め込んでいる。
		
		try 
		(Connection con
				= DriverManager.getConnection(url, user, password);
		PreparedStatement ps 
			= con.prepareStatement(sql))
//		「これは『usersテーブルからidを条件に検索する命令』だな」と、
//		SQLの構造（命令の骨組み）を先に確定させる。
//		データはただの「値」として扱う。
//		イメージ：構造は変わらず、値としてそのまま比較される。
//		SELECT * FROM users WHERE id = '1 OR 1=1'; 
		{
			ps.setLong(1, id);
//			↑ここで？に id を埋め込んでいる。1 というのは一つ目の「?」という意味。
//			※プレースホルダーは 1 始まりなので、地味に注意。
			
			try (ResultSet rs = ps.executeQuery())
//			組み立てた ps を使って結果セットを受け取る、流れなのでどうしても二重tryになる
//			※これもリソースなので、tryが必要。
//			●これもリソース？
//			データベース（DB）への接続やクエリの実行によってオープンされた 
//			ResultSet は、裏側でDBサーバーのメモリやカーソルといった重要な
//			システムリソースを消費しているのでリソース。
//			.executeQuery()でもし throws SQLException が発生したら、
//			外側のcatchで受け取る。
			{
				if (rs.next()) book = mapRowToBook(rs);
//				ResultSet（rs）は、取得した直後は最初の行の「一つ手前（先頭の前）」を指している
			}
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return book;
	}
	
//	◆DBの結果セットからJavaのBookレコードオブジェクトへ変換するメソッド
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
//	            ↑.get~メソッドはDB結果セットの値をJavaの指定データ型として取り出す。
//	            ↑ここに指定する文字列はテーブル項目。勿論名前型共に一致している必要がある。
				);
	}
	
//	◆全件取得
	public List<Book> findAll()
	{
		List<Book> books = new ArrayList<>();
		String sql = "SELECT * FROM books ORDER BY id";
		
		try (Connection con 
					= DriverManager.getConnection(url, user, password);
				PreparedStatement ps 
					= con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery())
		{
			while(rs.next()) 
			{
				books.add(mapRowToBook(rs));
			}
		} 
		catch (SQLException e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return books;
	}
	
//	◆新規登録メソッド(INSERT)
	public void save(Book book)
	{
		String sql
		= "INSERT INTO books (title, genre, author, price, stock)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		try (Connection con 
				= DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement(sql)) 
		{
			ps.setString(1, book.title());
			ps.setString(2, book.genre());
			ps.setString(3, book.author());
			ps.setInt(4, book.price());
			ps.setBoolean(5, book.stock());
			
//		SELECT以外は ↓を使う。
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	// ◆更新 (UPDATE)
	public void update(Book book)
	{
	    String sql 
	    = "UPDATE books SET title = ?, genre = ?, author = ?, "
	    		+ "price = ?, stock = ? WHERE id = ?";

	    try (Connection con 
	    		= DriverManager.getConnection(url, user, password);
	         PreparedStatement ps = con.prepareStatement(sql))
	    {
	        ps.setString(1, book.title());
	        ps.setString(2, book.genre());
	        ps.setString(3, book.author());
	        ps.setInt(4, book.price());
	        ps.setBoolean(5, book.stock());
	        ps.setLong(6, book.id());

	        ps.executeUpdate();
	    } 
	    catch (SQLException e) 
	    {
	        e.printStackTrace();
	    }
	}

	
//	◆削除
	public void delete(long id)
	{
		String sql 
		= "DELETE FROM books WHERE id = ?";
		
		try (Connection con 
				= DriverManager.getConnection(url, user, password);
				PreparedStatement ps = con.prepareStatement(sql)) 
		{
			ps.setLong(1, id);
			ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
//	◆mainメソッド
	public static void main(String[] args) 
	{
		BookRepository repository = new BookRepository();
		
//		Book book = repository.findById(1);
//		System.out.println("DBから取得した書籍情報："+book);
//		
//		List<Book> bookList = repository.findAll();
//		bookList.forEach(System.out::println);
		
		Book beforeBook = repository.findById(29);
		System.out.println("更新前"+beforeBook);
		
		Book updateBook
		= new Book(29, "更新タイトル", "更新ジャンル", "更新著者", 1, false);
		repository.update(updateBook);
		
		Book afterBook = repository.findById(29);
		System.out.println("更新後"+afterBook);
		
		System.out.println("削除前"+repository.findById(30));
		repository.delete(30);
		System.out.println("削除後"+repository.findById(30));
		
//		更新前Book[id=29, title=更新タイトル, genre=更新ジャンル, author=更新著者, price=1, stock=false]
//				更新後Book[id=29, title=更新タイトル, genre=更新ジャンル, author=更新著者, price=1, stock=false]
//				削除前Book[id=30, title=情報倫理, genre=その他, author=小川洋子, price=1250, stock=true]
//				削除後null
	}
}

//◆Bookレコード構造
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













