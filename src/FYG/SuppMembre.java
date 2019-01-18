package FYG;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;

public class SuppMembre extends JOptionPane{

	private JFrame frmFollowYourGenes;
	private JLabel lblLogoAttention;
	private JTextPane txtSuppMembre;
	private JButton btnOui;
	JButton btnNon;
	private int op;

	
	/**
	 * Create the application.
	 */
	public SuppMembre() {
		//initialize();
		this.setOp(showConfirmDialog(null,"Etes-vous sur de vouloir supprimer les membres sélectionnés ? ","Supression des membres sélectionnés", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE));
		
	}


	public int getOp() {
		return op;
	}


	public void setOp(int op) {
		this.op = op;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	/*private void initialize() {
		frmFollowYourGenes = new JFrame();
		frmFollowYourGenes.setTitle("Follow Your Genes");
		frmFollowYourGenes.setBounds(100, 100, 500, 220);
		frmFollowYourGenes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFollowYourGenes.getContentPane().setLayout(null);
		
		lblLogoAttention = new JLabel("LogoAttention");
		lblLogoAttention.setBounds(10, 52, 68, 84);
		frmFollowYourGenes.getContentPane().add(lblLogoAttention);
		
		txtSuppMembre = new JTextPane();
		txtSuppMembre.setEditable(false);
		txtSuppMembre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSuppMembre.setBackground(UIManager.getColor("InternalFrame.borderColor"));
		txtSuppMembre.setText("\u00CAtes-vous s\u00FBr de vouloir supprimer ce membre ?");
		txtSuppMembre.setBounds(88, 31, 334, 23);
		frmFollowYourGenes.getContentPane().add(txtSuppMembre);
		
		btnOui = new JButton("Oui");
		btnOui.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOui.setBounds(113, 85, 95, 34);
		frmFollowYourGenes.getContentPane().add(btnOui);
		
		btnNon = new JButton("Non");
		btnNon.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNon.setBounds(275, 85, 95, 34);
		frmFollowYourGenes.getContentPane().add(btnNon);
	}*/

}
