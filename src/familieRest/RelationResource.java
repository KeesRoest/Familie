package familieRest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojo.Person;
import service.RelationService;

@Path("/relation")
public class RelationResource {

	@Inject
	private RelationService relationService;

	@GET
	@Path("/partner/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getPartner(@PathParam("id") Long id) {
		Person person = relationService.getPartner(id);
		if (person == null) {
			throw new NoPartnerException("Geen partner gevonden");
		}
		return person;
	}

}
