package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.GameMap.Room;

import java.util.ArrayList;
import java.util.List;

public class Hallway1 extends Room {

    @Override
    public String insertRoomName() {
        return "HALLWAY SECTION 1";
    }

    @Override
    public String insertRoomDescription() {
        return "You see a long, and probably ominous, hallway.";
    }

    @Override
    public List<Item> insertItems() {
        return null;
    }

    @Override
    public List<Monster> insertMonsters() {
        List<Monster> ret = new ArrayList<>();
        Monster skeleton = new Monster("Skeleton", 15, 8, 3);
        ret.add(skeleton);
        return ret;
    }

    @Override
    public String insertNorthRoom() {
        return null;
    }

    @Override
    public String insertEastRoom() {
        return "HALLWAY SECTION 2";
    }

    @Override
    public String insertWestRoom() {
        return "STORAGE ROOM";
    }

    @Override
    public String insertSouthRoom() {
        return "STARTING ROOM";
    }
}
