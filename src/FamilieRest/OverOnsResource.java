package FamilieRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/overOns")
public class OverOnsResource {

	@GET
	public String overOns() {
		return "<p>Wij zijn Kees en Ronald. Wij nemen deel aan een omscholingstraject tot Java programmeur. Dit project hebben wij ontwikkeld om ervaring op te doen met programmeren in Java in een internet omgeving.</p>";
	}
}