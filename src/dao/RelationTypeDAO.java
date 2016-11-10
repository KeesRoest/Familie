package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import pojo.RelationType;

@Stateless
public class RelationTypeDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void saveRelationType(RelationType relationType) {
		em.persist(relationType);
	}
	
	public List<RelationType> getRelationTypes() {
		List<RelationType> resultList = em.createQuery("SELECT r FROM RelationType r", RelationType.class).getResultList();
		System.out.println(resultList);
		return resultList;
	}

	public RelationType getRelationType(Long id) {
		RelationType result = em.createQuery("SELECT r FROM RelationType r where id = " + id , RelationType.class).getSingleResult();
		return result;
	}
	

}
