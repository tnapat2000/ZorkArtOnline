package io.muic.ssc.zork.Entity;

import io.muic.ssc.zork.GameMap.Room;

public class Item{

    protected String itemName;

    protected String itemDescription;

    public Item(String itemName, String itemDescription){
        this.itemName = itemName;
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}