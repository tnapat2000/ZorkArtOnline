package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.GameMap.Room;

import java.util.List;

public class Hallway3 extends Room {
    @Override
    public String insertRoomName() {
        return "HALLWAY SECTION 3";
    }

    @Override
    public String insertRoomDescription() {
        return "Fortunately, this is the ends of the hallway.";
    }

    @Override
    public List<Item> insertItems() {
        return null;
    }

    @Override
    public List<Monster> insertMonsters() {
        return null;
    }

    @Override
    public String insertNorthRoom() {
        return "BONFIRE ROOM";
    }

    @Override
    public String insertEastRoom() {
        return null;
    }

    @Override
    public String insertWestRoom() {
        return "HALLWAY SECTION 2";
    }

    @Override
    public String insertSouthRoom() {
        return null;
    }
}
