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
		List<Stamboom> stamboom = ouders;
		while (ouders.size() != 0) {
			ouders = stamboomDAO.getKinderen(ouders);
			stamboom.addAll(ouders);
		}
		return stamboom;
	}
	
}
