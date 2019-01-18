package FYG;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;


//A voir si utile

public class Navigation implements ActionListener{

	
	public JButton btnGenealogie = new JButton("Genealogie");
	public JButton btnGallerie = new JButton("Galerie");
	public JButton btnForum = new JButton("Forum");
	
	public JFrame frame = new JFrame();
	
	public Navigation() {
		initialize_Accueil();
		btnGenealogie.addActionListener(this);
		btnGallerie.addActionListener(this);
		btnForum.addActionListener(this);
	}

	public static void main(String[] args) throws InterruptedException {
	       
		Navigation nav = new Navigation();
	     

	}
	  
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == btnGenealogie){
			
			frame.getContentPane().removeAll();
			initialize_Genealogie();
		}
		else if(arg0.getSource() == btnGallerie){
			frame.getContentPane().removeAll();
			initialize_Gallerie();
		}
		else if(arg0.getSource() == btnForum){
			frame.getContentPane().removeAll();
			initialize_Accueil();
		}
	}
	
	public void initialize_Genealogie(){
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		btnGallerie.setText("Gallerie");
		frame.getContentPane().add(btnGallerie);
		
		Button button_4 = new Button("Connexion/Inscription");
		frame.getContentPane().add(button_4);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setPreferredSize(new Dimension(frame.getWidth(),110));
		frame.setJMenuBar(menuBar);
		
		JPanel panel = new JPanel();
		menuBar.add(panel);
		panel.setLayout(null);
		
		JLabel lblMenu = new JLabel("Menu 1");
		lblMenu.setBounds(37, 0, 46, 14);
		panel.add(lblMenu);
		
		Button button = new Button("New button");
		button.setBounds(10, 20, 70, 22);
		panel.add(button);
		
		btnForum.setText("Accueil");
		btnForum.setBounds(10, 46, 70, 22);
		panel.add(btnForum);
		
		btnGenealogie.setText("Genealogie");
		btnGenealogie.setBounds(10, 74, 70, 22);
		panel.add(btnGenealogie);
		
		JPanel panel_1 = new JPanel();
		menuBar.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		menuBar.add(panel_2);
		
		frame.setVisible(true);
		
	}
	
	public void initialize_Accueil() {
		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.getContentPane().add(btnGenealogie, BorderLayout.NORTH);
		
		
		frame.getContentPane().add(btnGallerie, BorderLayout.WEST);
		
		
		frame.getContentPane().add(btnForum, BorderLayout.CENTER);
		
		frame.setVisible(true);
		System.out.println("Bite");
		
	}
	
	public void initialize_Gallerie() {
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.repaint();
		frame.setVisible(true);
		System.out.println("Bite");
	}
	
	
}
