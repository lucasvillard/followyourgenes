package followYourGenes;

public class Profile {
	
	String picture;
	String pseudo;
	String password;
	String email;
	
	///////////////////
	// Constructeurs //
	///////////////////

	public Profile (String pseudo, String password, String email) {
		this.pseudo = pseudo;
		this.password = password;
		this.email = email;
	}
	
	public Profile (String pseudo, String password, String email, String url) {
		this.pseudo = pseudo;
		this.password = password;
		this.email = email;
		picture = url;
	}
	
	
	////////////////////
	///// Getters //////
	////////////////////
	
	public String getPseudo() {
		return pseudo;
	}
	public String getPassword() {
		return password;
	}
	
	public String getPicture(){
		return picture;
	}
	
	public String getEmail() {
		return email;
	}
	
	
	////////////////////
	///// Setters /////
	////////////////////
	
	public void setPseudo(String newPseudo) {
		pseudo = newPseudo;
	}
	
	public void setPassword(String newPassword) {
		password = newPassword;
	}
	
	public void setPicture(String newPicture) {
		picture = newPicture;
	}
	
	public void setEmail(String newEmail) {
		email = newEmail;
	}
	
	
	
	
	
	
	
}
