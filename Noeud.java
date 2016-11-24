package scandirvis;

import java.io.File;

public abstract class Noeud {
	
	Noeud parent;
	File nom;
	
	public Noeud(Noeud parent, File nom) {
		this.parent = parent;
		this.nom = nom;
	}
	
	public abstract void accept(Visitor v);
}