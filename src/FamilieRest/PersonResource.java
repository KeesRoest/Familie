package FamilieRest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import pojo.Person;



@Path("/person")
public class PersonResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersons() {
		List<Person> personList = new ArrayList<>();
		personList.add(new Person("Donald", "Duck"));
		personList.add(new Person("Koning", "Willem-Alexander"));
		return personList;
	}
}
