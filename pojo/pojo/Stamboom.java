package pojo;

import java.util.List;

public class Stamboom {
	private List<Person> ouders;
	private List<Person> kinderen;
	private Stamboom stamboom;
	
	public List<Person> getOuders() {
		return ouders;
	}

	public void setOuders(List<Person> ouders) {
		this.ouders = ouders;
	}
	
	public List<Person> getKinderen() {
		return kinderen;
	}

	public void setKinderen(List<Person> kinderen) {
		this.kinderen = kinderen;
	}

	public Stamboom getStamboom() {
		return stamboom;
	}

	public void setStamboom(Stamboom stamboom) {
		this.stamboom = stamboom;
	}
}
