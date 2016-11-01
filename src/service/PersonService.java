package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import dao.PersonDAO;
import pojo.Person;

@Stateless
@Transactional
public class PersonService {

	@Inject
	private PersonDAO personDAO;
	
	public void addPerson(Person person) {
		personDAO.savePerson(person);
	}

	public List<Person> getPersons() {
		List<Person> persons = personDAO.getPersons();
		return persons;
	}

	public Person getPerson(Long id) {
		Person person = personDAO.getPerson(id);
		return person;
	}
	
	public Boolean existPerson(Person person) {
		Boolean result = personDAO.existPerson(person);
		return result;
	}
}