package FYG;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class DeconnexionEffectue {

	private JFrame frmFollowYourGenes;
	private JTextPane txtDeconnexion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeconnexionEffectue window = new DeconnexionEffectue();
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
	public DeconnexionEffectue() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFollowYourGenes = new JFrame();
		frmFollowYourGenes.setTitle("Follow Your Genes");
		frmFollowYourGenes.setBounds(100, 100, 446, 126);
		frmFollowYourGenes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFollowYourGenes.getContentPane().setLayout(null);
		
		txtDeconnexion = new JTextPane();
		txtDeconnexion.setEditable(false);
		txtDeconnexion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDeconnexion.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		txtDeconnexion.setText("Vous avez bien \u00E9t\u00E9 d\u00E9connect\u00E9");
		txtDeconnexion.setBounds(105, 29, 220, 23);
		frmFollowYourGenes.getContentPane().add(txtDeconnexion);
	}

}
