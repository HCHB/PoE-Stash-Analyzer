package Glue;

import Acquaintance.IGUIFacade;
import Acquaintance.ILogicFacade;
import Acquaintance.IModelFacade;
import GUI.GUIFacade;
import Logic.LogicFacade;
import Model.ModelFacade;


public class Glue {

    // Main method
    public static void main(String[] args) {
        // Create data facade.
        IModelFacade model = new ModelFacade();

        // Create logic facade.
        ILogicFacade logic = new LogicFacade();

        // Create GUI facade.
        IGUIFacade gui = (IGUIFacade) GUIFacade.getInstance();

        // Inject logic into GUI.
        gui.injectLogic(logic);

        // Inject data into logic.
        logic.injectModel(model);

        initialize(gui, logic, model);

        // Start application
        gui.startApplication(args);
    }

    private static void initialize(IGUIFacade gui, ILogicFacade logic, IModelFacade model){
        System.out.println("Initializing Program");

    }

}
