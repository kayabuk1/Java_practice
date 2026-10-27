package org.acme;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
//	@Path("/{friend}")
	public String hello
	(
//			@PathParam("friend")  ﾊﾟｽﾊﾟﾗﾒｰﾀは使わないのでｺﾒﾝﾄｱｳﾄ
			@QueryParam("friend")
			@DefaultValue("田中")
				String friend,
			@QueryParam("age")
			@DefaultValue("20")
				int age
	)
	{
		return "Hello from Quarkus REST  " 
				+ friend+"\t"
				+ age+"歳";
	}
}
