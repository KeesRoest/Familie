package dao;

import java.util.List;

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

	public Relation getRelation(Long id) {
		Relation relation = null;
		try {
				relation = em.createQuery("SELECT r FROM Relation r where person1_id = " + id + " And partner = true" , Relation.class).getSingleResult();
		}
		catch (NoResultException e) {
				relation = null;
		}
		return relation;
	}

	public List<Relation> getRelations(String sql) {
		List<Relation> resultlist = em.createQuery(sql, Relation.class).getResultList();
		return resultlist;
	}

	public Person getPartner(Long id) {
		Person person = null;
		try {
				Relation relation = em.createQuery("SELECT r FROM Relation r where person1_id = " + id + " And partner = true" , Relation.class).getSingleResult();
				person = relation.getPerson2();
		}
		catch (NoResultException e) {
				person = null;
		}
		return person;
	}
	
	public void deleteOne(Relation relation) {
		em.remove(relation);
	}

	public void saveRelation(Relation relation) {
		em.persist(relation);
	}

}
