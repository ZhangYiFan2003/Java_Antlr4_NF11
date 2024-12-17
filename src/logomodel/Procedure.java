package logomodel;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

public class Procedure {
	public String nom;
	public List<String> parametres;
	public ParseTree tree;
	
	public Procedure(String n, List<String> para, ParseTree instructions)
	{		
		nom = n;
		parametres = para;
		tree = instructions;
	}

	public ParseTree getInstructions()
	{
		return tree;
	}
	
	
	public List<String> getParametre()
	{
		return parametres;
	}

	public String getNom() {
		return nom;
	}


}
