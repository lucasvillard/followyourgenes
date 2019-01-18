package FYG;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class Partage {

	private JFrame frmFollowYourGenes;
	private JTextPane txtPartager;
	private JButton btnOui;
	JButton btnNon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partage window = new Partage();
					window.frmFollowYourGenes.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Partage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFollowYourGenes = new JFrame();
		frmFollowYourGenes.setTitle("Partager votre arbre sur Facebook");
		frmFollowYourGenes.setBounds(100, 100, 500, 220);
		frmFollowYourGenes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFollowYourGenes.getContentPane().setLayout(null);
		
		txtPartager = new JTextPane();
		txtPartager.setEditable(false);
		txtPartager.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPartager.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		txtPartager.setText("Partagez votre arbre g\u00E9n\u00E9alogique avec vos amis sur Facebook et invitez les \u00E0 prendre part \u00E0  l'accomplissement de votre histoire ! ");
		txtPartager.setBounds(29, 31, 417, 57);
		frmFollowYourGenes.getContentPane().add(txtPartager);
		
		btnOui = new JButton("Oui");
		btnOui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOui.setBounds(98, 99, 95, 34);
		frmFollowYourGenes.getContentPane().add(btnOui);
		
		btnNon = new JButton("Non");
		btnNon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNon.setBounds(293, 99, 95, 34);
		frmFollowYourGenes.getContentPane().add(btnNon);
	}
}
