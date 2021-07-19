package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.Entity.Weapon;
import io.muic.ssc.zork.GameMap.Room;

import java.util.ArrayList;
import java.util.List;

public class StorageRoom extends Room {

    @Override
    public String insertRoomName() {
        return "STORAGE ROOM";
    }

    @Override
    public String insertRoomDescription() {
        return "there's a candlestick, 2-3 sleeping bags, and probably some stuff to eat.";
    }

    @Override
    public List<Item> insertItems() {
        List<Item> ret = new ArrayList<>();
        Weapon ironSword = new Weapon("Iron Sword", "", 3, 4);
        Weapon vikingAxe = new Weapon("Viking Axe", "", 5, 2);
        ret.add(ironSword);
        ret.add(vikingAxe);
        return ret;
    }

    @Override
    public List<Monster> insertMonsters() {
        return null;
    }

    @Override
    public String insertNorthRoom() {
        return null;
    }

    @Override
    public String insertEastRoom() {
        return "HALLWAY SECTION 1";
    }

    @Override
    public String insertWestRoom() {
        return null;
    }

    @Override
    public String insertSouthRoom() {
        return null;
    }
}
