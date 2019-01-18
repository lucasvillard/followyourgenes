package FYG;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;

public class SuppGenealogie {

	private JFrame frmFollowYourGenes;
	private JLabel lblLogoAttention;
	private JTextPane txtSuppGenealogie;
	private JButton btnOui;
	JButton btnNon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuppGenealogie window = new SuppGenealogie();
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
	public SuppGenealogie() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFollowYourGenes = new JFrame();
		frmFollowYourGenes.setTitle("Follow Your Genes");
		frmFollowYourGenes.setBounds(100, 100, 500, 220);
		frmFollowYourGenes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFollowYourGenes.getContentPane().setLayout(null);
		
		lblLogoAttention = new JLabel("LogoAttention");
		lblLogoAttention.setBounds(10, 52, 68, 84);
		frmFollowYourGenes.getContentPane().add(lblLogoAttention);
		
		txtSuppGenealogie = new JTextPane();
		txtSuppGenealogie.setEditable(false);
		txtSuppGenealogie.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSuppGenealogie.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		txtSuppGenealogie.setText("\u00CAtes-vous s\u00FBr de vouloir supprimer cette g\u00E9n\u00E9alogie ?");
		txtSuppGenealogie.setBounds(88, 31, 334, 23);
		frmFollowYourGenes.getContentPane().add(txtSuppGenealogie);
		
		btnOui = new JButton("Oui");
		btnOui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOui.setBounds(113, 85, 95, 34);
		frmFollowYourGenes.getContentPane().add(btnOui);
		
		btnNon = new JButton("Non");
		btnNon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNon.setBounds(275, 85, 95, 34);
		frmFollowYourGenes.getContentPane().add(btnNon);
	}
}
