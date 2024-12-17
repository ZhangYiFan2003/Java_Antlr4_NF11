package logomodel;

import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.util.Pair;
import logogui.Traceur;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import logoparsing.LogoBaseVisitor;
import logoparsing.LogoParser.AppelContext;
import logoparsing.LogoParser.AruleContext;
import logoparsing.LogoParser.AvContext;
import logoparsing.LogoParser.BcContext;
import logoparsing.LogoParser.DiffContext;
import logoparsing.LogoParser.DonneContext;
import logoparsing.LogoParser.EgalContext;
import logoparsing.LogoParser.Exp_appelContext;
import logoparsing.LogoParser.FccContext;
//import logoparsing.LogoParser.FloatContext;
import logoparsing.LogoParser.FonctionContext;
import logoparsing.LogoParser.FposContext;
import logoparsing.LogoParser.HasardContext;
import logoparsing.LogoParser.InfContext;
import logoparsing.LogoParser.Inf_egalContext;
import logoparsing.LogoParser.IntContext;
import logoparsing.LogoParser.LcContext;
import logoparsing.LogoParser.LoopContext;
import logoparsing.LogoParser.MultContext;
import logoparsing.LogoParser.ParentContext;
import logoparsing.LogoParser.ProcedureContext;
import logoparsing.LogoParser.ReContext;
import logoparsing.LogoParser.RendsContext;
import logoparsing.LogoParser.RepeteContext;
import logoparsing.LogoParser.SiContext;
import logoparsing.LogoParser.SumContext;
import logoparsing.LogoParser.SupContext;
import logoparsing.LogoParser.Sup_egalContext;
import logoparsing.LogoParser.TantqueContext;
import logoparsing.LogoParser.TdContext;
import logoparsing.LogoParser.TgContext;
import logoparsing.LogoParser.VarContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class LogoTreeVisitor extends LogoStoppableTreeVisitor {
	Traceur traceur;
	Log log;

	public LogoTreeVisitor() {
		super();
		log = new Log();
		traceur = new Traceur();
		//traceur.setGraphics(g);
		symbol_stack.push(tableSym);
	}
	
    public StringProperty logProperty() {
    	return log;
    }
    
	public Traceur getTraceur() {
		return traceur;
	}
	
	ParseTreeProperty<Integer> atts = new ParseTreeProperty<Integer>();
	private List<Integer> loopIndex = new ArrayList<>();
	
	private SymbolTable tableSym = new SymbolTable();
	private ProcTable tableProc = new ProcTable();
	private FoncTable tableFonc = new FoncTable();
    private Stack<SymbolTable> symbol_stack= new Stack<SymbolTable>();
	
	public void setValue(ParseTree node, int value) { 
		atts.put(node, value);
	}
		
	public Integer getValue(ParseTree node) {
		Integer value = atts.get(node);
		if (value == null) {
			throw new NullPointerException();
		}
		return value;
	}
	
	@Override
	public Integer visitAv(AvContext ctx) {
	    visitChildren(ctx);
	    int distance = getValue(ctx.exp());  
	    traceur.avance(distance);
	    log.appendLog("Advanced " + distance + " units.");  
	    return 0;
	}
	@Override
	public Integer visitRe(ReContext ctx) {
	    visitChildren(ctx);
	    int distance = getValue(ctx.exp());  
	    traceur.re(distance);
	    log.appendLog("Reversed " + distance + " units.");  
	    return 0;
	}
	@Override
	public Integer visitTd(TdContext ctx) {
	    visitChildren(ctx);
	    int degrees = getValue(ctx.exp());  
	    traceur.td(degrees);
	    log.appendLog("Turned right " + degrees + " degrees.");  
	    return 0;
	}
	@Override
	public Integer visitTg(TgContext ctx) {
	    visitChildren(ctx);
	    int degrees = getValue(ctx.exp());  
	    traceur.tg(degrees);
	    log.appendLog("Turned left " + degrees + " degrees.");  
	    return 0;
	}
	@Override
	public Integer visitLc(LcContext ctx) {
		visitChildren(ctx);
		traceur.lc();
		log.appendLog("visitLc\n" );
		return 0;
	}
	@Override
	public Integer visitBc(BcContext ctx) {
		visitChildren(ctx);
		traceur.bc();
		log.appendLog("visitBc\n" );
		return 0;
	}
	@Override
	public Integer visitFpos(FposContext ctx) {
	    visitChildren(ctx);

	    int x = getValue(ctx.exp().get(0));
	    int y = getValue(ctx.exp().get(1));

	    traceur.fpos(x, y);

	    log.appendLog("Moved to position (" + x + ", " + y + ").");

	    return 0;
	}
	@Override
	public Integer visitFcc(FccContext ctx) {
	    visitChildren(ctx);
	    int colorCode = getValue(ctx.exp());
	    traceur.fcc(colorCode);  
	    String colorName = getColorName(colorCode % 8); 
	    log.appendLog("Changed pen color to " + colorName); 
	    return 0;
	}
	private String getColorName(int colorCode) {
	    switch (colorCode) {
	        case 0: return "Black";
	        case 1: return "Red";
	        case 2: return "Green";
	        case 3: return "Yellow";
	        case 4: return "Blue";
	        case 5: return "Purple";
	        case 6: return "Light Blue";
	        case 7: return "White";
	        default: return "Unknown Color";
	    }
	}
	
	@Override
	public Integer visitArule(AruleContext ctx) {
		visit(ctx.atom());
		setValue(ctx, getValue(ctx.atom()));
		return 0;
	}
	@Override
	public Integer visitMult(MultContext ctx) {
		visitChildren(ctx);
		Double left = (double) getValue(ctx.exp(0));
		Double right = (double) getValue(ctx.exp(1));
		setValue(ctx, (ctx.getChild(1).getText().equals("*") ? 
				(int)(left * right) : (int)(left / (right == 0 ? 1 : right))));
		return 0;
	}
	@Override
	public Integer visitSum(SumContext ctx) {
		visitChildren(ctx);
		Double left = (double) getValue(ctx.exp(0));
		Double right = (double) getValue(ctx.exp(1));
		setValue(ctx, (ctx.getChild(1).getText().equals("+") ? 
				(int)(left + right) : (int)(left - right)));
		return 0;
	}
	@Override
	public Integer visitInt(IntContext ctx) {
		String intText = ctx.INT().getText();
		setValue(ctx, Integer.valueOf(intText));
		return 0;
	}
	
	/*@Override
	public Integer visitFloat(FloatContext ctx) {
		String floatText = ctx.FLOAT().getText();
		setValue(ctx, Double.valueOf(floatText));
		return 0;
	}*/
	
	@Override
	public Integer visitParent(ParentContext ctx) {
		visit(ctx.exp());
		setValue(ctx, getValue(ctx.exp()));
		return 0;
	}
	@Override
	public Integer visitHasard(HasardContext ctx) {
		visit(ctx.exp());
		Random rand = new Random();
		int min = 1;
		int max = getValue(ctx.exp());
		
		int randomNum = rand.nextInt((max - min) + 1) + min;
		setValue(ctx, randomNum);
		return 0;
	}
	@Override
	public Integer visitRepete(RepeteContext ctx) {
		visit(ctx.exp());
		int n = getValue(ctx.exp());
		
		int index = loopIndex.size();
        loopIndex.add(1);
        for (int i = 0; i < n; i++) {
            visit(ctx.liste_instructions());
            loopIndex.set(index, loopIndex.get(index) + 1);
        }
        loopIndex.remove(loopIndex.size() - 1);
		return 0;
	}
	@Override
	public Integer visitLoop(LoopContext ctx) {
	    // Obtenez le nombre d'itérations actuel de la boucle, en supposant 
		// qu'elle commence à compter à partir de 1.
	    int currentIteration = loopIndex.get(loopIndex.size() - 1);

	    setValue(ctx, currentIteration);

	    log.appendLog("Currently in loop iteration: " + currentIteration);

	    return 0;
	}
	@Override
	public Integer visitInf(InfContext ctx) {
		visit(ctx.exp(0));
		visit(ctx.exp(1));
		
		int gauche = getValue(ctx.exp(0));
		int droite = getValue(ctx.exp(1));
		int result = (gauche < droite)? 1 : 0;
		
		
		log.appendLog("Comparing " + gauche + " < " + droite + 
				       ": " + (result == 1 ? "true" : "false"));
		setValue(ctx, result);
		return 0;
	}
	@Override
	public Integer visitInf_egal(Inf_egalContext ctx) {
		visit(ctx.exp(0));
		visit(ctx.exp(1));
		
		int gauche = getValue(ctx.exp(0));
		int droite = getValue(ctx.exp(1));
		int result = (gauche <= droite)? 1 : 0;
		
		log.appendLog("Comparing " + gauche + " <= " + droite + 
				       ": " + (result == 1 ? "true" : "false"));
		setValue(ctx, result);
		return 0;
	}
	@Override
	public Integer visitSup(SupContext ctx) {
		visit(ctx.exp(0));
		visit(ctx.exp(1));
		
		int gauche = getValue(ctx.exp(0));
		int droite = getValue(ctx.exp(1));
		int result = (gauche > droite)? 1 : 0;
		
		log.appendLog("Comparing " + gauche + " > " + droite + 
				       ": " + (result == 1 ? "true" : "false"));
		setValue(ctx, result);
		return 0;
	}
	@Override
	public Integer visitSup_egal(Sup_egalContext ctx) {
		visit(ctx.exp(0));
		visit(ctx.exp(1));
		
		int gauche = getValue(ctx.exp(0));
		int droite = getValue(ctx.exp(1));
		int result = (gauche >= droite)? 1 : 0;
		
		log.appendLog("Comparing " + gauche + " >= " + droite + 
				       ": " + (result == 1 ? "true" : "false"));
		setValue(ctx, result);
		return 0;
	}
	@Override
	public Integer visitEgal(EgalContext ctx) {
		visit(ctx.exp(0));
		visit(ctx.exp(1));
		
		int gauche = getValue(ctx.exp(0));
		int droite = getValue(ctx.exp(1));
		int result = (gauche == droite)? 1 : 0;
		
		log.appendLog("Comparing " + gauche + " == " + droite + 
				       ": " + (result == 1 ? "true" : "false"));
		setValue(ctx, result);
		return 0;
	}
	@Override
	public Integer visitDiff(DiffContext ctx) {
		visit(ctx.exp(0));
		visit(ctx.exp(1));
		
		int gauche = getValue(ctx.exp(0));
		int droite = getValue(ctx.exp(1));
		int result = (gauche != droite)? 1 : 0;
		
		log.appendLog("Comparing " + gauche + " != " + droite + 
				       ": " + (result == 1 ? "true" : "false"));
		setValue(ctx, result);
		return 0;
	}
	@Override	
	public Integer visitDonne(DonneContext ctx) {
	    // Traitez d'abord l'expression et obtenez la valeur.
	    visit(ctx.exp());
	    Integer value = getValue(ctx.exp());

	    // Vérifiez si la pile est vide pour éviter une EmptyStackException.
	    if (symbol_stack.isEmpty()) {
	        throw new RuntimeException("Error: Trying to assign a value "
	        		                    + "with an empty symbol stack.");
	    }

	    // Utilisez la valeur obtenue pour effectuer une opération d'assignation.
	    symbol_stack.peek().donne(ctx.ID().getText(), value);

	    // Enregistrez un journal, calculez la valeur de l'expression une seule fois.
	    log.appendLog("visitDonne : " + ctx.ID().getText() + " <- " + value);

	    return 0;
	}
	@Override
	public Integer visitVar(VarContext ctx) {
	    // Récupérez la valeur de la variable à partir de 
		// la table des symboles au sommet de la pile.
	    Integer value = symbol_stack.peek().getSymbol(ctx.ID().getText());
	    
	    // Définissez la valeur de la variable comme une propriété du contexte.
	    setValue(ctx, value);

	    log.appendLog("Visite variable '" + ctx.ID().getText() 
	    		       + "' avec valeur: " + value);

	    return 0;
	}
	@Override
	public Integer visitSi(SiContext ctx) {
		visit(ctx.condition());
		
		int resultCondition = getValue(ctx.condition());
		if(resultCondition == 1) {
				visit(ctx.liste_instructions(0));
		}
		else {
			if(ctx.liste_instructions().size() > 1) {
				visit(ctx.liste_instructions(1));
			}
		}
		return 0;
	}
	@Override
	public Integer visitTantque(TantqueContext ctx) {
		// Accédez et évaluez la condition de la boucle.
		visit(ctx.condition());
		int condition = getValue(ctx.condition());
		 while (condition == 1) {
			visit(ctx.liste_instructions());
			// Réévaluez la condition après chaque itération de la boucle.
			visit(ctx.condition());
			condition = getValue(ctx.condition());
		}
		return 0;
	}
	@Override
	public Integer visitProcedure(ProcedureContext ctx) {
		String nom = ctx.ID(0).getText();
		List<String> parametres = new ArrayList<String>();
		
		// Collectez tous les paramètres du processus.
		for (int i=1 ; i<ctx.ID().size() ; i++){
			parametres.add(ctx.ID(i).getText());
		}
		
		// Obtenez la liste des instructions du corps du processus.
		ParseTree tree = ctx.liste_instructions();
		
		// Créez une instance de processus et ajoutez-la à la table des processus.
		Procedure proc = new Procedure(nom, parametres, tree);
		tableProc.donne(nom, proc);

		log.appendLog("visitProcedure : " + nom );
	    

		return 0;
	}
	
	@Override
	public Integer visitFonction(FonctionContext ctx) {
		String nom = ctx.ID(0).getText();
		List<String> parametres = new ArrayList<String>();
		
		// Collectez tous les paramètres de la fonction.
		for (int i=1 ; i<ctx.ID().size() ; i++){
			parametres.add(ctx.ID(i).getText());
		}
		
		// Obtenez la liste des instructions du corps de la fonction, y compris l'instruction de retour.
		ParseTree tree = ctx.liste_instructions();
		
		// Créez une instance de fonction et ajoutez-la à la table des fonctions.
		Fonction fonc = new Fonction(nom, parametres, tree, ctx.rends());
		tableFonc.donne(nom, fonc);
		
		log.appendLog("visitFonction : " + nom );

		return 0;
	}
	
	@Override
	public Integer visitAppel(AppelContext ctx) {
		// Créer une nouvelle table des symboles locale
	    SymbolTable local_symtab = new SymbolTable();
	    int i = 0;
	    // Obtenez le nombre de paramètres fournis lors de l'appel
	    int n_args_donnes = ctx.exp().size();  

	    // Essayer de récupérer la définition de la procédure dans la table des procédures
	    Procedure proc = tableProc.getSymbol(ctx.ID().getText());
	    if (proc == null) {  // Si la procédure n'est pas trouvée
	    	// Essayer de récupérer la définition de la fonction dans la table des fonctions
	        Fonction fonc = tableFonc.getSymbol(ctx.ID().getText());
	        if (fonc == null) {  // Si la fonction n'existe pas non plus
	            return -1;  // Retourner un code d'erreur
	        }

	        // Traiter l'appel de fonction
	        int n_args = fonc.getParametre().size();
	        // Vérifier si le nombre de paramètres est correct
	        if (n_args_donnes < n_args) {  
	            log.appendLog("nombre incorrect d'arguments");
	            return -1;
	        }

	        // Créer une variable locale pour chaque paramètre et lui assigner une valeur
	        for (i = 0; i < n_args; i++) {
	            visit(ctx.exp(i));
	            local_symtab.donne(fonc.getParametre().get(i), getValue(ctx.exp(i)));
	        }

	        // Pousser la table des symboles locale dans la pile
	        symbol_stack.push(local_symtab);

	        // Si un ensemble d'instructions est présent, exécuter cet ensemble
	        if (fonc.getInstructions() != null) {
	            visit(fonc.getInstructions());
	        }

	        // Exécuter l'expression de retour et obtenir la valeur de retour
	        visit(fonc.getRetour());
	        int val = getValue(fonc.getRetour());

	        log.appendLog("retour : " + val);

	        // Définir la valeur de retour de la fonction comme propriété du contexte actuel
	        setValue(ctx, val);
	    } 
	    // Si une procédure est trouvée
	    else {  
	    	// Traiter l'appel de la procédure de manière similaire à l'appel de fonction
	        int n_args = proc.getParametre().size();
	        if (n_args_donnes < n_args) {
	            log.appendLog("nombre incorrect d'arguments");
	            return -1;
	        }

	        for (i = 0; i < n_args; i++) {
	            visit(ctx.exp(i));
	            local_symtab.donne(proc.getParametre().get(i), getValue(ctx.exp(i)));
	        }

	        // Pousser la table des symboles locale dans la pile
	        symbol_stack.push(local_symtab);

	        // Exécuter l'ensemble d'instructions de la procédure
	        if (proc.getInstructions() != null) {
	            visit(proc.getInstructions());
	        }
	    }

	    // Une fois terminé, retirer la table des symboles locale de la pile
	    symbol_stack.pop();

	    log.appendLog("visitAppel:" + ctx.ID().getText());
	    return 0;
	}

	
	@Override
	public Integer visitRends(RendsContext ctx) {
		
		visitChildren(ctx);
		int val = getValue(ctx.exp());
		setValue(ctx, val);
		log.appendLog("rends " + val);
		return val;
	}
	
	@Override
	public Integer visitExp_appel(Exp_appelContext ctx) {
		visit(ctx.appel_fonc());
		// Obtenir la valeur retournée par l'appel de la fonction ou de la procédure
		int val = getValue(ctx.appel_fonc());
		setValue(ctx, val);
		
		log.appendLog("exp_appel : " + val);
		
		return 0;
	}	
	
	/*private Pair<Integer, Double> evaluate(ParseTree expr) {
		int b = visit(expr);
		Double val = b == 0 ? getValue(expr) : Double.POSITIVE_INFINITY;
		return new Pair<Integer, Double>(b, val);
	}*/
	
}


