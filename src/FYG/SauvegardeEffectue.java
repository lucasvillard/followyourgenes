package FYG;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class SauvegardeEffectue {

	private JFrame frmFollowYourGenes;
	private JTextPane txtSauvegarde;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SauvegardeEffectue window = new SauvegardeEffectue();
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
	public SauvegardeEffectue() {
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
		
		txtSauvegarde = new JTextPane();
		txtSauvegarde.setEditable(false);
		txtSauvegarde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSauvegarde.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		txtSauvegarde.setText("La sauvegarde a bien \u00E9t\u00E9 effectu\u00E9");
		txtSauvegarde.setBounds(105, 29, 220, 23);
		frmFollowYourGenes.getContentPane().add(txtSauvegarde);
	}

}
