package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.GameMap.Room;

import java.util.List;

public class TreasureRoom extends Room {

    @Override
    public String insertRoomName() {
        return "TREASURE ROOM";
    }

    @Override
    public String insertRoomDescription() {
        return "There it is, the shiny golden chest you've been looking for." +
                "But fortunately, the real treasure is the friends we made along the way.";
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
        return null;
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
