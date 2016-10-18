package FamilieRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/overOns")
public class OverOnsResource {

	@GET
	public String overOns() {
		return "<p>Hello Familie</p>";
	}
}