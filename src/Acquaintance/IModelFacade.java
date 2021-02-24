package Acquaintance;

import java.util.List;

public interface IModelFacade {
    List<IItem> getStashContent(int[] salesTabs);

    List<IItem> getStashContent(String[] tabs);

    ISettings getInitialSettings();

}
