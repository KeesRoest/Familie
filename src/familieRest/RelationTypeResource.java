package familieRest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojo.RelationType;
import service.RelationTypeService;

@Path("/relationtype")
public class RelationTypeResource {

	@Inject
	private RelationTypeService relationTypeService;

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RelationType> getRelationTypes() {
		List<RelationType> relationTypeList = relationTypeService.getRelationTypes();
		return relationTypeList;
	}

}

