package Model;

import Acquaintance.IItem;
import Acquaintance.IModelFacade;
import Acquaintance.ISettings;
import Model.ItemData.ItemDataFacade;
import Model.Settings.SettingsFacade;
import Model.Stash.StashFacade;

import java.util.List;

public class ModelFacade implements IModelFacade {

    private final StashFacade stashFacade;
    private final SettingsFacade settingsFacade;
    private final ItemDataFacade ItemDataFacade;

    public ModelFacade() {
        System.out.println("Creating model facade");

        this.stashFacade = new StashFacade();
        this.settingsFacade = new SettingsFacade();
        this.ItemDataFacade = new ItemDataFacade();
    }

    @Override
    public List<IItem> getStashContent(int[] tabs) {
        return stashFacade.getContent(tabs);
    }

    @Override
    public List<IItem> getStashContent(String[] tabs){
        return stashFacade.getContent(tabs);
    }

    @Override
    public ISettings getInitialSettings() {
        return null;
    }


}
