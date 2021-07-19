package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.GameMap.Room;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hallway2 extends Room {

    @Override
    public String insertRoomName() {
        return "HALLWAY SECTION 2";
    }

    @Override
    public String insertRoomDescription() {
        return "The hallway seems to continue, you'll never know what lies at the end.";
    }

    @Override
    public List<Item> insertItems() {
        return null;
    }

    @Override
    public List<Monster> insertMonsters() {
        List<Monster> ret = Arrays.asList(
                            new Monster("Undead Knight 1",20, 10, 5 ),
                            new Monster("Undead Knight 2", 20, 10, 5)
        );
        return ret;
    }

    @Override
    public String insertNorthRoom() {
        return null;
    }

    @Override
    public String insertEastRoom() {
        return "HALLWAY SECTION 3";
    }

    @Override
    public String insertWestRoom() {
        return "HALLWAY SECTION 1";
    }

    @Override
    public String insertSouthRoom() {
        return null;
    }
}
