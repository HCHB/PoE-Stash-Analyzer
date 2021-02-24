package Logic;

import Acquaintance.*;
import Logic.IdentifyAnalyzer.IdentityAnalyzerFacade;
import Logic.RareAnalyzer.RareAnalyzerFacade;
import Logic.RecipeAnalyzer.RecipeAnalyzerFacade;
import Logic.SalesDeprecationAnalyzer.SalesDeprecationAnalyzerFacade;

public class LogicFacade implements ILogicFacade {

    private int[] salesTabs;
    private IModelFacade model;

    private IdentityAnalyzerFacade identifyAnalyzer;
    private RareAnalyzerFacade rareAnalyzer;
    private RecipeAnalyzerFacade recipieAnalyzer;
    private SalesDeprecationAnalyzerFacade salesAnalyzer;


    private int[] activeTabs;

    private int number = 0;


    public LogicFacade() {
        System.out.println("Creating logic facade");

        this.identifyAnalyzer = new IdentityAnalyzerFacade();
        this.rareAnalyzer = new RareAnalyzerFacade();
        this.recipieAnalyzer = new RecipeAnalyzerFacade();
        this.salesAnalyzer = new SalesDeprecationAnalyzerFacade();
    }

    @Override
    public void injectModel(IModelFacade model) {
        this.model = model;
    }

    @Override
    public void initialize(){
        ISettings initialSettings = this.model.getInitialSettings();

        this.activeTabs = initialSettings.activeTabs();
        this.salesTabs = initialSettings.salesTabs();
    }

    @Override
    public String analyzeForFun() {
        this.number++;

        return "This is resultset " + this.number;
    }

    public AnalysisResults analyzeStash(){
        //TODO
//        IItem[] stash = this.model.getStashContent(this.activeTabs);
//
//        IItem[] identifyItems = this.identifyAnalyzer.analyze(stash);
//        IItem[] rareItems = this.rareAnalyzer.analyze(stash);
//        List<IItem[]> recipieSets = this.recipieAnalyzer.analyze(stash);
//
//        AnalysisResults results = new AnalysisResults(identifyItems, rareItems, recipieSets);
//
//        return results;
        return null;
    }

    public IItem[] analyzeSales(){
        //TODO
//        IItem[] stash = this.model.getStashContent(this.salesTabs);
//
//        return this.salesAnalyzer.analyze(stash);
        return new IItem[0];
    }

    public boolean activateAnalyzer(AnalyzerEnum analyzer, boolean activate){
        switch (analyzer){
            case IDENTIFY:
                this.identifyAnalyzer.activate(activate);
                break;
            case RARE:
                this.rareAnalyzer.activate(activate);
                break;
            case RECIPIE:
                this.recipieAnalyzer.activate(activate);
                break;
            default:
                return false;
        }

        return true;
    }
}
