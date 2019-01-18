package followYourGenes;

public class Link {
	private int id1;
	private int id2;
	private Tree t;
	private int idLink;
	
	public Link(int id1, int id2, Tree t){
		this.id1 = id1;
		this.id2 = id2;
		this.t= t;
		this.idLink = id1*10+id2;
	}
	
	public String toString(){return "["+id1+","+id2;}
	
	public int getId1(){return this.id1;}
	public int getId2(){return this.id2;}
	public Tree getT(){return this.t;}
	public int getLinkId(){return this.idLink;}
	
	public TypeLinkUnion getTypeLink() {
		return null;
	}
	
}
