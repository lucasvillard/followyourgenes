package FYG;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Lien extends JPanel{
	
		private ArrayList<Membre> membresLies;
		
		
		public Lien(ArrayList<Membre> listeMembre, String orientation) {
			Color color = new Color(48, 153, 90);

			membresLies = new ArrayList<Membre>();
			membresLies = listeMembre;				
			if(orientation.equals("horizontal")) {
				int x =membresLies.get(0).getX()+membresLies.get(0).getWidth();
				int y =membresLies.get(0).getY();
				setBounds(x,y+50 , 120,10);
				membresLies.get(1).setLocation(x+getWidth(), y );
				setBackground(color);
			}
			else {
				if(orientation.equals("vertical")) {
					int x = membresLies.get(0).getX() + membresLies.get(0).getWidth();
					int y = membresLies.get(0).getY() - 50;
					int width = membresLies.get(0).getX() - 170;
					setBounds(x +60,y+100, 10, width);
					membresLies.get(2).setLocation(x+getWidth()-25, y+280); 
					setBackground(color);
					
				}
			}
			
		}
	
}
