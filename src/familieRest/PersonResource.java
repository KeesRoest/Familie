package familieRest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import pojo.Person;

import service.PersonService;


@Path("/person")
public class PersonResource {

	@Inject
	private PersonService personService;
	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Person> getPersons() {
		List<Person> personList = personService.getPersons();
		return personList;
	}

	@GET
	@Path("/one/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Person getOnePerson(@PathParam("id") Long id) {
		Person person = personService.getPerson(id);
		System.out.println(person.getGeboortedatum());
		return person;
	}

    @POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addPerson(Person person) {
    	if (personService.existPerson(person) == false) {
    		personService.addPerson(person);
    		System.out.println("Added a person with firstname " + person.getRoepnaam() + " and with lastname " + person.getAchternaam());
    	}
    	else {
    		throw new DuplicatePersonException("Person " + person + " already exists");
    	}
	}
    
    @POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updatePerson(Person person) {
    	if (personService.existPerson(person) == true) {
    		personService.updatePerson(person);
    		System.out.println("Updated a person with firstname " + person.getRoepnaam() + " and with lastname " + person.getAchternaam());
    	}
	}
}

