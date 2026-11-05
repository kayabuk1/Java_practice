package jp.ac.funagi.itot01;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
//↑クラスにアノテーションをつけると、そのクラスに属する全ての
//メソッドに適用される。
@Path("/books")
//↑パスもメインリソースになり、/books/サブリソースという並びになる
public class BookResource {
	
	private final BookRepository repository
		= new BookRepository();
	
	@GET
	@Path("/{id}")
	public Book getBookById(@PathParam("id") long id) 
	{
		return repository.findById(id);
//		返されるのはDBの結果セットから生成されたBookレコードオブジェクト
//		このBookオブジェクトを quarkus-rest-jackson が自動的にJSONに
//		変換して、リクエストに対して返している。
//		quarkus-jacksonだけだと、変換が行われず、
//		Quarkusは返されたBookのオブジェクトを、toString()で文字列にして、
//		ただのテキストとして返していた。
	}
	
	@GET
	public List<Book> getAllBooks() {
		return repository.findAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
//	◆@Consumesのネイティブの感覚
//	アノテーションの「ネイティブ（英語圏のエンジニア）のニュアンス」は、
//	「このメソッド（またはクラス）は〜〜を食べます（消費します）」 という感覚。
//	英語の consume は、単に「受け取る（receive）」のではなく、「エネルギー源として消費する」「食べて体内に取り込む」 というニュアンスがあります。
//	• APIのメソッドを「生き物や機械」に見立てています。
//	• @Consumes(MediaType.APPLICATION_JSON) であれば、「このメソッドは JSON を大好物としてパクパク食べて、処理のエネルギー（データ）にします」 という感覚
//	ネイティブにとって @Consumes は、単なる「設定」というよりも 「それしか食べられない偏食家」 のような強い制限のニュアンスを含みます。
//	@Consumes: 「私の大好物はこれです。これを持ってきてくれたら美味しく処理（消費）します！」
	public Response create(Book book)
	{
		repository.save(book);
		return Response.status(Response.Status.CREATED).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Book book)
	{	
		repository.update(book);
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") long id)
	{
		repository.delete(id);
		
		return Response.noContent().build();
	}
}












