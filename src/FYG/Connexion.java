package FYG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Connexion {

	private JFrame frmConnexion;
	private JTextField textFieldNomUtilisateur;
	private JTextField textFieldMDP;
	private JTextPane txtNomUtilisateur;
	private JTextPane txtMDP;
	private JCheckBox checkboxSeSouvenir;
	private JButton btnSeConnecter;
	private JTextPane txtPasDeCompte;
	private JLabel lblCreerCompte;
	private JLabel lblNomUtilisateurOublie;
	private JLabel lblMDPOublie;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
					window.frmConnexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connexion() {
		initialize();
	}
	
	public JFrame getFrame()
	{
		return frmConnexion;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnexion = new JFrame();
		frmConnexion.setTitle("Connexion");
		frmConnexion.setBounds(100, 100, 520, 310);
		frmConnexion.getContentPane().setLayout(null);
		
		textFieldNomUtilisateur = new JTextField();
		textFieldNomUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNomUtilisateur.setBounds(170, 39, 240, 20);
		frmConnexion.getContentPane().add(textFieldNomUtilisateur);
		textFieldNomUtilisateur.setColumns(10);
		
		textFieldMDP = new JTextField();
		textFieldMDP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMDP.setBounds(170, 82, 240, 20);
		frmConnexion.getContentPane().add(textFieldMDP);
		textFieldMDP.setColumns(10);
		
		txtNomUtilisateur = new JTextPane();
		txtNomUtilisateur.setEditable(false);
		txtNomUtilisateur.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		txtNomUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomUtilisateur.setText("Nom d'utilisateur");
		txtNomUtilisateur.setBounds(24, 39, 107, 20);
		frmConnexion.getContentPane().add(txtNomUtilisateur);
		
		txtMDP = new JTextPane();
		txtMDP.setEditable(false);
		txtMDP.setText("Mot de passe");
		txtMDP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMDP.setBackground(SystemColor.menu);
		txtMDP.setBounds(45, 82, 86, 20);
		frmConnexion.getContentPane().add(txtMDP);
		
		checkboxSeSouvenir = new JCheckBox("Se souvenir de moi");
		checkboxSeSouvenir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkboxSeSouvenir.setBounds(170, 113, 141, 23);
		frmConnexion.getContentPane().add(checkboxSeSouvenir);
		
		btnSeConnecter = new JButton("Se Connecter");
		btnSeConnecter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSeConnecter.setBounds(180, 143, 117, 23);
		frmConnexion.getContentPane().add(btnSeConnecter);
		btnSeConnecter.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Arg0) {
				ConnexionErreur connexionErreur = new ConnexionErreur();
				connexionErreur.getFrmConnexion().setVisible(true);
			}
		});
		txtPasDeCompte = new JTextPane();
		txtPasDeCompte.setEditable(false);
		txtPasDeCompte.setText("Vous n'avez pas encore de compte ?");
		txtPasDeCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPasDeCompte.setBackground(SystemColor.menu);
		txtPasDeCompte.setBounds(132, 177, 240, 20);
		frmConnexion.getContentPane().add(txtPasDeCompte);
		
		lblCreerCompte = new JLabel("Cr\u00E9er un compte");
		lblCreerCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreerCompte.setBounds(191, 208, 117, 14);
		frmConnexion.getContentPane().add(lblCreerCompte);
		
		lblNomUtilisateurOublie = new JLabel("Nom d'utilisateur oubli\u00E9");
		lblNomUtilisateurOublie.setBounds(10, 246, 134, 14);
		frmConnexion.getContentPane().add(lblNomUtilisateurOublie);
		
		lblMDPOublie = new JLabel("Mot de passe oubli\u00E9");
		lblMDPOublie.setBounds(377, 246, 117, 14);
		frmConnexion.getContentPane().add(lblMDPOublie);
	}
}
