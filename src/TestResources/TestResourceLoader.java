package TestResources;

import Model.Stash.Item;
import Model.Stash.Stash;
import Model.Stash.Tab;
import com.google.gson.Gson;

import java.io.*;

public class TestResourceLoader {

    private static String tabsStashPath = "src/TestResources/Tabs.json";
    private static String itemsStashPath = "src/TestResources/Items.json";

    public static Item[] getTestItems() throws FileNotFoundException {
        Gson jsonReader = new Gson();

        BufferedReader reader = new BufferedReader(new FileReader(tabsStashPath));
        Item[] items = jsonReader.fromJson(reader, Stash.class).getItems();

        return items;
    }

    public static Tab[] getTestTabs() throws FileNotFoundException {
        Gson jsonReader = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(itemsStashPath));
        Tab[] tabs = jsonReader.fromJson(reader, Stash.class).getTabs();

        return tabs;
    }

    public static Stash getTestStash() throws FileNotFoundException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(itemsStashPath));
        Stash stash = gson.fromJson(reader, Stash.class);

        return stash;
    }
}
