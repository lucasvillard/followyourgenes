package followYourGenes;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Controleur {
	Tree tree;
	
	public Controleur() {tree = new Tree("Famille 1");}
	
	public void ajouterPersonne(String name, String firstName, String birthPlace, LocalDate birthDate, String deathPlace, LocalDate deathDate, TypeSex sex, String comment){
		tree.ajouterPersonne(name, firstName, birthPlace, birthDate, deathPlace, deathDate, sex, comment);
	}
	
	public void saveTree() throws IOException {
		ExportationFyg.saveTree(tree);
	}
	
	public void loadTree() throws IOException {
		ExportationFyg.loadTree(tree);
	}
	
	public String treeToString() {
		return tree.toString();
	}
	
	public void supprimerPersonne(int idPeopleToDelete) {
		tree.supprimerPersonne(idPeopleToDelete);
	}
	
	public void supprimerLink(int id1, int id2){
		tree.supprimerLink(id1, id2);
	}
	
	public void creerLienV(int ancestor, int son){
		tree.creerLienV(ancestor, son);
	}
	
	public void creerLienH(int id1, int id2, TypeLinkUnion t){
		tree.creerLienH(id1, id2, t);
	}
	
	public void renommerArbre(String newname){
		File f = new File("savedTree\\" + tree.getNom() + ".fyg");
		if( f.renameTo(new File(f.getPath() + File.separator + newname)) ){
			System.out.println("Renommage effectué");
			tree.rename(newname);
		}
		else
			System.out.println("Erreur renommage");
	}
	
	public void supprimerArbre(){
		if(new File("savedTree\\" + tree.getNom() + ".fyg").delete()){
			System.out.println("Arbre effacé");
			tree = null;
		}
		else
			System.out.println("Erreur: fichier .fyg introuvable.");
	}
	
}
