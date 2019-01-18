package followYourGenes;

import java.io.IOException;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) throws IOException {
		Controleur c = new Controleur();
		c.ajouterPersonne("Monnier", "Stanislas", "Lyon", LocalDate.of(1998,9,26), null, null, TypeSex.Homme, null);
		c.ajouterPersonne("Camba", "Marine", "Fréjus", LocalDate.of(1998,5,10), null, null, TypeSex.Homme, null);
		c.ajouterPersonne("Enfant", "no1", "Bingladesh", LocalDate.of(2017,12,25), null, null, TypeSex.Autre, "Numero 1");
		
		c.ajouterPersonne("Martin", "Trois", null, LocalDate.of(1962,01,01), null, LocalDate.of(1963,01,01), TypeSex.Femme, null);
		c.ajouterPersonne("Martin", "Quatre", null, LocalDate.of(1964,01,01), null, LocalDate.of(1965,01,01), TypeSex.Homme, null);
		
		c.ajouterPersonne("Martin", "Cinq", null, LocalDate.of(1962,01,01), null, LocalDate.of(1965,01,01), TypeSex.Femme, null);
		c.ajouterPersonne("Martin", "Six", null, LocalDate.of(1964,01,01), null, LocalDate.of(1966,01,01), TypeSex.Homme, null);
		
		c.ajouterPersonne("Martin", "Sept", null, LocalDate.of(1962,01,01), null, null, TypeSex.Femme, null);
		c.ajouterPersonne("Martin", "Huit", null, LocalDate.of(1964,01,01), null, null, TypeSex.Homme, null);
		
		/* Tests validate
		System.out.println(" ----\n" + LinkTools.validate(c.tree,3,4));
		System.out.println(LinkTools.validate(c.tree,4,3));
		
		System.out.println(" \n----\n" + LinkTools.validate(c.tree,5,6));
		System.out.println(LinkTools.validate(c.tree,6,5));
		
		System.out.println(" \n----\n" + LinkTools.validate(c.tree,7,8));
		System.out.println(LinkTools.validate(c.tree,8,7) + "\n");
		
		System.out.println(" \n----\n" + LinkTools.validate(c.tree,3,8));
		System.out.println(LinkTools.validate(c.tree,8,3) + "\n");
		
		System.out.println(" \n----\n" + LinkTools.validate(c.tree,3,7));
		System.out.println(LinkTools.validate(c.tree,7,3) + "\n");
		*/
		
		
		//System.out.println(c.treeToString());
		//c.supprimerPersonne(6);
		//System.out.println(c.tree.getMembres().toString());
		//System.out.println(c.treeToString());
		
		
		System.out.println("Résultat recherche avec \"Trois\"" + c.tree.searchPerson("Trois").toString());
		System.out.println("Résultat recherche avec \"Martin\"" + c.tree.searchPerson("Martin").toString());
		System.out.println("Résultat recherche avec \"toto\"" + c.tree.searchPerson("toto").toString());
		
		System.out.println("--------------");
		c.creerLienH(7, 8, TypeLinkUnion.concubin);
		System.out.println(LinkTools.existsLinkH(c.tree,7,8));
		c.creerLienH(5, 6, TypeLinkUnion.marriage);
		System.out.println(LinkTools.existsLinkH(c.tree,5,6));
		c.creerLienV(4, 5);
		System.out.println(LinkTools.existsLinkV(c.tree,5,4));
		System.out.println("-------Affichage de l'arbre-------");
		System.out.println(c.treeToString());
		c.supprimerLink(7, 8);
		//c.saveTree();
		
		//c.loadTree();
		System.out.println("-------Affichage après suppression de lien-------");
		System.out.println(c.treeToString());
	}

}
