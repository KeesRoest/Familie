package dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import pojo.Person;
import pojo.Relation;

@Stateless
public class RelationDAO {

	@PersistenceContext
	private EntityManager em;

	public Person getPartner(Long id) {
		Person person = null;
		try {
				Relation relation = em.createQuery("SELECT r FROM Relation r where person1_id = " + id + " And relatietype = 'Gehuwd met'" , Relation.class).getSingleResult();
				person = relation.getPerson2();
		}
		catch (NoResultException e) {
				person = null;
		}
		return person;
	}
}
