package fig;

public class VilleFr {
	private String codeCommune;
	private String nomVille;
	private String codepost;
	private String numdep;
	private String nomdep;
	
	
	public VilleFr(String codeCommune, String nomVille, String codepost, String numdep) {
		super();
		this.codeCommune = codeCommune;
		this.nomVille = nomVille;
		this.codepost = codepost;
		this.numdep = numdep;
	}
	public VilleFr(String codeCommune, String nomVille, String codepost, String numdep, String nomdep) {
		super();
		this.codeCommune = codeCommune;
		this.nomVille = nomVille;
		this.codepost = codepost;
		this.numdep = numdep;
		this.nomdep = nomdep;
	}
	public VilleFr() {};
	
	public String getCodeCommune() {
		return codeCommune;
	}
	
	public void setCodeCommune(String codeCommune) {
		this.codeCommune = codeCommune;
	}
	public String getNomVille() {
		return nomVille;
	}
	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}
	public String getCodepost() {
		return codepost;
	}
	public void setCodepost(String codepost) {
		this.codepost = codepost;
	}
	public String getNumdep() {
		return numdep;
	}
	public void setNumdep(String numdep) {
		this.numdep = numdep;
	}
	
	
	
	public String getNomdep() {
		return nomdep;
	}
	public void setNomdep(String nomdep) {
		this.nomdep = nomdep;
	}
	@Override
	public String toString() {
		return "VilleFr [codeCommune=" + codeCommune + ", nomVille=" + nomVille + ", codepost=" + codepost + ", numdep="
				+ numdep + "]";
	}

	
	
	
}
