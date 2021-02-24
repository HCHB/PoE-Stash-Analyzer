package Acquaintance;

public interface ILogicFacade {
    void injectModel(IModelFacade model);

    void initialize();

    String analyzeForFun();
}
