package FYG;

import java.util.ArrayList;

import javax.swing.JPanel;

public class Arbre extends JPanel{
	
	private ArrayList<JPanel> composantArbre;
	
	public Arbre() {
		composantArbre = new ArrayList<JPanel>();
	}
	
	
	public void addComposant(JPanel panel) {
		repaint();
		composantArbre.add(panel);
		int width=0;
		int height=0;
		for(int i=0; i< composantArbre.size();i++) {
			width+= composantArbre.get(i).getWidth();
			height+= composantArbre.get(i).getHeight();
		}
		setBounds(getX(),getY(),width,height);
	}
	
	

}
