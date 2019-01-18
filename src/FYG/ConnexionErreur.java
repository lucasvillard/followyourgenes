package FYG;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.Color;

public class ConnexionErreur {

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
	private JTextPane txtErreur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnexionErreur window = new ConnexionErreur();
					window.getFrmConnexion().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConnexionErreur() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmConnexion(new JFrame());
		getFrmConnexion().setTitle("Connexion");
		getFrmConnexion().setBounds(100, 100, 520, 310);
		getFrmConnexion().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmConnexion().getContentPane().setLayout(null);
		
		textFieldNomUtilisateur = new JTextField();
		textFieldNomUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldNomUtilisateur.setBounds(170, 39, 240, 20);
		getFrmConnexion().getContentPane().add(textFieldNomUtilisateur);
		textFieldNomUtilisateur.setColumns(10);
		
		textFieldMDP = new JTextField();
		textFieldMDP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldMDP.setBounds(170, 82, 240, 20);
		getFrmConnexion().getContentPane().add(textFieldMDP);
		textFieldMDP.setColumns(10);
		
		txtNomUtilisateur = new JTextPane();
		txtNomUtilisateur.setEditable(false);
		txtNomUtilisateur.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		txtNomUtilisateur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomUtilisateur.setText("Nom d'utilisateur");
		txtNomUtilisateur.setBounds(24, 39, 107, 20);
		getFrmConnexion().getContentPane().add(txtNomUtilisateur);
		
		txtMDP = new JTextPane();
		txtMDP.setEditable(false);
		txtMDP.setText("Mot de passe");
		txtMDP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMDP.setBackground(SystemColor.menu);
		txtMDP.setBounds(45, 82, 86, 20);
		getFrmConnexion().getContentPane().add(txtMDP);
		
		checkboxSeSouvenir = new JCheckBox("Se souvenir de moi");
		checkboxSeSouvenir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		checkboxSeSouvenir.setBounds(170, 113, 141, 23);
		getFrmConnexion().getContentPane().add(checkboxSeSouvenir);
		
		btnSeConnecter = new JButton("Se Connecter");
		btnSeConnecter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSeConnecter.setBounds(180, 143, 117, 23);
		getFrmConnexion().getContentPane().add(btnSeConnecter);
		
		txtPasDeCompte = new JTextPane();
		txtPasDeCompte.setEditable(false);
		txtPasDeCompte.setText("Vous n'avez pas encore de compte ?");
		txtPasDeCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPasDeCompte.setBackground(SystemColor.menu);
		txtPasDeCompte.setBounds(132, 177, 240, 20);
		getFrmConnexion().getContentPane().add(txtPasDeCompte);
		
		lblCreerCompte = new JLabel("Cr\u00E9er un compte");
		lblCreerCompte.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCreerCompte.setBounds(191, 208, 117, 14);
		getFrmConnexion().getContentPane().add(lblCreerCompte);
		
		lblNomUtilisateurOublie = new JLabel("Nom d'utilisateur oubli\u00E9");
		lblNomUtilisateurOublie.setBounds(10, 246, 141, 14);
		getFrmConnexion().getContentPane().add(lblNomUtilisateurOublie);
		
		lblMDPOublie = new JLabel("Mot de passe oubli\u00E9");
		lblMDPOublie.setBounds(377, 246, 117, 14);
		getFrmConnexion().getContentPane().add(lblMDPOublie);
		
		txtErreur = new JTextPane();
		txtErreur.setEditable(false);
		txtErreur.setForeground(Color.RED);
		txtErreur.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		txtErreur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtErreur.setText("Le nom d'utilisateur ou le mot de passe est incorrect");
		txtErreur.setBounds(87, 8, 323, 20);
		getFrmConnexion().getContentPane().add(txtErreur);
		
		
	}

	public JFrame getFrmConnexion() {
		return frmConnexion;
	}

	public void setFrmConnexion(JFrame frmConnexion) {
		this.frmConnexion = frmConnexion;
	}

}
