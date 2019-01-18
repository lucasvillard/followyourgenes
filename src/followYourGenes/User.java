package followYourGenes;

public class User {
	private String name;
	private String firstName;
	private String email;
	private String password;
	
	public User(String n, String f, String e, String p){
		name = n;
		firstName = f;
		email = e;
		password = p;
	}
	
	public String getName(){
		return name;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getEmail(){
		return email;
	}
}
