package service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.StamboomDAO;
import pojo.Relation;
import pojo.Stamboom;

@Stateless
public class StamboomService {

	@Inject
	private StamboomDAO stamboomDAO;

	public Stamboom getStamboom() {
		System.out.println("Service");
		Long familieOudsteID = stamboomDAO.getFamilieOudste();
		List<Long> ouders = new ArrayList<Long>();
		ouders.add(familieOudsteID);
		for (Long ouder : ouders) {
			stamboomDAO.getKinderen(ouder);
		}
		Stamboom stamboom = null;
		return stamboom;
	}
	
}
