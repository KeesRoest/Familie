package service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.StamboomDAO;
import pojo.Stamboom;

@Stateless
public class StamboomService {

	@Inject
	private StamboomDAO stamboomDAO;

	public Stamboom getStamboom() {
		Stamboom stamboom = null;
		return stamboom;
	}
	
}
