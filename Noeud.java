package scandirvis;

import java.io.File;

public abstract class Noeud {
	
	File nom;
	
	public Noeud(File nom) {
		this.nom = nom;
	}
	
	public abstract void accept(Visitor v);
}