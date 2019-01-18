package fig;

public class Prenom {
	private String prenom;
	private String sexe;
	
	public Prenom(String prenom/*, String sexe*/) {
		super();
		this.prenom = prenom;
		/*this.sexe = sexe;*/
	}
	public Prenom() {};
	
	@Override
	public String toString() {
		return prenom /*+ " " + sexe*/;
	}

	
	
	
}
