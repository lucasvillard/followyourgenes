package FYG;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class Mariage extends JFrame {

	private JPanel contentPane;
	private Membre membre1;
	private Membre membre2;
	private JTextField txtLieu;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mariage frame = new Mariage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Mariage() {
		setResizable(false);
		setTitle("FYG - Mariage");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 301, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Marié(e)s le :");
		label.setBounds(10, 11, 74, 14);
		contentPane.add(label);
		
		JLabel lblJour1 = new JLabel("Jour");
		lblJour1.setBounds(10, 36, 46, 14);
		contentPane.add(lblJour1);
		
		JComboBox jour1 = new JComboBox();
		jour1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		jour1.setBounds(36, 33, 37, 20);
		contentPane.add(jour1);
		
		JLabel lblMois1 = new JLabel("Mois");
		lblMois1.setBounds(83, 36, 46, 14);
		contentPane.add(lblMois1);
		
		JComboBox mois1 = new JComboBox();
		mois1.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"}));
		mois1.setBounds(110, 33, 63, 20);
		contentPane.add(mois1);
		
		JLabel lblAnnee1 = new JLabel("Ann\u00E9e");
		lblAnnee1.setBounds(183, 36, 46, 14);
		contentPane.add(lblAnnee1);
		
		JComboBox annee1 = new JComboBox();
		annee1.setModel(new DefaultComboBoxModel(new String[] {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1920", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		annee1.setBounds(218, 33, 55, 20);
		contentPane.add(annee1);
		
		JLabel lieu1 = new JLabel("\u00C0");
		lieu1.setBounds(10, 70, 46, 14);
		contentPane.add(lieu1);
		
		txtLieu = new JTextField();
		txtLieu.setText("Lieu");
		txtLieu.setBounds(31, 67, 86, 20);
		contentPane.add(txtLieu);
		txtLieu.setColumns(10);
		
		JCheckBox chckbxDivorcesLe = new JCheckBox("Divorc\u00E9(e)s le : ");
		chckbxDivorcesLe.setBounds(10, 108, 119, 23);
		contentPane.add(chckbxDivorcesLe);
		
		JLabel labelJour2 = new JLabel("Jour");
		labelJour2.setBounds(10, 141, 46, 14);
		contentPane.add(labelJour2);
		
		JComboBox jour2 = new JComboBox();
		jour2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		jour2.setEnabled(false);
		jour2.setBounds(36, 138, 37, 20);
		contentPane.add(jour2);
		
		JLabel labelMois2 = new JLabel("Mois");
		labelMois2.setBounds(83, 141, 46, 14);
		contentPane.add(labelMois2);
		
		JComboBox mois2 = new JComboBox();
		mois2.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"}));
		mois2.setEnabled(false);
		mois2.setBounds(110, 138, 63, 20);
		contentPane.add(mois2);
		
		JLabel labelAnnee2 = new JLabel("Ann\u00E9e");
		labelAnnee2.setBounds(183, 141, 46, 14);
		contentPane.add(labelAnnee2);
		
		JComboBox annee2 = new JComboBox();
		annee2.setModel(new DefaultComboBoxModel(new String[] {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1920", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		annee2.setEnabled(false);
		annee2.setBounds(218, 138, 55, 20);
		contentPane.add(annee2);
		
		JButton btnNewButton = new JButton("Valider");
		btnNewButton.setBounds(98, 270, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setBounds(10, 181, 46, 14);
		contentPane.add(lblNote);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 206, 275, 47);
		contentPane.add(textArea);
		
		
		//Activation pour le divorce
		
		chckbxDivorcesLe.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxDivorcesLe.isSelected() == true)
				{
					jour2.setEnabled(true);
					mois2.setEnabled(true);
					annee2.setEnabled(true);
				}
				else
				{
					jour2.setEnabled(false);
					mois2.setEnabled(false);
					annee2.setEnabled(false);
				}
			}
			
		});
	}
}
