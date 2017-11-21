package scandirvis;

public class TrouveFichier implements Visitor{

	String nomRecherche;
	int compteur;
	
	public TrouveFichier(String nr) {
		nomRecherche = nr;
	}
	
	@Override
	public void visit(Fichier fichier) {
		if (fichier.nom.toString().contains(nomRecherche)) compteur++;	
	}

	@Override
	public void visit(Repertoire repertoire) {		
	}
	
	public int getCompteur() { return compteur; }

}
