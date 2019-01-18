package followYourGenes;

public class LinkH extends Link{
	TypeLinkUnion type;
	
	public LinkH(TypeLinkUnion type, int id1, int id2, Tree t){
		super(id1,id2,t);
		this.type = type;
	}
	
	public TypeLinkUnion getTypeLink() {
		return type;
	}
	
	public String toString(){return super.toString() + "," + type + "]";}
}
