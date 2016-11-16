package familieRest;


import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojo.Stamboom;
import service.StamboomService;

@Path("/stamboom")
public class StamboomResource {

	@Inject
	private StamboomService stamboomService;

	@Produces(MediaType.APPLICATION_JSON)
	public Stamboom getStamboom() {
		Stamboom stamboom = stamboomService.getStamboom();
		return stamboom;
	}
}
