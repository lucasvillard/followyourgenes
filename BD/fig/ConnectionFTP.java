package fig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.TimeZone;
import java.io.FileOutputStream;
import java.io.FileWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;  
import org.apache.commons.net.ftp.FTPFile;

 
public class ConnectionFTP {
 
	String server; // Hote FTP
	int port; // Port de connection (21 par défaut)

	String user; // Nom utilisateur pour la connection
	String pass; // Mot de passe

	FTPClient ftpClient; // Création d'un client FTP vierge
	InputStream inputStream; // Sert pour le download/upload
	File firstLocalFile;	// Sert pour la comparaisaon local/distant
	FTPFile[] files;	// Sert pour l'affichage
	
	private static void reponseServeur(FTPClient ftpClient) {
	     String[] reponses = ftpClient.getReplyStrings();
	     if (reponses != null && reponses.length > 0) {
	         for (String reponse : reponses) {
	             System.out.println("---- SERVEUR: " + reponse + "----");
	         }
	     }
	 }
	    
	public void connectFTP() {
			 	server = "10.0.29.52"; // Hote FTP
				port = 21; // Port de connection (21 par défaut)
		
				user = "testapache"; // Nom utilisateur pour la connection
				pass = "web"; // Mot de passe
		
				ftpClient = new FTPClient(); // Création d'un client FTP vierge
				inputStream = null;
				firstLocalFile = null;
				
				try {
					ftpClient.connect(server, port); // Association avec le serveur
					// Print le status de connection
					//System.out.println("---- Connexion en cours ... ----");
					//reponseServeur(ftpClient);
					if (ftpClient.login(user, pass)) { // Connexion au serveur avec user + pass
						//System.out.println("---- Connexion établie ! ----");
						//reponseServeur(ftpClient);
					} else {
						System.err.println("---- Connexion impossible ! ----\n---- Utilisateur ou mot de passe incorrect ou erreur serveur. ----");
						System.exit(1);
					}
					// Paramètre la connexion en client-serveur (par défaut serveur-client)
					ftpClient.enterLocalPassiveMode();
					
					// Paramètre le type de fichiers qui vont être utilisé (ASCII aussi possible)
					ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				}
			 catch (IOException ex) {
					System.err.println("Error: " + ex.getMessage());
					// ex.printStackTrace();
				}
	 }
	
	public void refreshFYG() {
		connectFTP();
		try {
			File filename = new File("save.fyg");
			filename.createNewFile();
			FileWriter ffw =new FileWriter(filename);
			ffw.write("Distant");
			inputStream = new FileInputStream(filename);
			ftpClient.storeFile("./save.fyg", inputStream); // Rends True si bien uploadé sinon
			
			// Fermeture du fichier de type InputStream
			inputStream.close();
			ffw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnectFTP() {
		try {
			System.out.println("\n---- Déconnection ... ----");
			// Déconnecte à la fin de la session
			if (ftpClient.isConnected()) {
				ftpClient.logout();
				ftpClient.disconnect();
			}
		} catch (IOException ex) {
			// ex.printStackTrace();
		}
	 }
	
	public void compareFTP() {
		try {
			if (JOptionPane.showConfirmDialog(new JFrame(), "Voulez vous mettre à jour votre fichier FYG ?") == 0) {
				JFileChooser chooser = new JFileChooser(new File("./savedTree"));
				int returnVal = chooser.showOpenDialog(new JFrame());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					if (chooser.getSelectedFile().getName()
							.substring(chooser.getSelectedFile().getName().length() - 4).equals(".fyg")) {
						File local = new File(chooser.getSelectedFile().getPath());
						Date d = new Date(local.lastModified());
						Date d2;
						System.out.println("\nen local : " + d);
		
						for (FTPFile file : files)
							if (file.getName().contains(".fyg")) {
								d2 = file.getTimestamp().getTime();
								d2.setHours(d2.getHours() + 1);
								System.out.println("sur le ftp : " + d2);
		
								if (d2.before(d)) {
									JOptionPane.showMessageDialog(new JFrame(), "Fichier local plus récent.");
									//System.out.println("Fichier local plus récent");
								}
								else {
									//System.out.println("** Fichier distant plus récent **");
									if (JOptionPane.showConfirmDialog(new JFrame(),
											"Le fichier distant est plus récent. Voulez vous mettre à jour le fichier ?") == 0) {
		
										FileOutputStream fos = new FileOutputStream(local.getPath());
		
										if (ftpClient.retrieveFile(file.getName(), fos)) // Recherche le fichier à  télécharger
											System.out.println("\n---- Le fichier a bien été mis a jour. ----");
										else
											System.err.println("\n---- Le fichier n'a pas pu être mis a jour. ----");
									}
		
								}
							} 
					} 
					else
						System.err.println("---- Le fichier n'a pas correct. ----");
				}
				else
					System.err.println("---- Aucun fichier choisi. ----");
			}
		}
		 catch (IOException ex) {
				System.err.println("Error: " + ex.getMessage());
				// ex.printStackTrace();
		}
	}
	
	public void uploadFTP() {
		connectFTP();
		try {
			if (JOptionPane.showConfirmDialog(new JFrame(), "Voulez vous uploader un fichier ?") == 0) {
				// Picker du fichier à télécharger
				JFileChooser chooser = new JFileChooser(new File("./savedTree"));
				int returnVal = chooser.showOpenDialog(new JFrame());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName()
							+ " " + chooser.getSelectedFile().getPath());
	
					// Fichier à upload
					firstLocalFile = new File(chooser.getSelectedFile().getPath());
	
					String rep = JOptionPane.showInputDialog(new JFrame(),
							"Chemin et nom du fichier à upload (rien pour nom local)", "Upload", 1);
					if (rep.isEmpty())
						rep = chooser.getSelectedFile().getName();
	
					// Emplacement + nom fichier sur le serveur
					String firstRemoteFile = rep;
					// Création du fichier de type Input Stream depuis le fichier 'normal' servant
					// pour l'upload
					inputStream = new FileInputStream(firstLocalFile);
	
					System.out.println("---- Début upload de [" + firstRemoteFile.toString() + "] ... ----");
	
					// Démarre l'upload
					if (ftpClient.storeFile(firstRemoteFile, inputStream)) // Rends True si bien uploadé sinon
						System.out.println("---- Envoi réussi ! ----");
					else System.err.println("---- Échec de l'envoi ! ----");
	
					// Fermeture du fichier de type InputStream
					inputStream.close();
				}
			}
		}
		 catch (IOException ex) {
				System.err.println("Error: " + ex.getMessage());
				// ex.printStackTrace();
		}
		
	}
	
	public void downloadFTP() {
		try {
			if (JOptionPane.showConfirmDialog(new JFrame(), "Voulez vous télécharger un fichier ?") == 0) {
				// Demande quel fichier télécharger
				String rep = JOptionPane.showInputDialog(new JFrame(),
						"Entrer chemin du fichier à télécharger (avec '/' si arborécence)", "Download", 1);
				if (rep != null) {// Si quelquechose a été renseigné dans le champ de la boite de dialogue
					
					// Récupère le nom du fichier
					String nom = rep;
					while (nom.contains("/")) {
						nom = nom.substring(nom.indexOf("/") + 1);
					}
					
					String nom2 = rep;
					if(nom2.contains("/")) {
						String nom3 = nom2.substring(nom2.indexOf("/") + 1);
						if(nom3.contains("/"))
							files = ftpClient.listFiles(rep.replaceFirst(nom, ""));
					}
					
					boolean exist = false;
					for (FTPFile file : files)
						if(file.getName().equals(nom))
							exist = true;
							
					if (exist) { // Si le fichier existe
	
						// Sélectionne le répertoire ou télécharger le fichier
						JFileChooser chooser = new JFileChooser(new File("./savedTree"));
						chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						chooser.setAcceptAllFileFilterUsed(false);
						int returnVal = chooser.showOpenDialog(new JFrame());
						if (returnVal == JFileChooser.APPROVE_OPTION) {
							System.out.println("---- Téléchargement en cours ... ----");
							FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile().getPath()+"\\"+nom);
							
							
							if (ftpClient.retrieveFile(rep, fos)) // Recherche le fichier à télécharger
								System.out.println("---- Le fichier a bien été téléchargé. ----");
							else
								System.err.println("---- Le fichier n'a pas pu être téléchargé. ----");
							fos.close();
						} else
							System.err.println("---- Aucun fichier choisi. ----");
	
					} else
						System.err.println("---- Le fichier n'existe pas. ----");
				}else System.out.println("---- Rien à télécharger. ----");
			}
		}
		 catch (IOException ex) {
				System.err.println("Error: " + ex.getMessage());
				// ex.printStackTrace();
		}
		
	}
	
	public String afficheFichiers() {
	
	connectFTP();
	
	// Créer une liste qui va contenir le contenu du répertoire local
	try {
		files = ftpClient.listFiles();
	} catch (IOException e) {
		e.printStackTrace();
	}
	String res = "";
	
	// Affiche les fichiers
	for (FTPFile file : files)
		if (file.getType() != FTPFile.FILE_TYPE) {
			String temp = "/" + file.getName() + "\t\tDate: "
					+ file.getTimestamp().getTime().toString().substring(4, 16);
			res = temp;
		}
	for (FTPFile file : files) {
		if (file.getType() == FTPFile.FILE_TYPE) {
			if (FileUtils.byteCountToDisplaySize(file.getSize()).contains("MB")
					|| FileUtils.byteCountToDisplaySize(file.getSize()).contains("KB")) {// Mise en page
				String temp = file.getName() + "  Taille: "
						+ FileUtils.byteCountToDisplaySize(file.getSize()) + "  Date: "
						+ file.getTimestamp().getTime().toString().substring(4, 16);
				res += "\n" + temp; 
			} else {
				String temp = file.getName() + "  Taille: "
						+ FileUtils.byteCountToDisplaySize(file.getSize()) + "  Date: "
						+ file.getTimestamp().getTime().toString().substring(4, 16);
				res += "\n" + temp; 
			}
		}
	}
	res += "\n" ;
	
	return res;
}
 

// public static void main(String[] args) {
//
//		String server = "10.0.29.52"; // Hote FTP
//		int port = 21; // Port de connection (21 par défaut)
//
//		String user = "testapache"; // Nom utilisateur pour la connection
//		String pass = "web"; // Mot de passe
//
//		FTPClient ftpClient = new FTPClient(); // Création d'un client FTP vierge
//		InputStream inputStream = null;
//		File firstLocalFile = null;
//		FTPFile[] files;
//
//		try {
//			ftpClient.connect(server, port); // Association avec le serveur
//			// Print le status de connection
//			System.out.println("\t---- Connexion en cours ...\t----");
//			reponseServeur(ftpClient);
//			if (ftpClient.login(user, pass)) { // Connexion au serveur avec user + pass
//				System.out.println("\t---- Connexion établie !\t----");
//				reponseServeur(ftpClient);
//			} else {
//				System.err.println(
//						"\t---- Connexion impossible !\t----\n\t---- Utilisateur ou mot de passe incorrect ou erreur serveur.\t----");
//				System.exit(1);
//			}
//			// Paramètre la connexion en client-serveur (par défaut serveur-client)
//			ftpClient.enterLocalPassiveMode();
//			// Paramètre le type de fichiers qui vont être utilisé (ASCII aussi possible)
//			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
//
//			// Créer une liste qui va contenir le contenu du répertoire local
//			files = ftpClient.listFiles();
//
//			// Affiche les fichiers
//			//txtPane.setText(""); TODO
//			for (FTPFile file : files)
//				if (file.getType() != FTPFile.FILE_TYPE) {
//					String temp = "/" + file.getName() + "\t\tDate: "
//							+ file.getTimestamp().getTime().toString().substring(4, 16);
//					//txtPane.setText(txtPane.getText() + "\n" + temp); TODO
//				}
//			for (FTPFile file : files) {
//				if (file.getType() == FTPFile.FILE_TYPE) {
//					if (FileUtils.byteCountToDisplaySize(file.getSize()).contains("MB")
//							|| FileUtils.byteCountToDisplaySize(file.getSize()).contains("KB")) {// Mise en page
//						String temp = file.getName() + "  Taille: "
//								+ FileUtils.byteCountToDisplaySize(file.getSize()) + "  Date: "
//								+ file.getTimestamp().getTime().toString().substring(4, 16);
//						//txtPane.setText(txtPane.getText() + "\n" + temp); TODO
//					} else {
//						String temp = file.getName() + "  Taille: "
//								+ FileUtils.byteCountToDisplaySize(file.getSize()) + "  Date: "
//								+ file.getTimestamp().getTime().toString().substring(4, 16);
//						// txtPane.setText(txtPane.getText() + "\n" + temp); TODO
//					}
//				}
//			}
//			System.out.println("\n");
//
//			/***
//			 * ################################################## UPLOAD
//			 * ###########################################################################
//			 ***/
//
//			if (JOptionPane.showConfirmDialog(new JFrame(), "Voulez vous uploader un fichier ?") == 0) {
//				// Picker du fichier à télécharger
//				JFileChooser chooser = new JFileChooser();
//				int returnVal = chooser.showOpenDialog(new JFrame());
//				if (returnVal == JFileChooser.APPROVE_OPTION) {
//					System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName()
//							+ " " + chooser.getSelectedFile().getPath());
//
//					// Fichier à upload
//					firstLocalFile = new File(chooser.getSelectedFile().getPath());
//
//					String rep = JOptionPane.showInputDialog(new JFrame(),
//							"Chemin et nom du fichier à upload (rien pour nom local)", "Upload", 1);
//					if (rep.isEmpty())
//						rep = chooser.getSelectedFile().getName();
//
//					// Emplacement + nom fichier sur le serveur
//					String firstRemoteFile = rep;
//					// Création du fichier de type Input Stream depuis le fichier 'normal' servant
//					// pour l'upload
//					inputStream = new FileInputStream(firstLocalFile);
//
//					System.out.println("\t---- Début upload de [" + firstRemoteFile.toString() + "] ...\t----");
//
//					// Démarre l'upload
//					if (ftpClient.storeFile(firstRemoteFile, inputStream)) { // Rends True si bien uploadé sinon
//																				// false
//						System.out.println("\t---- Envoi réussi !\t----");
//						
//						// Rerécupère les fichiers
//						files = ftpClient.listFiles();
//						// Affiche les fichiers
//						//txtPane.setText(""); TODO
//						for (FTPFile file : files)
//							if (file.getType() != FTPFile.FILE_TYPE) {
//								String temp = "/" + file.getName() + "\t\tDate: "
//										+ file.getTimestamp().getTime().toString().substring(4, 16);
//								// txtPane.setText(txtPane.getText() + "\n" + temp); TODO
//							}
//						for (FTPFile file : files) {
//							if (file.getType() == FTPFile.FILE_TYPE) {
//								if (FileUtils.byteCountToDisplaySize(file.getSize()).contains("MB")
//										|| FileUtils.byteCountToDisplaySize(file.getSize()).contains("KB")) {// Mise en page
//									String temp = file.getName() + "  Taille: "
//											+ FileUtils.byteCountToDisplaySize(file.getSize()) + "  Date: "
//											+ file.getTimestamp().getTime().toString().substring(4, 16);
//									//txtPane.setText(txtPane.getText() + "\n" + temp); TODO
//								} else {
//									String temp = file.getName() + "  Taille: "
//											+ FileUtils.byteCountToDisplaySize(file.getSize()) + "  Date: "
//											+ file.getTimestamp().getTime().toString().substring(4, 16);
//									//txtPane.setText(txtPane.getText() + "\n" + temp); TODO
//								}
//							}
//						}
//						System.out.println("\n");
//					} else
//						System.err.println("\t---- Échec de l'envoi !\t----");
//
//					// Fermeture du fichier de type InputStream
//					inputStream.close();
//				}
//			}
//
//			/***
//			 * ################################################## DOWNLOAD
//			 * ###########################################################################
//			 ***/
//
//			if (JOptionPane.showConfirmDialog(new JFrame(), "Voulez vous télécharger un fichier ?") == 0) {
//				// Demande quel fichier télécharger
//				String rep = JOptionPane.showInputDialog(new JFrame(),
//						"Entrer chemin du fichier à télécharger (avec '/' si arborécence)", "Download", 1);
//				if (rep != null) {// Si quelquechose a été renseigné dans le champ de la boite de dialogue
//					
//					// Récupère le nom du fichier
//					String nom = rep;
//					while (nom.contains("/")) {
//						nom = nom.substring(nom.indexOf("/") + 1);
//					}
//					
//					String nom2 = rep;
//					if(nom2.contains("/")) {
//						String nom3 = nom2.substring(nom2.indexOf("/") + 1);
//						if(nom3.contains("/"))
//							files = ftpClient.listFiles(rep.replaceFirst(nom, ""));
//					}
//					
//					boolean exist = false;
//					for (FTPFile file : files)
//						if(file.getName().equals(nom))
//							exist = true;
//							
//					if (exist) { // Si le fichier existe
//
//						// Sélectionne le répertoire ou télécharger le fichier
//						JFileChooser chooser = new JFileChooser();
//						chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
//						chooser.setAcceptAllFileFilterUsed(false);
//						int returnVal = chooser.showOpenDialog(new JFrame());
//						if (returnVal == JFileChooser.APPROVE_OPTION) {
//							System.out.println("\t---- Téléchargement en cours ... ----");
//							FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile().getPath()+"\\"+nom);
//							
//							
//							if (ftpClient.retrieveFile(rep, fos)) // Recherche le fichier à télécharger
//								System.out.println("\t---- Le fichier a bien été téléchargé.\t----");
//							else
//								System.err.println("\t---- Le fichier n'a pas pu être téléchargé.\t----");
//							fos.close();
//						} else
//							System.err.println("\t---- Aucun fichier choisi.\t----");
//
//					} else
//						System.err.println("\t---- Le fichier n'existe pas.\t----");
//				}else System.out.println("\t---- Rien à télécharger.\t----");
//			}
//
//			/** ################### Comparaison date de modif ####################################### **/
//
//			if (JOptionPane.showConfirmDialog(new JFrame(), "Voulez vous mettre à jour votre fichier FYG ?") == 0) {
//				JFileChooser chooser = new JFileChooser();
//				int returnVal = chooser.showOpenDialog(new JFrame());
//				if (returnVal == JFileChooser.APPROVE_OPTION) {
//					if (chooser.getSelectedFile().getName()
//							.substring(chooser.getSelectedFile().getName().length() - 4).equals(".fyg")) {
//						File local = new File(chooser.getSelectedFile().getPath());
//						Date d = new Date(local.lastModified());
//						Date d2;
//						System.out.println("\nen local : " + d);
//
//						for (FTPFile file : files)
//							if (file.getName().contains(".fyg")) {
//								d2 = file.getTimestamp().getTime();
//								d2.setHours(d2.getHours() + 1);
//								System.out.println("sur le ftp : " + d2);
//
//								if (d2.before(d)) {
//									JOptionPane.showMessageDialog(new JFrame(), "Fichier local plus récent.");
//									System.out.println("Fichier local plus récent");
//								}
//								else {
//									System.out.println("** Fichier distant plus récent **");
//									if (JOptionPane.showConfirmDialog(new JFrame(),
//											"Le fichier distant est plus récent. Voulez vous mettre à jour le fichier ?") == 0) {
//
//										FileOutputStream fos = new FileOutputStream(local.getPath());
//
//										if (ftpClient.retrieveFile(file.getName(), fos)) // Recherche le fichier à  télécharger
//											System.out.println("\t---- Le fichier a bien été mis a jour.\t----");
//										else
//											System.err.println(
//													"\t---- Le fichier n'a pas pu être mis a jour.\t----");
//									}
//
//								}
//							} 
//					} 
//					else
//						System.err.println("\t---- Le fichier n'a pas correct.\t----");
//				}
//				else
//					System.err.println("\t---- Aucun fichier choisi.\t----");
//			}
//			//setVisible(true); TODO
//
//		} catch (IOException ex) {
//			System.err.println("Error: " + ex.getMessage());
//			// ex.printStackTrace();
//		} finally {
//			try {
//				System.out.println("\n\t---- Déconnection ...\t----");
//				// Déconnecte à la fin de la session
//				if (ftpClient.isConnected()) {
//					ftpClient.logout();
//					ftpClient.disconnect();
//				}
//			} catch (IOException ex) {
//				// ex.printStackTrace();
//			}
//		}
//
//	}
}
