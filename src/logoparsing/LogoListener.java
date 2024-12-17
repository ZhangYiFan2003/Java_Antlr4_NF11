// Generated from grammar/Logo.g4 by ANTLR 4.9.1

  package logoparsing;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LogoParser}.
 */
public interface LogoListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LogoParser#programme}.
	 * @param ctx the parse tree
	 */
	void enterProgramme(LogoParser.ProgrammeContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogoParser#programme}.
	 * @param ctx the parse tree
	 */
	void exitProgramme(LogoParser.ProgrammeContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogoParser#liste_instructions}.
	 * @param ctx the parse tree
	 */
	void enterListe_instructions(LogoParser.Liste_instructionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogoParser#liste_instructions}.
	 * @param ctx the parse tree
	 */
	void exitListe_instructions(LogoParser.Liste_instructionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogoParser#procedure}.
	 * @param ctx the parse tree
	 */
	void enterProcedure(LogoParser.ProcedureContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogoParser#procedure}.
	 * @param ctx the parse tree
	 */
	void exitProcedure(LogoParser.ProcedureContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogoParser#rends}.
	 * @param ctx the parse tree
	 */
	void enterRends(LogoParser.RendsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogoParser#rends}.
	 * @param ctx the parse tree
	 */
	void exitRends(LogoParser.RendsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LogoParser#fonction}.
	 * @param ctx the parse tree
	 */
	void enterFonction(LogoParser.FonctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LogoParser#fonction}.
	 * @param ctx the parse tree
	 */
	void exitFonction(LogoParser.FonctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code appel}
	 * labeled alternative in {@link LogoParser#appel_fonc}.
	 * @param ctx the parse tree
	 */
	void enterAppel(LogoParser.AppelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code appel}
	 * labeled alternative in {@link LogoParser#appel_fonc}.
	 * @param ctx the parse tree
	 */
	void exitAppel(LogoParser.AppelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code av}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterAv(LogoParser.AvContext ctx);
	/**
	 * Exit a parse tree produced by the {@code av}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitAv(LogoParser.AvContext ctx);
	/**
	 * Enter a parse tree produced by the {@code td}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterTd(LogoParser.TdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code td}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitTd(LogoParser.TdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tg}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterTg(LogoParser.TgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tg}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitTg(LogoParser.TgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterLc(LogoParser.LcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitLc(LogoParser.LcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterBc(LogoParser.BcContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitBc(LogoParser.BcContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ve}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterVe(LogoParser.VeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ve}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitVe(LogoParser.VeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code re}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterRe(LogoParser.ReContext ctx);
	/**
	 * Exit a parse tree produced by the {@code re}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitRe(LogoParser.ReContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fpos}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterFpos(LogoParser.FposContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fpos}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitFpos(LogoParser.FposContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fcc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterFcc(LogoParser.FccContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fcc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitFcc(LogoParser.FccContext ctx);
	/**
	 * Enter a parse tree produced by the {@code repete}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterRepete(LogoParser.RepeteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code repete}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitRepete(LogoParser.RepeteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code donne}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterDonne(LogoParser.DonneContext ctx);
	/**
	 * Exit a parse tree produced by the {@code donne}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitDonne(LogoParser.DonneContext ctx);
	/**
	 * Enter a parse tree produced by the {@code si}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterSi(LogoParser.SiContext ctx);
	/**
	 * Exit a parse tree produced by the {@code si}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitSi(LogoParser.SiContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tantque}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterTantque(LogoParser.TantqueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tantque}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitTantque(LogoParser.TantqueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fonc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void enterFonc(LogoParser.FoncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fonc}
	 * labeled alternative in {@link LogoParser#instruction}.
	 * @param ctx the parse tree
	 */
	void exitFonc(LogoParser.FoncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arule}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterArule(LogoParser.AruleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arule}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitArule(LogoParser.AruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code mult}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterMult(LogoParser.MultContext ctx);
	/**
	 * Exit a parse tree produced by the {@code mult}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitMult(LogoParser.MultContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loop}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterLoop(LogoParser.LoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loop}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitLoop(LogoParser.LoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code var}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterVar(LogoParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code var}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitVar(LogoParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exp_appel}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp_appel(LogoParser.Exp_appelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exp_appel}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp_appel(LogoParser.Exp_appelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sum}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterSum(LogoParser.SumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sum}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitSum(LogoParser.SumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code hasard}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterHasard(LogoParser.HasardContext ctx);
	/**
	 * Exit a parse tree produced by the {@code hasard}
	 * labeled alternative in {@link LogoParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitHasard(LogoParser.HasardContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inf}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterInf(LogoParser.InfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inf}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitInf(LogoParser.InfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inf_egal}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterInf_egal(LogoParser.Inf_egalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inf_egal}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitInf_egal(LogoParser.Inf_egalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sup}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterSup(LogoParser.SupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sup}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitSup(LogoParser.SupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sup_egal}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterSup_egal(LogoParser.Sup_egalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sup_egal}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitSup_egal(LogoParser.Sup_egalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code egal}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterEgal(LogoParser.EgalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code egal}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitEgal(LogoParser.EgalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code diff}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterDiff(LogoParser.DiffContext ctx);
	/**
	 * Exit a parse tree produced by the {@code diff}
	 * labeled alternative in {@link LogoParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitDiff(LogoParser.DiffContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link LogoParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterInt(LogoParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link LogoParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitInt(LogoParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parent}
	 * labeled alternative in {@link LogoParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterParent(LogoParser.ParentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parent}
	 * labeled alternative in {@link LogoParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitParent(LogoParser.ParentContext ctx);
}