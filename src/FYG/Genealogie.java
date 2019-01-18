package FYG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSlider;
import javax.swing.JList;
import javax.swing.JEditorPane;
import java.awt.Choice;

public class Genealogie {

	private JFrame frmFyg;
	private JPanel panel;
	private JTextField txtRecherche;
	private JButton btnRepertoire;
	private JButton btnConnexion;
	private JPanel panel_fichier;
	private JButton btnNew;
	private JButton btnImporter;
	private JButton btnNewGedcom;
	private JButton btnFavori;
	private JButton btnExporter;
	private JButton btnImporterGedcom;
	private JButton btnSupp;
	private JButton btnSauvegarder;
	private JButton btnParametres;
	private JLabel lblFichier;
	private JPanel panel_personnalisation;
	private JButton btnE;
	private JComboBox comBoxTheme;
	private JLabel lblTheme;
	private JLabel lblTailleEtForme ;
	private JComboBox comboBoxTailleForme;
	private JPanel panel_modifMembre ;
	private JButton btnBouger;
	private JButton btnMariage;
	private JButton btnAjouterLien;
	private JButton btnAjouterMembre;
	private JButton btnSuppMembre;
	private JButton btnInfo;
	private JLabel lblModifMembre;
	private JPanel panel_com;
	private JButton btnForum;
	private JButton btnPartager;
	private JButton btnAide;
	private JButton btnProfil;
	private JLabel lblCommunication;
	private JPanel panel_arbre;
	private JSlider slider;
	private JLabel label100;
	private JPanel panel_formatTxt;
	private JButton btnItalique;
	private JButton btnGras;
	private JButton btnSouligner;
	private JComboBox comboBoxFont;
	private JComboBox comboBoxSize;
	private JButton btnPlusSize;
	private JButton btnMoinsSize;
	private JLabel lblFormat;
	private JButton btnRetourAccueil;
	private ArrayList<Membre> listeMembre;
	private int nbSelectionne;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Genealogie window = new Genealogie();
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
	public Genealogie() {
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
		frmFyg.setBounds(-10,0,1455, 750);
		frmFyg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFyg.getContentPane().setLayout(new BoxLayout(frmFyg.getContentPane(), BoxLayout.X_AXIS));
		
		panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		frmFyg.getContentPane().add(panel);
		panel.setLayout(null);
		
		/*
		 * ======================= Création de tous les panels =====================
		 */
		panel_fichier = new JPanel();
		panel_fichier.setBackground(Color.white);
		panel_fichier.setBounds(10, 36, 519, 89);
		panel.add(panel_fichier);
		panel_fichier.setLayout(null);
		
		panel_personnalisation = new JPanel();
		panel_personnalisation.setBackground(Color.white);
		panel_personnalisation.setBounds(10, 136, 228, frmFyg.getHeight() - 100 );
		panel.add(panel_personnalisation);
		panel_personnalisation.setLayout(null);
		
		panel_modifMembre = new JPanel();
		panel_modifMembre.setBackground(Color.white);
		panel_modifMembre.setBounds(777, 36, 346, 89);
		panel.add(panel_modifMembre);
		panel_modifMembre.setLayout(null);
		
		panel_com = new JPanel();
		panel_com.setBackground(Color.white);
		panel_com.setBounds(1133, 36, 217, 89);
		panel.add(panel_com);
		panel_com.setLayout(null);
		
		panel_formatTxt = new JPanel();
		panel_formatTxt.setBackground(Color.white);
		panel_formatTxt.setBounds(539, 36, 228, 89);
		panel.add(panel_formatTxt);
		panel_formatTxt.setLayout(null);
		
		panel_arbre = new JPanel();
		panel_arbre.setBackground(Color.white);
		panel_arbre.setBounds(248, 136, 1100, frmFyg.getHeight() - 100 );
		panel.add(panel_arbre);
		panel_arbre.setLayout(null);
		
		
		
		/*
		 * =================================Ajout des boutons =============================
		 */
		Color color = new Color(48, 153, 90);
		Connexion connexion = new Connexion();
		listeMembre = new ArrayList<Membre>();
		
		btnConnexion = new JButton("Connexion/Inscription");
		btnConnexion.setForeground(Color.black);
		btnConnexion.setBackground(color);
		btnConnexion.setBounds(1180, 7, 160, 23);
		panel.add(btnConnexion);
		btnConnexion.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent Arg0) {
				connexion.getFrame().setVisible(true);
			}
		});
		
		btnRetourAccueil = new JButton("Retour Accueil");
		btnRetourAccueil.setForeground(Color.BLACK);
		btnRetourAccueil.setBackground(color);
		btnRetourAccueil.setBounds(10, 7, 160, 23);
		panel.add(btnRetourAccueil);
		btnRetourAccueil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFyg.setVisible(false);
				Accueil accueil = new Accueil();
				frmFyg = accueil.getFrmFyg();
				frmFyg.setVisible(true);
			}
		});
		
		
		btnNew = new JButton(new ImageIcon("ressources/ressource_interface/newGenealogie.png"));
		btnNew.setBounds(10, 23, 46, 52);
		btnNew.setBackground(null);
		btnNew.setBorder(null);
		panel_fichier.add(btnNew);
		btnNew.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				Genealogie g2 = new Genealogie();
				g2.getframFyg().setVisible(true);
			}
		});
		
		btnImporter = new JButton(new ImageIcon("ressources/ressource_interface/importer.png"));
		btnImporter.setBounds(66, 23, 46, 52);
		btnImporter.setBackground(null);
		btnImporter.setBorder(null);
		panel_fichier.add(btnImporter);
		
		btnNewGedcom = new JButton(new ImageIcon("ressources/ressource_interface/newGedcom.png"));
		btnNewGedcom.setBounds(127, 23, 46, 52);
		btnNewGedcom.setBackground(null);
		btnNewGedcom.setBorder(null);
		//btnNewGedcom.setIcon(new ImageIcon(Accueil.class.getResource("/ressource_interface/newGedcom.png")));
		panel_fichier.add(btnNewGedcom);
		
		btnFavori = new JButton(new ImageIcon("ressources/ressource_interface/favori.png"));
		btnFavori.setBounds(183, 23, 46, 52);
		btnFavori.setBackground(null);
		btnFavori.setBorder(null);
		panel_fichier.add(btnFavori);
		
		btnExporter = new JButton(new ImageIcon("ressources/ressource_interface/exporter.png"));
		btnExporter.setBounds(239, 23, 46, 52);
		btnExporter.setBackground(null);
		btnExporter.setBorder(null);
		panel_fichier.add(btnExporter);
		
		btnImporterGedcom = new JButton(new ImageIcon("ressources/ressource_interface/importerGedcom.png"));
		btnImporterGedcom.setBounds(295, 23, 46, 52);
		btnImporterGedcom.setBackground(null);
		btnImporterGedcom.setBorder(null);
		panel_fichier.add(btnImporterGedcom);
		
		btnSupp = new JButton(new ImageIcon("ressources/ressource_interface/supprimer.png"));
		btnSupp.setBounds(351, 23, 46, 52);
		btnSupp.setBackground(null);
		btnSupp.setBorder(null);
		panel_fichier.add(btnSupp);
		
		btnSauvegarder = new JButton(new ImageIcon("ressources/ressource_interface/enregistrer.png"));
		btnSauvegarder.setBounds(407, 23, 46, 52);
		btnSauvegarder.setBackground(null);
		btnSauvegarder.setBorder(null);
		panel_fichier.add(btnSauvegarder);
		btnSauvegarder.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				JOptionPane sauvegarde = new JOptionPane();
				sauvegarde.showMessageDialog(null, "La sauvegarde a bien effectué",null,JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnParametres = new JButton(new ImageIcon("ressources/ressource_interface/parametres.png"));
		btnParametres.setBounds(463, 23, 46, 52);
		btnParametres.setBackground(null);
		btnParametres.setBorder(null);
		panel_fichier.add(btnParametres);
		
		lblFichier = new JLabel("F I C H I E R");
		lblFichier.setBounds(220, 4, 146, 14);
		panel_fichier.add(lblFichier);
		
		
		
		txtRecherche = new JTextField();
		txtRecherche.setBounds(10, 6, 150, 20);
		txtRecherche.setText("Recherche");
		panel_personnalisation.add(txtRecherche);
		txtRecherche.setColumns(10);
		
		btnE = new JButton("E");
		btnE.setBounds(169, 5, 49, 23);
		//btnE.setBackground(null);
		//btnE.setBorder(null);
		panel_personnalisation.add(btnE);
		
		comBoxTheme = new JComboBox();
		comBoxTheme.setName("");
		comBoxTheme.setToolTipText("");
		comBoxTheme.setBounds(0, 91, 228, 20);
		panel_personnalisation.add(comBoxTheme);
		
		lblTheme = new JLabel("Th\u00E8me de l'arbre");
		lblTheme.setBounds(10, 75, 136, 14);
		panel_personnalisation.add(lblTheme);
		
		lblTailleEtForme = new JLabel("Taille et forme des cases");
		lblTailleEtForme.setBounds(10, 141, 179, 14);
		panel_personnalisation.add(lblTailleEtForme);
		
		comboBoxTailleForme = new JComboBox();
		comboBoxTailleForme.setToolTipText("");
		comboBoxTailleForme.setName("");
		comboBoxTailleForme.setBounds(0, 157, 228, 20);
		panel_personnalisation.add(comboBoxTailleForme);
		
	
		
		btnBouger = new JButton(new ImageIcon("ressources/ressource_interface/deplacerMembre.png"));
		btnBouger.setBounds(10, 21, 46, 52);
		btnBouger.setBackground(null);
		btnBouger.setBorder(null);
		panel_modifMembre.add(btnBouger);
		
		btnMariage = new JButton(new ImageIcon("ressources/ressource_interface/mariage.png"));
		btnMariage.setBounds(66, 21, 46, 52);
		btnMariage.setBackground(null);
		btnMariage.setBorder(null);
		panel_modifMembre.add(btnMariage);
		
		btnMariage.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent arg0)
			{
				ArrayList<Membre> lien = new ArrayList<Membre>();
				System.out.println("click sur mariage");
				for(int i =0; i<listeMembre.size(); i++)
				{
					if(listeMembre.get(i).getEstSelectionne() == true && getNbSelectionne() ==2)
					{
						System.out.println("membre selectionné est " + i);
						System.out.println(nbSelectionne);
						Mariage mariage = new Mariage();
						mariage.setVisible(true);
						listeMembre.get(i).setEstLie(true);
						System.out.println(listeMembre.get(i).isEstLie());
						lien.add(listeMembre.get(i));
						
					}
				}
				
				panel_arbre.repaint();
				Lien lienCree = new Lien(lien,"horizontal");
				panel_arbre.add(lienCree);
				
				
				
			}
		});
		
		
		btnAjouterLien = new JButton(new ImageIcon("ressources/ressource_interface/lien.png"));
		btnAjouterLien.setBounds(178, 21, 46, 52);
		btnAjouterLien.setBackground(null);
		btnAjouterLien.setBorder(null);
		panel_modifMembre.add(btnAjouterLien);
		
		btnAjouterLien.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent arg0)
			{
				ArrayList<Membre> lien = new ArrayList<Membre>();
				
				System.out.println("click sur lien");
				for(int i=0; i<listeMembre.size(); i++)
				{
					if(listeMembre.get(i).getEstSelectionne() == true && getNbSelectionne() == 3)
					{
						System.out.println("membre selectionné est " + i);
						System.out.println(nbSelectionne);
						lien.add(listeMembre.get(i));
					}
				}
				panel_arbre.repaint();
				Lien lienCree = new Lien(lien, "vertical");
				panel_arbre.add(lienCree);
			}

			
		});
		
		btnAjouterMembre = new JButton(new ImageIcon("ressources/ressource_interface/ajouterMembre.png"));
		btnAjouterMembre.setBounds(290, 21, 46, 52);
		btnAjouterMembre.setBackground(null);
		btnAjouterMembre.setBorder(null);
		panel_modifMembre.add(btnAjouterMembre);
		
		btnAjouterMembre.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent arg0) {
				System.out.println("click sur ajouter");
				Membre m = new Membre();
				if(listeMembre.isEmpty()) {
					panel_arbre.repaint();
					m.setBounds(500,panel_arbre.HEIGHT, 160, 160);
					m.setBackground(Color.lightGray);
					addMembre(m);
					System.out.println("Premier membre crée");
				}
				else
				{
					if(listeMembre.size()> 0 ) {
						panel_arbre.repaint();
						m.setBounds(listeMembre.get(listeMembre.size()-1).getX() + 100, listeMembre.get(listeMembre.size()-1).getY() +20, 160, 160);
						m.setBackground(Color.lightGray);
						addMembre(m);
						System.out.println("Membre crée ajouté, Total nb membre : " +listeMembre.size());

					}
				}

				panel_arbre.add(m);

				
				m.getLblCrayon().addMouseListener(new MouseAdapter() {
					public void mousePressed(MouseEvent arg0) {
						m.getMd().setVisible(true);
				
					}
				});
				
			}
		});
		
		
		
		btnSuppMembre = new JButton(new ImageIcon("ressources/ressource_interface/suppMembre.png"));
		btnSuppMembre.setBounds(122, 21, 46, 52);
		btnSuppMembre.setBackground(null);
		btnSuppMembre.setBorder(null);
		panel_modifMembre.add(btnSuppMembre);
		
		btnSuppMembre.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent arg0) {
				SuppMembre supp = new SuppMembre();
				if(supp.getOp() == JOptionPane.YES_OPTION) {
					for(int i = 0; i<listeMembre.size(); i++) {
						if(listeMembre.get(i).getEstSelectionne() == true) {
							System.out.println(listeMembre.get(i).getLblNom());
							panel_arbre.repaint();
							panel_arbre.remove(listeMembre.get(i));
							//supMembre(listeMembre.get(i));


						}

					}
				}
				
				
				System.out.println(" membres sélectionnés supprimés");
			}
		});
		
		
		btnInfo = new JButton(new ImageIcon("ressources/ressource_interface/detailMembre.png"));
		btnInfo.setBounds(234, 21, 46, 52);
		btnInfo.setBackground(null);
		btnInfo.setBorder(null);
		panel_modifMembre.add(btnInfo);
		
		lblModifMembre = new JLabel("M O D I F I E R - M E M B R E");
		lblModifMembre.setBounds(95, 4, 150, 14);
		panel_modifMembre.add(lblModifMembre);
		lblModifMembre.addMouseListener(new MouseAdapter() {
			
		});
		
	
		btnForum = new JButton(new ImageIcon("ressources/ressource_interface/forum.png"));
		btnForum.setBounds(9, 21, 46, 52);
		btnForum.setBackground(null);
		btnForum.setBorder(null);
		panel_com.add(btnForum);
		
		btnPartager = new JButton(new ImageIcon("ressources/ressource_interface/partager.png"));
		btnPartager.setBounds(66, 21, 46, 52);
		btnPartager.setBackground(null);
		btnPartager.setBorder(null);
		panel_com.add(btnPartager);
		
		btnRepertoire = new JButton(new ImageIcon("ressources/ressource_interface/annuaire.png"));
		btnRepertoire.setBounds(123, 21, 46, 52);
		btnRepertoire.setBackground(null);
		btnRepertoire.setBorder(null);
		panel_com.add(btnRepertoire);
		
		btnAide = new JButton(new ImageIcon("ressources/ressource_interface/aide.png"));
		btnAide.setBounds(180, 21, 46, 52);
		btnAide.setBackground(null);
		btnAide.setBorder(null);
		panel_com.add(btnAide);
		
		btnProfil = new JButton(new ImageIcon("ressources/ressource_interface/profil.png"));
		btnProfil.setBounds(237, 21, 46, 52);
		btnProfil.setBackground(null);
		btnProfil.setBorder(null);
		panel_com.add(btnProfil);
		
		lblCommunication = new JLabel("C O M M U N I C A T I O N");
		lblCommunication.setBounds(60, 4, 190, 14);
		panel_com.add(lblCommunication);
		
	
		
		slider = new JSlider();
		slider.setOrientation(SwingConstants.VERTICAL);
		slider.setBackground(Color.WHITE);
		slider.setBounds(10, 450, 26, 117);
		panel_arbre.add(slider);
		
		label100 = new JLabel("100%");
		label100.setBounds(34, 501, 81, 14);
		panel_arbre.add(label100);
		
	
		btnItalique = new JButton(new ImageIcon("ressources/ressource_interface/italique.png"));
		btnItalique.setBounds(53, 52, 33, 33);
		btnItalique.setBackground(null);
		btnItalique.setBorder(null);
		panel_formatTxt.add(btnItalique);
		
		btnGras = new JButton(new ImageIcon("ressources/ressource_interface/gras.png"));
		btnGras.setBounds(10, 52, 33, 33);
		btnGras.setBackground(null);
		btnGras.setBorder(null);
		panel_formatTxt.add(btnGras);
		
		btnSouligner = new JButton(new ImageIcon("ressources/ressource_interface/souligne.png"));
		btnSouligner.setBounds(96, 52, 33, 33);
		btnSouligner.setBackground(null);
		btnSouligner.setBorder(null);
		panel_formatTxt.add(btnSouligner);
		
		comboBoxFont = new JComboBox();
		comboBoxFont.setBounds(10, 21, 150, 20);
		panel_formatTxt.add(comboBoxFont);
		
		comboBoxSize = new JComboBox();
		comboBoxSize.setBounds(170, 21, 45, 20);
		panel_formatTxt.add(comboBoxSize);
		
		btnPlusSize = new JButton(new ImageIcon("ressources/ressource_interface/agrandir.png"));
		btnPlusSize.setBounds(139, 52, 33, 33);
		btnPlusSize.setBackground(null);
		btnPlusSize.setBorder(null);
		panel_formatTxt.add(btnPlusSize);
		
		btnMoinsSize = new JButton(new ImageIcon("ressources/ressource_interface/retrecir.png"));
		btnMoinsSize.setBounds(182, 52, 33, 33);
		btnMoinsSize.setBackground(null);
		btnMoinsSize.setBorder(null);
		panel_formatTxt.add(btnMoinsSize);
		
		lblFormat = new JLabel("T E X T E");
		lblFormat.setBounds(100, 4, 154, 14);
		panel_formatTxt.add(lblFormat);
		
		
		
	}
	
	
	public void addMembre(Membre m) {
		this.listeMembre.add(m);
	}
	
	public void supMembre(Membre m) {
		this.listeMembre.remove(m);
		
	}
	public int getNbSelectionne()
	{
		nbSelectionne = 0;
		for(int i = 0; i<listeMembre.size(); i++)
		{
			if(listeMembre.get(i).getEstSelectionne() == true)
			{
				nbSelectionne ++;
			}
		}
		return nbSelectionne;
	}
	
	
	
}
