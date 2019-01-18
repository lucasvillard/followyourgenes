package FYG;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//import javax.swing.JPopupMenu;
import javax.swing.JToolBar;

public class MaFenetre extends JFrame{

	private Container c;
	//private JPopupMenu popupmenu;
	Locale defaut = new Locale("fr","FR");
	ResourceBundle mesRessources = ResourceBundle.getBundle("menus", defaut); 
	private static final long serialVersionUID = 1345376003869391813L;

	
	public MaFenetre(){
		super();
		InitializeComponent();
	}
	
	//initialisation de la fenêtre du logiciel
	private void InitializeComponent(){
		this.setTitle("FYG");
		this.setResizable(false);
		this.setSize(1024,768);
		this.setVisible(true);		
		InitMenu();
		/*
		JToolBar toolbar = new 	JToolBar();
		c.add(toolbar, BorderLayout.NORTH);
				
		JButton Nouvel_arbre = new JButton();
		JButton Telecharger_arbre = new JButton();
		JButton Nvlle_gedcom = new JButton();
		JButton Mettre_en_fav = new JButton();

		JButton Exporter = new JButton();
		JButton Importer= new JButton();
		JButton Supprimer_arbre= new JButton();
		JButton Enregistrer = new JButton();
		
		JButton Gras = new JButton();
		JButton Italique = new JButton();
		JButton Souligner = new JButton();
		JButton Retrecir = new JButton();
		
		JButton Modification_membre = new JButton();
		JButton Deplacer_membre = new JButton();
		JButton Lien_conjugal= new JButton();
		JButton Ajouter_membre = new JButton();
		
		JButton Ajouter_desc = new JButton();
		JButton Modifier_infos= new JButton();
		JButton Communication = new JButton();
		JButton Forum = new JButton();
		JButton Partager = new JButton();
		JButton A_propos = new JButton();
		JButton Profil = new JButton();
		Nouvel_arbre.setToolTipText(mesRessources.getString("Nouvel_arbre"));
		Telecharger_arbre.setToolTipText(mesRessources.getString("Telecharger_arbre"));
		Nvlle_gedcom.setToolTipText(mesRessources.getString("Nvlle_gedcom"));
		Mettre_en_fav.setToolTipText(mesRessources.getString("Mettre_en_fav"));
		
		toolbar.add(Nouvel_arbre);
		toolbar.add(Telecharger_arbre);
		toolbar.addSeparator();
		toolbar.add(Nvlle_gedcom);
		toolbar.add(Mettre_en_fav);
		
		c.add(toolbar, BorderLayout.NORTH);
		*/
	
	}
	
	
	 private void InitMenu(){
		 c = this.getContentPane();

		 JMenuBar Ruban = new JMenuBar();
		 JMenuBar Ruban2 = new JMenuBar();
		 this.setJMenuBar(Ruban);
		 this.setJMenuBar(Ruban2);

		JMenuBar MenuFichier = new JMenuBar();
		JMenu MenuText = new JMenu();
		
				 
		 /*
		  JMenuItem Nouvel_arbre = new JMenuItem(mesRessources.getString("Nouvel_arbre"));
		   		 JMenuItem Gras = new JMenuItem(mesRessources.getString("Gras"));

		  
		 
		 MenuFichier.add(Nouvel_arbre);
		 MenuText.add(Gras);
		 
		 */

		JButton Nouvel_arbre = new JButton("test");
		JButton Telecharger_arbre = new JButton("test");
		JButton Nvlle_gedcom = new JButton("test");
		JButton Mettre_en_fav = new JButton("test");

		JButton Exporter = new JButton("test");
		JButton Importer= new JButton("test");
		JButton Supprimer_arbre= new JButton("test");
		JButton Enregistrer = new JButton("test");
			
		JButton Gras = new JButton();
		JButton Italique = new JButton();
		JButton Souligner = new JButton();
		JButton Retrecir = new JButton();
		
		JButton Modification_membre = new JButton();
		JButton Deplacer_membre = new JButton();
		JButton Lien_conjugal= new JButton();
		JButton Ajouter_membre = new JButton();
		
		JButton Ajouter_desc = new JButton();
		JButton Modifier_infos= new JButton();
		JButton Communication = new JButton();
		JButton Forum = new JButton();
		JButton Partager = new JButton();
		JButton A_propos = new JButton();
	
		MenuFichier.add(Nouvel_arbre);
		MenuFichier.add(Telecharger_arbre);

		MenuText.add(Nvlle_gedcom);
		MenuText.add(Exporter);
		MenuText.add(Mettre_en_fav);


		Ruban.add(MenuText);
		Ruban.add(MenuFichier);

		 this.getContentPane().add(Ruban,BorderLayout.NORTH);
		 this.getContentPane().add(Ruban2);

		
	 }	
	
}
