package service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.StamboomDAO;
import pojo.Stamboom;

@Stateless
public class StamboomService {

	@Inject
	private StamboomDAO stamboomDAO;

	public List<Stamboom> getStamboom() {
		System.out.println("Service");
		List<Stamboom> ouders = stamboomDAO.getFamilieOudste();
		return ouders;
/*
		List<Long> ouders = new ArrayList<Long>();
		ouders.add(familieOudsteID);
		for (Long ouder : ouders) {
			stamboomDAO.getKinderen(ouder);
		}
		Stamboom stamboom = null;
		return stamboom;
*/
	}
	
}
