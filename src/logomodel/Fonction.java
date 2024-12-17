package logomodel;

import java.util.ArrayList;
import java.util.List;

import logoparsing.LogoParser.RendsContext;

import org.antlr.v4.runtime.tree.ParseTree;

public class Fonction {
	public String nom;
	public List<String> parametres;
	public ParseTree tree;
	public RendsContext retour;
	
	public Fonction(String n, List<String> para, ParseTree instructions, RendsContext r)
	{		
		nom = n;
		parametres = para;
		tree = instructions;
		retour = r;
	}

	public ParseTree getInstructions()
	{
		return tree;
	}
	
	public RendsContext getRetour()
	{
		return retour;
	}
	
	
	public List<String> getParametre()
	{
		return parametres;
	}

	public String getNom() {
		return nom;
	}


}
