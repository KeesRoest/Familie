package dao;

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
	
}
