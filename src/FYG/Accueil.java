package FYG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Canvas;
import java.awt.Toolkit;
import javax.swing.JLabel;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Accueil {

	private JFrame frmFyg;
	private JButton galerieButton = new JButton("Galerie");
	private JButton forumButton = new JButton("Forum");
	private JButton btnConnexioninscription = new JButton("Connexion/Inscription");
	private JLabel fygLogo = new JLabel("");
	private JButton btnGenealogie = new JButton("Genealogie");
	private Galerie galerie = new Galerie();
	private Genealogie genealogie = new Genealogie();


	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil window = new Accueil();
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
	public Accueil() {
		initialize();
	}
	
	public JFrame getFrmFyg() {
		return this.frmFyg;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFyg = new JFrame();
		frmFyg.getContentPane().setEnabled(false);
		//frmFyg.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ASUS\\Documents\\IUT Nice\\S3\\M332 PT\\Follow_Your_Genes\\Resource\\logo_final.png"));
		frmFyg.getContentPane().setBackground(Color.WHITE);
		frmFyg.setFont(new Font("Bell MT", Font.PLAIN, 12));
		frmFyg.setTitle("FYG");
		frmFyg.setBounds(100, 100, 406, 400);
		frmFyg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFyg.getContentPane().setLayout(null);
		
		btnGenealogie.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				frmFyg.setCursor(Cursor.getPredefinedCursor((Cursor.HAND_CURSOR)));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				frmFyg.setCursor(Cursor.getDefaultCursor());
			}
		});
		btnGenealogie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFyg.setVisible(false);
				frmFyg = genealogie.getframFyg();
				frmFyg.setVisible(true);
				
			}
		});
		btnGenealogie.setBounds(120, 165, 166, 42);
		frmFyg.getContentPane().add(btnGenealogie);
		
		galerieButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFyg.setVisible(false);
				frmFyg = galerie.getframFyg();
				frmFyg.setVisible(true);
			}
		});
		galerieButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				frmFyg.setCursor(Cursor.getPredefinedCursor((Cursor.HAND_CURSOR)));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				frmFyg.setCursor(Cursor.getDefaultCursor());
			}
		});
		galerieButton.setBounds(120, 218, 166, 42);
		frmFyg.getContentPane().add(galerieButton);
		
		forumButton.setBounds(120, 271, 166, 42);
		frmFyg.getContentPane().add(forumButton);
		btnConnexioninscription.setForeground(new Color(0, 0, 0));
		btnConnexioninscription.setBackground(SystemColor.activeCaption);
		btnConnexioninscription.setBounds(230, 0, 160, 23);
		frmFyg.getContentPane().add(btnConnexioninscription);
		
		fygLogo.setIcon(new ImageIcon(Accueil.class.getResource("/ressource_interface/FYGlogo.png")));
		fygLogo.setBounds(150, 54, 100, 100);
		frmFyg.getContentPane().add(fygLogo);
	}
}
