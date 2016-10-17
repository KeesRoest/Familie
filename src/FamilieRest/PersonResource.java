package FamilieRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/HelloWorld")
public class PersonResource {

	@GET
	@Path("/sayHello")
	public String sayHello() {
		return "<p>Hello Familie</p>";
	}
}