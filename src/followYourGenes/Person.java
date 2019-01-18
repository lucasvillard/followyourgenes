package followYourGenes;

import java.time.LocalDate;

public class Person {
	private String name;
	private String firstName;
	private String birthPlace;
	private LocalDate birthDate;
	private String deathPlace;
	private LocalDate deathDate;
	private TypeSex sex;
	private int id;
	private String comment;
	
	public Person(String name, String firstName, String birthPlace, LocalDate birthDate, String deathPlace, LocalDate deathDate, TypeSex sex, int id, String comment){
		this.name = name;
		this.firstName = firstName;
		this.birthPlace = birthPlace;
		this.birthDate = birthDate;
		this.deathPlace = deathPlace;
		this.deathDate = deathDate;
		this.sex = sex;
		this.id = id;
		this.comment = comment;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String c) {
		comment = c;
	}
	public String getName(){
		return name;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getBirthPlace(){
		return birthPlace;
	}
	public LocalDate getBirthDate(){
		return birthDate;
	}
	public String getDeathPlace(){
		return deathPlace;
	}
	public LocalDate getDeathDate(){
		return deathDate;
	}
	public TypeSex getSex(){
		return sex;
	}
	public int getId(){
		return id;
	}
	public void setName(String n){
		name = n;
	}
	public void setFirstName(String f){
		firstName = f;
	}
	public void setBirthPlace(String b){
		birthPlace = b;
	}
	public void setBirthDate(LocalDate b){
		birthDate = b;
	}
	public void setDeathPlace(String d){
		deathPlace = d;
	}
	public void setDeathDate(LocalDate d){
		deathDate = d;
	}
	public void setSex(TypeSex s){
		sex = s;
	}
	
	public boolean isDead(){return !(deathDate == null);}
	
	public String toString() {
		return "Nom["+name+"] Prenom["+firstName+"] id["+id+"]";
	}
}
