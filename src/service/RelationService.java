package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import dao.PersonDAO;
import dao.RelationDAO;
import pojo.Person;
import pojo.Relation;

@Stateless
@Transactional
public class RelationService {
	
	@Inject
	private RelationDAO relationDAO;

	@Inject
	private PersonDAO personDAO;

	public Person getPartner(Long id) {
		Person person = relationDAO.getPartner(id);
		return person;
	}
	
	public Relation getRelation(Long id) {
		Relation relation = relationDAO.getRelation(id);
		return relation;
	}

	public void setRelation(Boolean partner, String relationType, Long person1_id, Long person2_id) {
/*
 * Als een relatie met een partner wordt aangegeven, worden eerst de bestaande relaties van hetzelfde relatietype verwijderd.
 * Voor een partner geldt dit naar 2 kanten, voor een kind alleen van het kind naar de ouder.
 * Bij een kind wordt alleen de ouder met hetzelfde geslacht als de nieuwe ouder verwijderd.
 * 
 * Vervolgens worden voor een partner 2 relaties gelegd, 1 van de persoon naar de partner en 1 andersom.
 * 
 * Voor een kind wordt 1 relatie gelegd.
 * 
 */
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
			sql += ") And relatietype = '" + relationType + "'";
		}
		List<Relation> resultlist = relationDAO.getRelations(sql);
		for (Relation relatie : resultlist) {
			if (partner == true) {
				relationDAO.deleteOne(relatie);
			}
			else {
				Person personOld = relatie.getPerson2();
				if (personOld.getGeslacht() == person2.getGeslacht()) {
					relationDAO.deleteOne(relatie);
				}
			}
		}
		Relation relation = new Relation(relationType, partner, person1, person2);
		relationDAO.saveRelation(relation);
		if (partner == true) {
			relation = new Relation(relationType, partner, person2, person1);
			relationDAO.saveRelation(relation);
		}
		return;
	}
	
}
