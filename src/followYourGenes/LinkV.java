package followYourGenes;

public class LinkV extends Link{
	
	
	public LinkV(int ancestor, int son, Tree t){
			super(ancestor,son,t);
	}
	
	public String toString(){return super.toString() + "]";}
}
