package FYG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JSeparator;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import java.awt.Panel;
import java.awt.Label;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Galerie {

	private JFrame frmFyg;
	private JButton btnRetourAccueil;
	private TextField textFieldRecherche;
	private JButton btnConnexion;
	private JButton btnEnter;
	private Panel panel_3;
	private Panel panel;
	private Label lblNomProjet1;
	private Label lblCreateur1;
	private Label lblTaille1;
	private Label lblApercu1;
	private Panel panel_4;
	private Label lblNomProjet2;
	private Label lblCreateur2;
	private Label lblTaille2;
	private Label lblApercu2;
	private Label lblNomProjet3;
	private Label lblCreateur3;
	private Label lblTaille3;
	private Label lblApercu3;
	private Label lblNomProjet4;
	private Label lblCreateur4;
	private Label lblTaille4;
	private Label lblApercu4;
	private Panel panel_1;
	private Panel panel_2;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Galerie window = new Galerie();
					window.frmFyg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Galerie() {
		initialize();
	}
	
	public JFrame getframFyg() {
		return this.frmFyg;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFyg = new JFrame();
		frmFyg.setTitle("FYG - Galerie");
		frmFyg.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS\\Documents\\IUT Nice\\S3\\M332 PT\\Follow_Your_Genes\\Resource\\logo_final.png"));
		frmFyg.setBounds(100, 100, 1100, 900);
		frmFyg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFyg.getContentPane().setLayout(null);
		
		textFieldRecherche = new TextField();
		textFieldRecherche.setText("Entrez votre recherche");
		textFieldRecherche.setBounds(217, 68, 661, 22);
		frmFyg.getContentPane().add(textFieldRecherche);
		
		btnConnexion = new JButton("Connexion/Inscription");
		btnConnexion.setForeground(Color.BLACK);
		btnConnexion.setBackground(SystemColor.activeCaption);
		btnConnexion.setBounds(914, 11, 160, 23);
		frmFyg.getContentPane().add(btnConnexion);
		
		btnEnter = new JButton("Enter");
		btnEnter.setBounds(875, 68, 71, 23);
		frmFyg.getContentPane().add(btnEnter);
		
		panel_3 = new Panel();
		panel_3.setBounds(10, 132, 1052, 719);
		frmFyg.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		panel = new Panel();
		panel.setBounds(10, 10, 1032, 160);
		panel_3.add(panel);
		panel.setLayout(null);
		
		lblNomProjet1 = new Label("Nom du projet");
		lblNomProjet1.setBounds(140, 10, 80, 22);
		panel.add(lblNomProjet1);
		
		lblCreateur1 = new Label("Cr\u00E9ateur");
		lblCreateur1.setBounds(140, 26, 62, 22);
		panel.add(lblCreateur1);
		
		lblTaille1 = new Label("Taille");
		lblTaille1.setBounds(140, 51, 62, 22);
		panel.add(lblTaille1);
		
		lblApercu1 = new Label("Aper\u00E7u");
		lblApercu1.setBounds(10, 5, 124, 145);
		lblApercu1.setBackground(Color.LIGHT_GRAY);
		lblApercu1.setAlignment(Label.CENTER);
		panel.add(lblApercu1);
		
		panel_4 = new Panel();
		panel_4.setLayout(null);
		panel_4.setBounds(10, 176, 1032, 160);
		panel_3.add(panel_4);
		
		lblNomProjet2 = new Label("Nom du projet");
		lblNomProjet2.setBounds(140, 10, 80, 22);
		panel_4.add(lblNomProjet2);
		
		lblCreateur2 = new Label("Cr\u00E9ateur");
		lblCreateur2.setBounds(140, 26, 62, 22);
		panel_4.add(lblCreateur2);
		
		lblTaille2 = new Label("Taille");
		lblTaille2.setBounds(140, 51, 62, 22);
		panel_4.add(lblTaille2);
		
		lblApercu2 = new Label("Aper\u00E7u");
		lblApercu2.setBackground(Color.LIGHT_GRAY);
		lblApercu2.setAlignment(Label.CENTER);
		lblApercu2.setBounds(10, 5, 124, 145);
		panel_4.add(lblApercu2);
		
		panel_1 = new Panel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 342, 1032, 160);
		panel_3.add(panel_1);
		
		lblNomProjet3 = new Label("Nom du projet");
		lblNomProjet3.setBounds(140, 10, 80, 22);
		panel_1.add(lblNomProjet3);
		
		lblCreateur3 = new Label("Cr\u00E9ateur");
		lblCreateur3.setBounds(140, 26, 62, 22);
		panel_1.add(lblCreateur3);
		
		lblTaille3 = new Label("Taille");
		lblTaille3.setBounds(140, 51, 62, 22);
		panel_1.add(lblTaille3);
		
		lblApercu3 = new Label("Aper\u00E7u");
		lblApercu3.setBackground(Color.LIGHT_GRAY);
		lblApercu3.setAlignment(Label.CENTER);
		lblApercu3.setBounds(10, 5, 124, 145);
		panel_1.add(lblApercu3);
		
		panel_2 = new Panel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 506, 1032, 160);
		panel_3.add(panel_2);
		
		lblNomProjet4 = new Label("Nom du projet");
		lblNomProjet4.setBounds(140, 10, 80, 22);
		panel_2.add(lblNomProjet4);
		
		lblCreateur4 = new Label("Cr\u00E9ateur");
		lblCreateur4.setBounds(140, 26, 62, 22);
		panel_2.add(lblCreateur4);
		
		lblTaille4 = new Label("Taille");
		lblTaille4.setBounds(140, 51, 62, 22);
		panel_2.add(lblTaille4);
		
		lblApercu4 = new Label("Aper\u00E7u");
		lblApercu4.setBackground(Color.LIGHT_GRAY);
		lblApercu4.setAlignment(Label.CENTER);
		lblApercu4.setBounds(10, 5, 124, 145);
		panel_2.add(lblApercu4);
		
		btnRetourAccueil = new JButton("Retour Accueil");
		btnRetourAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFyg.setVisible(false);
				Accueil accueil = new Accueil();
				frmFyg = accueil.getFrmFyg();
				frmFyg.setVisible(true);
			}
		});
		btnRetourAccueil.setForeground(Color.BLACK);
		btnRetourAccueil.setBackground(SystemColor.activeCaption);
		btnRetourAccueil.setBounds(10, 11, 160, 23);
		frmFyg.getContentPane().add(btnRetourAccueil);
	}
}
