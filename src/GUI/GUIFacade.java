package GUI;

import Acquantance.IGUIFacade;
import Acquantance.ILogicFacade;

public class GUIFacade implements IGUIFacade {

    private ILogicFacade logic;

    public GUIFacade() {
        System.out.println("Creating GUI facade");
    }

    @Override
    public void startApplication(String[] args) {
        Main.main(args);
    }

    @Override
    public void injectLogic(ILogicFacade logic) {
        this.logic = logic;
    }
}
