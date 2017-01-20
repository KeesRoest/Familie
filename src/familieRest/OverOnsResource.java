package familieRest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/overOns")
public class OverOnsResource {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String overOns() {
		return "<h2>Even voorstellen...</h2> <p>Wij zijn Kees en Ronald. Wij nemen deel aan een omscholingstraject tot Java programmeur. Dit project hebben wij ontwikkeld om ervaring op te doen met programmeren in Java in een internet omgeving met HTML, CSS en Javascript.</p>";
	}
}