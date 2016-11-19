package familieRest;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojo.Stamboom;
import service.StamboomService;

@Path("/stamboom")
public class StamboomResource {

	@Inject
	private StamboomService stamboomService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Stamboom> getStamboom() {
		System.out.println("REST");
		List<Stamboom> stamboom = stamboomService.getStamboom();
		return stamboom;
	}
}
