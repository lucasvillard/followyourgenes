package followYourGenes;

import java.time.LocalDate;

public abstract class LinkTools {

	
	public static boolean validateHLink(Tree t, int id1, int id2){
		//return true si les deux personnes ont partagé une période de leur vie
		//i.e. si la date de mort du premier est après la date de naissance du deuxième et inversement
		LocalDate bd1 = t.getPersonne(id1).getBirthDate();
		LocalDate bd2 = t.getPersonne(id2).getBirthDate();
		//Si les deux personnes sont mortes
		if( t.getPersonne(id1).isDead() && t.getPersonne(id2).isDead() ){
			LocalDate dd1 = t.getPersonne(id1).getDeathDate();
			LocalDate dd2 = t.getPersonne(id2).getDeathDate();
			return !( (isAnterior(bd1,bd2) && isAnterior(dd1,bd2)) || (isAnterior(bd2,bd1) && isAnterior(dd2,bd1)) );
		}
		//Si l'une des deux personnes est morte
		if( t.getPersonne(id1).isDead() || t.getPersonne(id2).isDead() ){
			if( t.getPersonne(id1).isDead() ){
				LocalDate dd1 = t.getPersonne(id1).getDeathDate();
				return !( isAnterior(dd1,bd2) );
			}
			if( t.getPersonne(id2).isDead() ){
				LocalDate dd2 = t.getPersonne(id2).getDeathDate();
				return !( isAnterior(dd2,bd1) );
			}
		}
		//Si les deux personnes sont vivantes, le lien est forcément valide
		return true;
	}
	
	public static boolean isAnterior(LocalDate d1, LocalDate d2){
		return ( d1.compareTo(d2) < 0 );
	}
	
	public static boolean isOrderedLinkV(Tree t, int ancestor, int son){
		LocalDate bd1 = t.getPersonne(ancestor).getBirthDate();
		LocalDate bd2 = t.getPersonne(son).getBirthDate();
		return (isAnterior(bd1,bd2));
	}
	
	public static boolean existsLinkH(Tree t, int id1, int id2){
		for(Link l : t.getLinks()){
			if( l instanceof LinkH && ( (l.getId1() == id1 && l.getId2() == id2) || (l.getId1() == id2 && l.getId2() == id1) ) )
				return true;
		}
		return false;
	}
	
	public static boolean existsLinkV(Tree t, int id1, int id2){
		for(Link l : t.getLinks()){
			if( l instanceof LinkV && ( (l.getId1() == id1 && l.getId2() == id2) || (l.getId1() == id2 && l.getId2() == id1) ) )
				return true;
		}
		return false;
	}
}
