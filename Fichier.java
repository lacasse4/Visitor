package scandirvis;

import java.io.File;

public class Fichier extends Noeud {
	
	public Fichier(Noeud parent, File nom) {
		super(parent, nom);
	}
	
	public void accept(Visitor v) {
		v.visit(this);
	}
	
	public String toString() {
		return nom.toString();
	}
}
