package FamilieRest;

public class DuplicatePersonException extends RuntimeException {

	private static final long serialVersionUID = -7005555081593296893L;

	public DuplicatePersonException(String s) {
		super(s);
	}
	
}
