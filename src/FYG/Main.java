package FYG;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {
	
	
	
	private static JFrame frame= new JFrame();	
	private Galerie galerie = new Galerie();
	private static Accueil accueil = new Accueil();
	private static JLabel retourAccueil = new JLabel();
	
	public void navigation() {
		//retourAccueil = galerie.getRetour();
		retourAccueil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame = accueil.getFrmFyg();
				
			}
		});
		
		
	}	

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		
		SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				
				frame = accueil.getFrmFyg();
				frame.setVisible(true);
				
				

				
			}
		});

	}


	
	
}
