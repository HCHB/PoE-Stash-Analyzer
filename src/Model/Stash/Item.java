package Model.Stash;

import Acquaintance.IItem;

public class Item implements IItem {

    private boolean verified;
    private int w;
    private int h;
    private String typeLine;
    private int ilvl;
    private String[] explicitMods;


    public String[] getExplicitModifiers() {
        return explicitMods;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public int getIlvl() {
        return ilvl;
    }

    public String[] getInfluences() {
        return new String[0];
    }
}
