package scandirvis;

import java.io.File;

public class Fichier extends Noeud {
	
	public Fichier(File nom) {
		super(nom);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
}
