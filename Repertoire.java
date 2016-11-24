package scandirvis;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Repertoire extends Noeud {
	
	private List<Noeud> enfants;

	public Repertoire(Noeud parent, File nom) {
		super(parent, nom);
		enfants = new ArrayList<Noeud>();
		getEnfants();
	}
	
	private void getEnfants() {
		for (File f : nom.listFiles()) {
			if (f.isDirectory()) 
				enfants.add(new Repertoire(this, f));
			else 
				enfants.add(new Fichier(this, f));
		}
	}
	
	public void accept (Visitor v) {
		Iterator<Noeud> i = enfants.iterator();
		v.visit(this);
		while (i.hasNext()) 
			i.next().accept(v);
	}
}
