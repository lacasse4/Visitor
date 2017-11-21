package scandirvis;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Exemple du parton Visiteur
 * @author Vincent Lacasse
 *
 */
public class TestVisitor extends JFrame {

	private JButton btnChoisir;
	private JButton btnFermer;
	private JTextArea txtrResultat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestVisitor frame = new TestVisitor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructeur
	 * construire l'écran principal et assigner des actions 
	 * aux deux boutons
	 */
	public TestVisitor() {

		buildScreen();

		btnChoisir.setAction(new ActionChoisir());
		btnFermer.setAction(new ActionFermer());
	}

	/**
	 * Construire l'écran principal
	 */
	private void buildScreen() {
		JPanel contentPane;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnChoisir = new JButton();
		panel.add(btnChoisir);

		btnFermer = new JButton();
		panel.add(btnFermer);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		txtrResultat = new JTextArea();
		scrollPane.setViewportView(txtrResultat);		
	}

	/**
	 * Action assignee au bouton "Choisir"
	 * @author Vincent Lacasse
	 *
	 */
	private class ActionChoisir extends AbstractAction {	
		ActionChoisir() {
			super("Choisir");
		}

		public void actionPerformed(ActionEvent e) {
			int returnVal;
			File nom;

			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			returnVal = fileChooser.showOpenDialog(null);

			if (returnVal == JFileChooser.APPROVE_OPTION) {   
				nom = new File(fileChooser.getSelectedFile().getPath());

				// Créer l'arbre contenant la structure de répertoire
				// Utilisation du patron Composite
				Noeud base = new Repertoire(nom);

				// Créer le visiteur, exécuter le visiteur et afficher le resultat
				CompteRepertoire cv = new CompteRepertoire();
				base.accept(cv);
				txtrResultat.setText("Nombre de réperoire = " + cv.getCompteur());			    	

//				// Créer le visiteur, exécuter le visiteur et afficher le resultat
//				TrouveFichier tf = new TrouveFichier("fichier4.rtf");
//				base.accept(tf);
//				txtrResultat.setText("Nombre de fichier = " + tf.getCompteur());			    	

			}
		}
	}

	/**
	 * Action assignee au bouton "Fermer"
	 * @author Vincent Lacasse
	 *
	 */
	private class ActionFermer extends AbstractAction {
		ActionFermer() {
			super("Fermer");
		}
		
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
}