package Glue;

import Acquantance.IGUIFacade;
import Acquantance.ILogicFacade;
import Acquantance.IModelFacade;
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
        IGUIFacade GUI = new GUIFacade();

        // Inject logic into GUI.
        GUI.injectLogic(logic);

        // Inject data into logic.
        logic.injectModel(model);

        initialize(GUI, logic, model);

        // Start application
        GUI.startApplication(args);
    }

    private static void initialize(IGUIFacade GUI, ILogicFacade logic, IModelFacade model){
        System.out.println("Initializing Program");
    }
}
