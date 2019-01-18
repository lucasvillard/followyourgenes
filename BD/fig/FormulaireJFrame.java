package fig;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import javax.swing.JLabel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import java.awt.Point;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;

public class FormulaireJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtPrenom;
	private JTextField TextFVille;
	private JTextField TextFCodeP;
	private JTextField TextFDepartement;
	private JLabel lblDepartement;
	private JLabel lblDate;
	private JLabel lblPrenom;
	private JComboBox<String> cbSexe;
	private JLabel lblSexe;
	private JSeparator separator;
	private JTextPane txtPane;
	private int initX, initY;
	private JLabel lblX;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormulaireJFrame frame = new FormulaireJFrame();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormulaireJFrame() {
		
		int x = 300, y = 300;

		setResizable(false);
		setTitle("Test Autocompletion");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(FormulaireJFrame.class.getResource("/com/sun/java/swing/plaf/windows/icons/HardDrive.gif")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 544, 290);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 551, 20);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblX = new JLabel("");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				lblX.setIcon(new ImageIcon(FormulaireJFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/close-pressed.gif")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				lblX.setIcon(new ImageIcon(FormulaireJFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
			}
		});
		lblX.setIcon(new ImageIcon(FormulaireJFrame.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		lblX.setBounds(525, 0, 16, 21);
		panel.add(lblX);
		
		panel.addMouseListener(new MouseAdapter() {
			Point p;
			@Override
			public void mousePressed(MouseEvent arg0) {
				p = arg0.getPoint();
				initX = (int)p.getX();
				initY = (int)p.getY();
			}
		});
		
		panel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getLocation().x+e.getX()-initX, getLocation().y+e.getY()-initY);
			}
		});
		

		lblSexe = new JLabel("Sexe");
		lblSexe.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSexe.setBounds(10, 11, 89, 14);
		contentPane.add(lblSexe);

		cbSexe = new JComboBox<String>();
		cbSexe.setFocusable(false);
		cbSexe.setModel(new DefaultComboBoxModel<String>(new String[] { "M", "F" }));
		cbSexe.setBounds(10, 29, 39, 27);
		contentPane.add(cbSexe);

		lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPrenom.setBounds(59, 11, 89, 14);
		contentPane.add(lblPrenom);

		txtPrenom = new JTextField();
		txtPrenom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPrenom.setBounds(59, 29, 103, 27);
		contentPane.add(txtPrenom);
		txtPrenom.setColumns(10);

		JComboBox<String> cbPays = new JComboBox<String>();
		cbPays.setVisible(false);
		cbPays.setModel(new DefaultComboBoxModel<String>(new String[] { "France", "Belgique", "Suisse" }));
		cbPays.setBounds(10, 67, 86, 20);
		contentPane.add(cbPays);

		JLabel lblVille = new JLabel("Ville");
		lblVille.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblVille.setBounds(188, 11, 46, 14);
		contentPane.add(lblVille);

		TextFVille = new JTextField();
		TextFVille.setFont(new Font("Tahoma", Font.PLAIN, 13));

		TextFVille.setBounds(184, 30, 111, 26);
		contentPane.add(TextFVille);
		TextFVille.setColumns(10);

		JLabel lblCodepostale = new JLabel("CodePostale");
		lblCodepostale.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodepostale.setBounds(307, 11, 88, 14);
		contentPane.add(lblCodepostale);

		TextFCodeP = new JTextField();
		TextFCodeP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TextFCodeP.setBounds(307, 29, 89, 27);
		contentPane.add(TextFCodeP);
		TextFCodeP.setColumns(10);

		lblDepartement = new JLabel("Departement");
		lblDepartement.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDepartement.setBounds(405, 11, 89, 14);
		contentPane.add(lblDepartement);

		TextFDepartement = new JTextField();
		TextFDepartement.setFont(new Font("Tahoma", Font.PLAIN, 13));
		TextFDepartement.setBounds(406, 28, 122, 27);
		contentPane.add(TextFDepartement);
		TextFDepartement.setColumns(10);

		separator = new JSeparator();
		separator.setBounds(20, 67, 497, 2);
		contentPane.add(separator);

		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setBounds(172, 11, 2, 48);
		contentPane.add(separator2);

		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(362, 70, 89, 14);
		contentPane.add(lblDate);
		lblDate.setVisible(false);

		JComboBox<String> cbDate = new JComboBox<String>();
		cbDate.setModel(new DefaultComboBoxModel<String>(new String[] { "1789", "1916", "1918", "1939", "1945", "2016" }));
		cbDate.setBounds(456, 67, 72, 20);
		contentPane.add(cbDate);
		cbDate.setVisible(false);

		txtPane = new JTextPane();
		txtPane.setMargin(new Insets(0, 15, 5, 10));
		txtPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPane.setEditable(false);
		txtPane.setBounds(20, 119, 497, 131);
		contentPane.add(txtPane);

		JScrollPane scroll = new JScrollPane(txtPane);
		scroll.setBounds(20, 119, 497, 131);
		contentPane.add(scroll);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		AutoSuggestor autoSuggestorVille = new AutoSuggestor(TextFVille, this, null, Color.WHITE.brighter(), Color.BLUE,
				Color.RED, 0.75f) {
			@Override
			boolean wordTyped(String typedWord) {

				// create list for dictionary this in your case might be done via calling a
				// method which queries db and returns results as arraylist
				ArrayList<String> words = null;
				VilleFrDAO ville = new VilleFrDAO(Connect.getInstance());
				if (TextFDepartement.getText().isEmpty()) {
					words = ville.autoVille(TextFVille.getText());
					setDictionary(words);
					// addToDictionary("bye");//adds a single word
				}else {
					words = ville.autoVilleDep(TextFVille.getText(),TextFDepartement.getText());
					setDictionary(words);
				}
				return super.wordTyped(typedWord);// now call super to check for any matches against newest dictionary
			}
		};
		AutoSuggestor autoSuggestorPrenom = new AutoSuggestor(txtPrenom, this, null, Color.WHITE.brighter(), Color.BLUE,
				Color.RED, 0.75f) {
			@Override
			boolean wordTyped(String typedWord) {

				ArrayList<String> words;
				PrenomDAO prenoms = new PrenomDAO(Connect.getInstance());
				words = prenoms.autoPrenom(txtPrenom.getText(), cbSexe.getSelectedItem().toString());
				setDictionary(words);

				return super.wordTyped(typedWord);// now call super to check for any matches against newest dictionary
			}
		};

		JButton btnFtp = new JButton("FTP");
		btnFtp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConnectionFTP cftp = new ConnectionFTP();
				cftp.connectFTP();
				txtPane.setText(cftp.afficheFichiers());
				cftp.uploadFTP();
				txtPane.setText(cftp.afficheFichiers());
				cftp.downloadFTP();
				txtPane.setText(cftp.afficheFichiers());
				cftp.refreshFYG();
				cftp.compareFTP();
				cftp.disconnectFTP();
			}
		});
		btnFtp.setBounds(216, 80, 117, 28);
		contentPane.add(btnFtp);
		TextFVille.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					autoSuggestorVille.getAutoSuggestionPopUpWindow().setVisible(false);
					autoSuggestorPrenom.getAutoSuggestionPopUpWindow().setVisible(false);
					VilleFrDAO ville = new VilleFrDAO(Connect.getInstance());
					VilleFr villee = ville.findByVille(TextFVille.getText());
					TextFVille.setText(villee.getNomVille());
					TextFCodeP.setText(villee.getCodepost());
					if (TextFCodeP.getText().length() == (4))
						TextFCodeP.setText("0" + TextFCodeP.getText());
					TextFDepartement.setText(villee.getNumdep());
					txtPane.setText(ville.archives(villee.getNumdep()));
				}
			}
		});
		// Fonction qui "cache" laq suggestion quand on clic autre part
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				autoSuggestorVille.getAutoSuggestionPopUpWindow().setVisible(false);
				autoSuggestorPrenom.getAutoSuggestionPopUpWindow().setVisible(false);
			}
		});
		txtPrenom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (autoSuggestorPrenom.getAddedSuggestionLabels().size() != 0)
					autoSuggestorPrenom.getAutoSuggestionPopUpWindow().setVisible(true);
			}
		});
		TextFVille.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (autoSuggestorVille.getAddedSuggestionLabels().size() != 0)
					autoSuggestorVille.getAutoSuggestionPopUpWindow().setVisible(true);
			}
		});

	}
}
