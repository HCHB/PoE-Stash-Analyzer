package Acquaintance;

public interface IGUIFacade {
    void startApplication(String[] args);

    void injectLogic(ILogicFacade logic);
}
