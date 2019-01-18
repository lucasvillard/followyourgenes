package FYG;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Membre extends JPanel {

	/**
	 * Create the panel.
	 */	
	
	
	
	private ModifierMembre md = new ModifierMembre(this);
	private JLabel lblNom = new JLabel("Nom ");
	private JLabel lblPrnom = new JLabel("Pr\u00E9nom ");
	private JLabel lblNe = new JLabel("N\u00E9e \u00E0");
	private JLabel lblCrayon = new JLabel("Crayon");
	private JLabel lblAnneeDeNaiss = new JLabel("Année");
	private JLabel lblAnneDeDcs = new JLabel("Année");
	private JLabel lblLieuN = new JLabel("lieu");
	private boolean estLie;
	private boolean estSelectionne;
	private ArrayList<Lien> listeLien = new ArrayList<Lien>();
	private int nvX, difX;
    private int nvY, difY;
    private int x;
    private int y;

	public Membre() {
		setLayout(null);
		estLie = new Boolean(false);
		x = getX();
		y = getY();
		estSelectionne = new Boolean(false);
		lblNom.setBounds(10, 82, 58, 14);
		add(lblNom);
		
		lblPrnom.setBounds(78, 82, 61, 14);
		add(lblPrnom);
		
		lblAnneeDeNaiss.setBounds(10, 107, 46, 14);
		add(lblAnneeDeNaiss);
		
		lblAnneDeDcs.setBounds(78, 107, 84, 14);
		add(lblAnneDeDcs);
		
		lblNe.setBounds(10, 132, 46, 14);
		add(lblNe);
		
		getLblCrayon().setBounds(116, 0, 46, 14);
		add(getLblCrayon());
		
		lblLieuN.setBounds(78, 132, 46, 14);
		add(lblLieuN);
	
		
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				difX=e.getLocationOnScreen().x - getX();
				difY=e.getLocationOnScreen().y - getY();

			}
			
			public void mouseClicked(MouseEvent e) {
				if(getEstSelectionne()==false) {
					setEstSelectionne(true);
					System.out.println(lblNom.getText() + "  "+estSelectionne);
					setBorder(BorderFactory.createLineBorder(Color.black));

				}
				else
				{
					
					setEstSelectionne(false);
					System.out.println(lblNom.getText() + "  "+estSelectionne);
					setBorder(null);
				}
			}
		});
		
		/*this.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				setEstSelectionne(false);
			}
		});*/
		
		
		

		
		this.addMouseMotionListener(new MouseMotionAdapter()
        {                     
          public void mouseDragged(MouseEvent e) 
            {
        	  	nvX =(int) e.getLocationOnScreen().getX() -difX;
          		nvY = (int) e.getLocationOnScreen().getY() -difY;
                setLocation(nvX,nvY);	
                
           
            }	
        });
		
		
	}

	public void setEstSelectionne(Boolean b) {
		estSelectionne = b;
	}
	
	public boolean getEstSelectionne() {
		return estSelectionne;
	}

	public JLabel getLblCrayon() {
		return lblCrayon;
	}

	public void setLblLieuN(String lieuN) {
		this.lblLieuN.setText(lieuN);
	}

	public void setLblCrayon(String lblCrayon) {
		this.lblCrayon.setText(lblCrayon);
	}
	
	public void setLblNe(String NeeA) {
		this.lblNe.setText(NeeA);
	}
	
	public void setLblAnneeDeNaiss(String AnneeDeNaiss) {
		this.lblAnneeDeNaiss.setText(AnneeDeNaiss);
	}
	
	public void setLblAnneDeDc(String AnneDeDc) {
		this.lblAnneDeDcs.setText(AnneDeDc);
	}

	public JLabel getLblNom() {
		return lblNom;
	}


	public void setLblNom(String lblNom) {
		this.lblNom.setText(lblNom);
	}
	
	public void setLblPrenom(String lblPrenom) {
		this.lblPrnom.setText(lblPrenom);
	}


	public ModifierMembre getMd() {
		return md;
	}


	public void setMd(ModifierMembre md) {
		this.md = md;
	}
	
	public boolean isEstLie() {
		return estLie;
	}

	public void setEstLie(boolean estLie) {
		this.estLie = estLie;
	}
}
