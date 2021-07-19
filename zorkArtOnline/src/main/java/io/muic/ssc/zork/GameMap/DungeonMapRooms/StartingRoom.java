package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.Entity.Weapon;
import io.muic.ssc.zork.GameMap.Room;


import java.util.ArrayList;
import java.util.List;

public class StartingRoom extends Room {

    @Override
    public String insertRoomName() {
        return "STARTING ROOM";
    }

    @Override
    public String insertRoomDescription() {
        return "You start here, noob.";
    }

    @Override
    public List<Item> insertItems() {
        List<Item> ret = new ArrayList<>();
        Weapon simpleStick = new Weapon("Simple Stick", "", 3, 0);
        ret.add(simpleStick);
        return ret;
    }

    @Override
    public List<Monster> insertMonsters() {
        return null;
    }

    @Override
    public String insertNorthRoom() {
        return "HALLWAY SECTION 1";
    }

    @Override
    public String insertEastRoom() {
        return null;
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
