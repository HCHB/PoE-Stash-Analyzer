package Model.Stash;

public class Stash {

    private int numTabs;
    private Tab[] tabs;
    private Item[] items;

    public Tab[] getTabs() {
        return tabs;
    }

    public Item[] getItems() {
        return items;
    }

    public int getNumTabs() {
        return numTabs;
    }
}
