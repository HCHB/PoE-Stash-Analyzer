package Logic;

import Acquantance.ILogicFacade;
import Acquantance.IModelFacade;

public class LogicFacade implements ILogicFacade {

    private IModelFacade model;

    public LogicFacade() {
        System.out.println("Creating logic facade");
    }

    @Override
    public void injectModel(IModelFacade model) {
        this.model = model;
    }
}
