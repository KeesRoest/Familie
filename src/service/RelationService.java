package service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import dao.RelationDAO;
import pojo.Person;
import pojo.Relation;

@Stateless
@Transactional
public class RelationService {
	
	@Inject
	private RelationDAO relationDAO;

	public Person getPartner(Long id) {
		Person person = relationDAO.getPartner(id);
		return person;
	}
	
	public Relation getRelation(Long id) {
		Relation relation = relationDAO.getRelation(id);
		return relation;
	}
	
	public void setRelation(Boolean partner, String relationType, Long person1_id, Long person2_id) {
		relationDAO.setRelation(partner, relationType, person1_id, person2_id);
		return;
	}
	
}
