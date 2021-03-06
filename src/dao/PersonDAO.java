package dao;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
		System.out.println(resultList);
		return resultList;
	}

	public Person getPerson(Long id) {
		Person result = em.createQuery("SELECT p FROM Person p where id = " + id , Person.class).getSingleResult();
		return result;
	}
	
	public Boolean existPerson(Person person) {
		System.out.println("personDAO existPerson");
		Person result = null;
		try {
			result = em.createQuery("SELECT p FROM Person p where achternaam = '"
					+ person.getAchternaam() + "'"+ " And roepnaam = '" + person.getRoepnaam() + "'" 
		            + " And geboortedatum = '" + person.getGeboortedatum() + "'",
		            Person.class).getSingleResult();
		}
		catch (NoResultException e) {}
		if (result == null) {
			return new Boolean(false);}
		else{
			return new Boolean(true);
		}
	}
	
	public void updatePerson(Person person) {
		System.out.println("Update person DAO");
		em.merge(person);
	}
	
}
