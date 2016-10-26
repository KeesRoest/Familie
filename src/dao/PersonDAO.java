package dao;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pojo.Person;

@Stateless
public class PersonDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void savePerson(Person person) {
		em.persist(person);
	}
	
	public List<Person> getPersons() {
		List<Person> resultList = em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
		return resultList;
	}
}
