package io.muic.ssc.zork.GameMap.DungeonMapRooms;

import io.muic.ssc.zork.Entity.Item;
import io.muic.ssc.zork.Entity.Monster;
import io.muic.ssc.zork.GameMap.Room;

import java.util.List;

public class SpiralStair extends Room {

    @Override
    public String insertRoomName() {
        return "SPIRAL STAIR";
    }

    @Override
    public String insertRoomDescription() {
        return "You see the spiral stair leading to the bottom of this place\n." +
                "Maybe, you'll find some treasure there, but the stairs won't let you pass easily.";
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
        return "CRYSTAL COVE";
    }

    @Override
    public String insertSouthRoom() {
        return "BONFIRE ROOM";
    }
}
