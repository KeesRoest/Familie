package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;

import dao.PersonDAO;
import pojo.Person;

@Stateless
@Transactional
public class PersonService {

	@Inject
	private PersonDAO personDAO;
	
	public void addPerson(Person person) {
		showMessage("Add");
		personDAO.savePerson(person);
	}

	public void updatePerson(Person person) {
		showMessage("UPDATE");
		personDAO.updatePerson(person);
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
	
	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	
}