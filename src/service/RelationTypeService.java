package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;

import dao.RelationTypeDAO;
import pojo.RelationType;

@Stateless
@Transactional
public class RelationTypeService {
	
	@Inject
	private RelationTypeDAO relationTypeDAO;

	public List<RelationType> getRelationTypes() {
		List<RelationType> relationTypes = relationTypeDAO.getRelationTypes();
		return relationTypes;
	}

}
