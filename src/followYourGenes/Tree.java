package followYourGenes;


import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;

public class Tree {
	private static int nombreMembres = 0;
	private HashMap<Integer, Person> membres;
	private ArrayList<Link> links;
	private String nom;
	
	public Tree(String n) {
		nom = n;
		membres = new HashMap<Integer, Person>();
		links = new ArrayList<Link>();
	}
	
	//supprime la personne et tous ses liens
	public void supprimerPersonne(int idPeople){
		for(int j=0; j<links.size(); j++) {
			if(links.get(j).getId2() == idPeople || links.get(j).getId1() == idPeople){
				links.remove(j);
				j--;
			}
		}
		membres.remove(idPeople);
	}
	
	//supprime un lien à partir des id des personnes qu'il relie
	public void supprimerLink(int id1, int id2) {
		for(int i=0; i<links.size(); i++){
			if(links.get(i).getId1() == id1 && links.get(i).getId2() == id2)
				links.remove(i);
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public HashMap<Integer, Person> getMembres() {
		return membres; 
	}
	
	public ArrayList<Link> getLinks() {
		return links; 
	}

	public void ajouterPersonne(String name, String firstName, String birthPlace, LocalDate birthDate, String deathPlace, LocalDate deathDate, TypeSex sex, String comment){
		Person p = new Person(name, firstName, birthPlace, birthDate, deathPlace, deathDate, sex, nombreMembres, comment);
		membres.put(nombreMembres, p);
		nombreMembres++;
	}
	
	public void ajouterPersonne(String name, String firstName, String birthPlace, LocalDate birthDate, String deathPlace, LocalDate deathDate, TypeSex sex, int id, String comment){
		Person p = new Person(name, firstName, birthPlace, birthDate, deathPlace, deathDate, sex, id, comment);
		membres.put(id, p);
		nombreMembres = id;
	}
	
	//Crée un lien Vertical, le membre le plus agé est toujours
	//placé en premier membre du lien
	public void creerLienV(int ancestor, int son){
		if(!LinkTools.existsLinkH(this, ancestor, son) && !LinkTools.existsLinkV(this, ancestor, son)){
			//On ne vérifie pas si les deux personnes ont vécu en même temps car un père peut être 
			//décédé avant la naissance du fils ou de la fille
			if(LinkTools.isOrderedLinkV(this,ancestor,son))
				links.add(new LinkV(ancestor,son,this));
			else
				links.add(new LinkV(son,ancestor,this));
		}
	}
	
	public void creerLienH(int id1, int id2, TypeLinkUnion type){
		if(!LinkTools.existsLinkH(this, id1, id2) && !LinkTools.existsLinkV(this, id1, id2)){
			if(LinkTools.validateHLink(this, id1, id2))
				links.add(new LinkH(type, id1, id2, this));
			else
				System.out.println("Erreur: les deux personnes n'étaient pas vivantes au même moment");
		}
	}
	
	public Person getPersonne(int id){return membres.get(id);}
	
	public TypeSex getTypeSex(String s) {
		if(s.equals("Homme"))
			return TypeSex.Homme;
		else if(s.equals("Femme"))
			return TypeSex.Femme;
		else
			return TypeSex.Autre;
	}
	
	public String toString() {
		String s = "";
		int size = membres.size();
		for(int i=0;i<size;i++) {
			if(getPersonne(i) != null){
				s+= getPersonne(i).toString()+"\n";
			}
			else
				size++;
		}
		for(int i=0;i<links.size();i++) {
			s+= links.get(i).toString();
		}
		return s;
	}

	public ArrayList<Person> searchPerson(String search){
		ArrayList<Person> result = new ArrayList<Person>();
		//Traitement si search est un nombre
		try{
			int numeralSearch = Integer.parseInt(search);
			//TODO Recherche en entrant un nombre, en cherchant
			//dans les dates de mort et de naissance
		}
		//Traitement si search n'est pas un nombre
		catch(NumberFormatException e){
			for(int i=0;i<membres.size();i++){
				if(getPersonne(i) != null){
					if(getPersonne(i).getFirstName().contains(search) || getPersonne(i).getName().contains(search))
						result.add(getPersonne(i));		
				}
			}
		}
		if(result.size() == 0)
			System.out.println("Aucun membre trouvé");
		return result;
	}
	
	public void rename(String newname) {
		this.nom = newname;
	}
}
