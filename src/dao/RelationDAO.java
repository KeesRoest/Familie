package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import pojo.Person;
import pojo.Relation;
import dao.PersonDAO;

@Stateless
public class RelationDAO {

	@Inject
	private PersonDAO personDAO;

	@PersistenceContext
	private EntityManager em;

	public Person getPartner(Long id) {
		Person person = null;
		try {
				Relation relation = em.createQuery("SELECT r FROM Relation r where person1_id = " + id + " And relatietype = 'Is gehuwd met'" , Relation.class).getSingleResult();
				person = relation.getPerson2();
		}
		catch (NoResultException e) {
				person = null;
		}
		return person;
	}

	public void setRelation(Boolean partner, String relationType, Long person1_id, Long person2_id) {
		Person person1 = personDAO.getPerson(person1_id);
		Person person2 = personDAO.getPerson(person2_id);
		Long id1       = person1.getId();
		Long id2       = person2.getId();
		String sql = "SELECT r FROM Relation r where (person1_id = " + id1;
		if (partner == true) {
			sql += " or person2_id = " + id1
				+  " or person1_id = " + id2
				+  " or person2_id = " + id2
				+  ") And partner = true";
		}
		else {
			sql += ") And relatietype = " + relationType;
		}
		List<Relation> resultlist = em.createQuery(sql, Relation.class).getResultList();
		for (Relation relatie : resultlist) {
			em.remove(relatie);
		}
/*
 		try {

				relation = em.createQuery("SELECT r FROM Relation r where person1_id = " + id1 + " And relatietype = 'Is gehuwd met'" , Relation.class).getSingleResult();
				em.remove(relation);
		}
		catch (NoResultException e) {
				relation = null;
		}
*/
		return;
	}
}
