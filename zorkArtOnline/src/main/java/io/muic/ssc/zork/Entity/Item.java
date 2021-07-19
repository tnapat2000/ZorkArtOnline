package io.muic.ssc.zork.Entity;


public class Item{

    protected String itemName;

    protected String itemDescription;

    public Item(String itemName, String itemDescription){
        this.itemName = itemName.toLowerCase();
        this.itemDescription = itemDescription;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }
}