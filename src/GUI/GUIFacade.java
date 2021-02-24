package GUI;

import Acquaintance.IGUIFacade;
import Acquaintance.ILogicFacade;

public class GUIFacade implements IGUIFacade, IOutFacade {

    private static GUIFacade instance;

    private ILogicFacade logic;

    private GUIFacade() {
        System.out.println("Creating GUI facade");
    }

    public static IOutFacade getInstance(){
        if (instance == null){
            instance = new GUIFacade();
        }

        return instance;
    }

    @Override
    public void startApplication(String[] args) {
        Main.main(args);
    }

    @Override
    public void injectLogic(ILogicFacade logic) {
        this.logic = logic;
    }

    @Override
    public String getAnalysis() {
        return this.logic.analyzeForFun();
    }

    @Override
    public void activateAnalyzer(){

    }

}
