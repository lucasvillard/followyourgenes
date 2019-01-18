package FYG;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ModifierMembre extends JFrame {

	private Membre membre;
	private JPanel contentPane;
	private JTextField txtNom;
	private JTextField txtPrnom;
	private JTextField txtLieuDeNaissance;
	private JTextField autre;
	private JTextField lieudeDc;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Membre m = new Membre();
					ModifierMembre frame = new ModifierMembre(m);
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
	public ModifierMembre(Membre m) {
		setResizable(false);
		setTitle("FYG - Membre");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 301, 516);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		membre = m;
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 82, 63, 29);
		contentPane.add(lblNom);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom");
		lblPrnom.setBounds(10, 122, 46, 10);
		contentPane.add(lblPrnom);
		
		txtNom = new JTextField();
		txtNom.setEditable(false);
		txtNom.setEnabled(false);
		txtNom.setText("Nom");
		txtNom.setBounds(65, 86, 103, 20);
		contentPane.add(txtNom);
		txtNom.setColumns(10);
		
		txtPrnom = new JTextField();
		txtPrnom.setEditable(false);
		txtPrnom.setEnabled(false);
		txtPrnom.setText("Pr\u00E9nom");
		txtPrnom.setBounds(66, 122, 103, 20);
		contentPane.add(txtPrnom);
		txtPrnom.setColumns(10);
		
		JLabel lblNe = new JLabel("N\u00E9e \u00E0");
		lblNe.setBounds(10, 241, 46, 14);
		contentPane.add(lblNe);
		
		txtLieuDeNaissance = new JTextField();
		txtLieuDeNaissance.setEnabled(false);
		txtLieuDeNaissance.setEditable(false);
		txtLieuDeNaissance.setText("Lieu");
		txtLieuDeNaissance.setBounds(65, 238, 103, 20);
		contentPane.add(txtLieuDeNaissance);
		txtLieuDeNaissance.setColumns(10);
		
		JLabel lblDateDeNaissance = new JLabel("Date de naissance");
		lblDateDeNaissance.setBounds(10, 182, 88, 14);
		contentPane.add(lblDateDeNaissance);
		
		JLabel lblSexe = new JLabel("Sexe");
		lblSexe.setBounds(10, 157, 46, 14);
		contentPane.add(lblSexe);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setEnabled(false);
		rdbtnF.setBounds(65, 153, 31, 23);
		contentPane.add(rdbtnF);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setEnabled(false);
		rdbtnM.setBounds(98, 153, 39, 23);
		contentPane.add(rdbtnM);
		
		JRadioButton rdbtnAutre = new JRadioButton("Autre :");
		rdbtnAutre.setEnabled(false);
		rdbtnAutre.setBounds(139, 153, 59, 23);
		contentPane.add(rdbtnAutre);
		
		autre = new JTextField();
		autre.setEditable(false);
		autre.setEnabled(false);
		autre.setBounds(204, 154, 86, 20);
		contentPane.add(autre);
		autre.setColumns(10);
		
		JLabel lblJour = new JLabel("Jour");
		lblJour.setBounds(10, 207, 21, 14);
		contentPane.add(lblJour);
		
		JLabel lblMois = new JLabel("Mois");
		lblMois.setBounds(80, 207, 31, 14);
		contentPane.add(lblMois);
		
		JLabel lblAnne = new JLabel("Ann\u00E9e");
		lblAnne.setBounds(187, 207, 42, 14);
		contentPane.add(lblAnne);
		
		JCheckBox chckbxPersonneInconnue = new JCheckBox("Personne inconnue");
		chckbxPersonneInconnue.setSelected(true);
		chckbxPersonneInconnue.setBounds(10, 426, 158, 23);
		contentPane.add(chckbxPersonneInconnue);
		
		JComboBox cBJourN = new JComboBox();
		cBJourN.setEnabled(false);
		cBJourN.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cBJourN.setMaximumRowCount(31);
		cBJourN.setBounds(34, 204, 39, 20);
		contentPane.add(cBJourN);
		
		JComboBox cBMoisN = new JComboBox();
		cBMoisN.setEnabled(false);
		cBMoisN.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"}));
		cBMoisN.setMaximumRowCount(12);
		cBMoisN.setBounds(109, 204, 68, 20);
		contentPane.add(cBMoisN);
		
		JComboBox cBAnneeN = new JComboBox();
		cBAnneeN.setEnabled(false);
		cBAnneeN.setModel(new DefaultComboBoxModel(new String[] {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1920", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		cBAnneeN.setBounds(221, 204, 51, 20);
		contentPane.add(cBAnneeN);
		
		
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(chckbxPersonneInconnue.isSelected()==false) {
					m.setLblNom(txtNom.getText());
					m.setLblPrenom(txtPrnom.getText());
					m.setLblLieuN(txtLieuDeNaissance.getText());
					m.setLblAnneeDeNaiss((String) cBAnneeN.getSelectedItem());	
				}
			}
		});
		btnValider.setBounds(98, 456, 89, 23);
		contentPane.add(btnValider);
		
		JLabel lblNote = new JLabel("Note");
		lblNote.setBounds(10, 365, 46, 14);
		contentPane.add(lblNote);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 383, 280, 40);
		contentPane.add(textArea);
		
		JLabel lblDcde = new JLabel("D\u00E9c\u00E9d\u00E9e \u00E0");
		lblDcde.setBounds(10, 322, 63, 14);
		contentPane.add(lblDcde);
		
		lieudeDc = new JTextField();
		lieudeDc.setEnabled(false);
		lieudeDc.setEditable(false);
		lieudeDc.setText("Lieu");
		lieudeDc.setColumns(10);
		lieudeDc.setBounds(65, 347, 103, 20);
		contentPane.add(lieudeDc);
		
		JLabel lblJourDc = new JLabel("Jour");
		lblJourDc.setBounds(10, 294, 21, 14);
		contentPane.add(lblJourDc);
		
		JComboBox cBJourD = new JComboBox();
		cBJourD.setEnabled(false);
		cBJourD.setMaximumRowCount(31);
		cBJourD.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		cBJourD.setBounds(34, 291, 39, 20);
		contentPane.add(cBJourD);
		
		JLabel lblMoisDc = new JLabel("Mois");
		lblMoisDc.setBounds(80, 294, 31, 14);
		contentPane.add(lblMoisDc);
		
		JComboBox cBMoisD = new JComboBox();
		cBMoisD.setEnabled(false);
		cBMoisD.setModel(new DefaultComboBoxModel(new String[] {"Janvier", "F\u00E9vrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Ao\u00FBt", "Septembre", "Octobre", "Novembre", "D\u00E9cembre"}));
		cBMoisD.setMaximumRowCount(12);
		cBMoisD.setBounds(109, 291, 68, 20);
		contentPane.add(cBMoisD);
		
		JLabel lblAnneeDc = new JLabel("Ann\u00E9e");
		lblAnneeDc.setBounds(187, 294, 42, 14);
		contentPane.add(lblAnneeDc);
		
		JComboBox cBAnneeD = new JComboBox();
		cBAnneeD.setEnabled(false);
		cBAnneeD.setModel(new DefaultComboBoxModel(new String[] {"1900", "1901", "1902", "1903", "1904", "1905", "1906", "1907", "1908", "1909", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1920", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020"}));
		cBAnneeD.setBounds(221, 291, 51, 20);
		contentPane.add(cBAnneeD);
		
		JCheckBox cBDateDeDc = new JCheckBox("Date de décès");
		cBDateDeDc.setEnabled(false);
		cBDateDeDc.setBounds(10, 264, 97, 23);
		contentPane.add(cBDateDeDc);
		
		cBDateDeDc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(cBDateDeDc.isSelected()) {
					cBJourD.setEnabled(true);
					cBMoisD.setEnabled(true);
					cBAnneeD.setEnabled(true);
					lieudeDc.setEditable(true);
					lieudeDc.setEnabled(true);

				}
				else
				{
					lieudeDc.setEditable(false);
					lieudeDc.setEnabled(false);
					cBJourD.setEnabled(false);
					cBMoisD.setEnabled(false);
					cBAnneeD.setEnabled(false);
					
				}
			}
			
		});
		
		chckbxPersonneInconnue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(chckbxPersonneInconnue.isSelected()==false) {
					txtNom.setEditable(true);
					txtNom.setEnabled(true);
					txtPrnom.setEditable(true);
					txtPrnom.setEnabled(true);
					txtLieuDeNaissance.setEditable(true);
					txtLieuDeNaissance.setEnabled(true);
					cBJourN.setEnabled(true);
					cBMoisN.setEnabled(true);
					cBAnneeN.setEnabled(true);
					rdbtnF.setEnabled(true);
					rdbtnM.setEnabled(true);
					autre.setEditable(true);
					autre.setEnabled(true);
					cBDateDeDc.setEnabled(true);
					
				}
				else
				{
					txtNom.setEditable(false);
					txtPrnom.setEditable(false);
					cBJourN.setEnabled(false);
					cBMoisN.setEnabled(false);
					cBAnneeN.setEnabled(false);
					txtLieuDeNaissance.setEditable(false);
					txtLieuDeNaissance.setEnabled(false);	
					rdbtnF.setEnabled(false);
					rdbtnM.setEnabled(false);
					rdbtnAutre.setEnabled(false);
					cBDateDeDc.setEnabled(false);


				}
			}
		});
	}
	
	public void setTxtNom(String nom) {
		txtNom.setText(nom);
	}
	
	public String getTxtNom() {
		return txtNom.getText();
	}
	
	public void setTxtPrenom(String prenom) {
		txtPrnom.setText(prenom);
	}
	
	public String getTxtPrenom() {
		return txtPrnom.getText();
	}
	
	public void setLieuDeNaissance(String lieuNaissance) {
		txtLieuDeNaissance.setText(lieuNaissance);
	}
	
	public void setLieuDeDeces(String lieuNaissance) {
		txtLieuDeNaissance.setText(lieuNaissance);
	}
}
