package Model.Stash;

import Acquaintance.IItem;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StashFacade {

    private StashAPI api;
    private Gson jsonReader;

    public StashFacade(){
        this.api = new StashAPI();
        this.jsonReader = new Gson();
    }

    public List<IItem> getContent(int[] tabs) {
        List<IItem> itemList = new ArrayList<>();

        for (int tab : tabs) {
            String stashString = this.api.getTab(tab);
            Stash stash = this.jsonReader.fromJson(stashString, Stash.class);
            itemList.addAll(Arrays.asList(stash.getItems()));
        }

        return itemList;
    }

    public List<IItem> getContent(String[] tabs){
        List<IItem> itemList = new ArrayList<>();
        Set<String> tabSet = Set.of(tabs);

        String tabInfoString = this.api.getTabInfo();

        Tab[] tabsInfo = this.jsonReader.fromJson(tabInfoString, Stash.class).getTabs();

        for (Tab tab : tabsInfo) {
            if (tabSet.contains(tab.getName())) {
                String stashString = this.api.getTab(tab.getIndex());
                Stash stash = this.jsonReader.fromJson(stashString, Stash.class);
                itemList.addAll(Arrays.asList(stash.getItems()));
            }
        }

        return itemList;
    }
}
